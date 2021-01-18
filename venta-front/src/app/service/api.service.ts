import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ResponseApiBase } from '../model/response.api.base';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    public http: HttpClient
  ) { }

    /**
   * API Pethod GET
   * @param path 
   */
  public  get(path:string) {
    return this.http.get<ResponseApiBase>(`${path}`, this._getOptions)
    .pipe(
      map(res => res)
    );
  }

   /**
   * API Pethod POST
   * @param path 
   */
  public post(path:string, data:Object) {
    return this.http.post<ResponseApiBase>(`${path}`, data, this._getOptions)
    .pipe(
      map(res => res)
    );
  }

   /**
   * API Pethod PUT
   * @param path 
   */
  public put(path:string, data:Object) {
    return this.http.put<ResponseApiBase>(`${path}`, data, this._getOptions)
    .pipe(
      map(res => res)
    );
  }

   /**
   * API Pethod DELETE
   * @param path 
   */
  public delete(path:string) {
    return this.http.delete<ResponseApiBase>(`${path}`, this._getOptions)
    .pipe(
      map(res => res)
    );
  }



  private get _getOptions() {
    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ` + sessionStorage.getItem(environment.token)
      })
    }
  }
}
