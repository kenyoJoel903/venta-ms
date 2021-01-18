import { Injectable } from '@angular/core';

import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpResponse } from '@angular/common/http';
import { Observable, EMPTY } from 'rxjs';
import { tap, catchError, retry } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ServerErrorsInterceptorService implements HttpInterceptor{

  reintentos:any = 3;

  constructor(
    private _matSnackBar: MatSnackBar,
    private _router: Router
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler):  Observable<HttpEvent<any>> {
    return next.handle(request).pipe(retry(3)).
            pipe(tap(event => {
                if (event instanceof HttpResponse) {
                    if (event.body && event.body.error === true && event.body.errorMessage) {
                        throw new Error(event.body.errorMessage);
                    }/*else{
                        this.snackBar.open("EXITO", 'AVISO', { duration: 5000 });    
                    }*/
                }
            })).pipe(catchError((err) => {
                this.showError(err);
                //https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
                if (err.status === 400) {
                    //this.snackBar.open(err.error.mensaje, 'ERROR 400', { duration: 5000 });
                }
                else if (err.status === 401) {
                    //this.snackBar.open(err.error.mensaje, 'ERROR 401', { duration: 5000 });
                    //this.router.navigate(['/login']);
                }
                else if (err.status === 500) {
                    //this.snackBar.open(err.error.mensaje, 'ERROR 500', { duration: 5000 });
                } else if (err.status == 404) {

                }else {
                    //this.snackBar.open(err.error.mensaje, 'ERROR', { duration: 5000 });
                }
                return EMPTY;
            }));
  }

  private showError(err:any):void {
      if(err.error.message) {
          let message = err.error.message;
            this._matSnackBar.open(message, 'Error :(', {
                duration: 5000,
            });
      } else {
        this._matSnackBar.open('Ocurrió un error al realizar esta operación', 'Error :(', {
            duration: 5000,
        });
      }
      setTimeout(() => {
          if(err.status === 401) {
            this._router.navigate(['/login'])
          }
      }, 5500);
  }

}
