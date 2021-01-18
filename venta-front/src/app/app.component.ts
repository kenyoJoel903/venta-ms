import { Component, OnInit } from '@angular/core';
import { menu } from './constant/constant';
import { AuthService } from './service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'venta-front';
  menus:Array<any> = menu;
 

  constructor(public authService: AuthService){}

  ngOnInit() {
    console.log("menu");
    this.menus = menu;
    console.log("menu", this.menus);
  }
}
