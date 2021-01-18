import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { LoginResponse } from '../model/login.rersponse';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  urlApi:string = `${environment.apiAuth}`

  constructor(private htto: HttpClient) { }

  login(userName:string, password:string) {
    let loginRequest = {
      "username": userName,
      "password": password
    };
    return this.htto.post<LoginResponse>(`${this.urlApi}security`, loginRequest).pipe(
      map(res => res)
    );
  }

  isLogin():boolean {
    let token = sessionStorage.getItem(environment.token);
    console.log(token);
    return token!= null;
  }

  closeSession():void {
    sessionStorage.clear();
  }
}
