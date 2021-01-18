import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm:FormGroup;
  loading:boolean=false;

  constructor(private autService:AuthService,
    private router: Router,
    private formBuilder: FormBuilder,
    private matSnackBar: MatSnackBar) {
      this.loginForm = this.formBuilder.group({
        username: ['', Validators.required],
        password: ['', Validators.required]
      });
     }

  ngOnInit(): void {
    
  }

  login():void {
    this.loading = true;
    let username = this.loginForm.value['username'];
    let password = this.loginForm.value['password'];
    this.autService.login(username, password).subscribe(res => {
      this.loading = false;
      sessionStorage.setItem(environment.token, res.accessToken);
      sessionStorage.setItem(environment.USER_INFO, JSON.stringify(res.usuario));
      this.router.navigateByUrl('/productos');
    }, err => {},
    () => { this.loading = false});
  }

}
