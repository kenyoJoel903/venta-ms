import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate{

  constructor(private authService:AuthService,
    private router: Router) { 
    

  }

  canActivate(route:ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const helper = new JwtHelperService();
    if(!this.authService.isLogin()) {
      sessionStorage.clear();
      this.router.navigate(['login']);
      return false;
    } else  {
      let token:string = sessionStorage.getItem(environment.token) || '';
      if(!helper.isTokenExpired(token)) {
        let url = state.url;
        return true;
      } else  {
        sessionStorage.clear();
        this.router.navigate(['login']);
        return false;
      }
    }
  }
}
