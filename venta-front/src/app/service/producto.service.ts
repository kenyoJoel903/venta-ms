import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Producto } from '../model/producto';
import { ResponseApiCollection } from '../model/response.api.collection';
import { ResponseApiObject } from '../model/response.api.object';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  host:string = `${environment.apiProductos}productos/`

  constructor(
    private apisService: ApiService
  ) { }

  create(nombre:string, precio:number) {
    let prod = {
      'nombre': nombre,
      'precio': precio
    }
    return this.apisService.post(`${this.host}`, prod).pipe(
      map((res:ResponseApiObject<Producto>) => res)
    );
  }

  update(nombre:string, precio:number, vendido:boolean, perdido:boolean) {
    let prod = {
      "nombre": nombre,
        "precio": precio,
        "vendido": vendido,
        "robadoPerdido": perdido
    }
    return this.apisService.put(`${this.host}`, prod).pipe(
      map((res:ResponseApiObject<Producto>) => res)
    );
  }

  listarProductos() {
    return this.apisService.get(`${this.host}`).pipe(
      map((res:ResponseApiCollection<Producto>) => res)
    );
  }

  listarpendientesVender() {
    return this.apisService.get(`${this.host}listarPendientesPorVender`).pipe(
      map((res:ResponseApiCollection<Producto>) => res)
    );
  }

  listarPorVendedor() {
    return this.apisService.get(`${this.host}listarPorVendedor`).pipe(
      map((res:ResponseApiCollection<Producto>) => res)
    );
  }

  porId(id:number) {
    return this.apisService.get(`${this.host}${id}`).pipe(
      map((res:ResponseApiCollection<Producto>) => res)
    );
  }

  deliminar(id:number) {
    return this.apisService.delete(`${this.host}${id}`).pipe(
      map(res=> res)
    );
  }

  registrarVenta(id:number){
    return this.apisService.put(`${this.host}vender/${id}`, {}).pipe(
      map((res:ResponseApiObject<Producto>) => res)
    );
  }

  registrarPerdido(id:number){
    return this.apisService.put(`${this.host}registarPerdido/${id}`, {}).pipe(
      map((res:ResponseApiObject<Producto>) => res)
    );
  }
}
