import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PerdidoComponent } from './pages/perdido/perdido.component';
import { ProductosComponent } from './pages/productos/productos.component';
import { VendidoComponent } from './pages/vendido/vendido.component';
import { GuardService } from './service/guard.service';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'vendidos', component: VendidoComponent, canActivate: [GuardService]},
  {path: 'perdidos', component: PerdidoComponent, canActivate: [GuardService]},
  {path: 'productos', component: ProductosComponent, canActivate: [GuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
