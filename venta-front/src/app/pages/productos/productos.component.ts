import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Producto } from 'src/app/model/producto';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  dataSource = new MatTableDataSource<Producto>();
  displayedColumns = ['nombre', 'precio', 'vendido', 'robadoPerdido', 'usuarioVendedor'];

  productos:Array<Producto> = [];

  @ViewChild(MatPaginator, { static: true }) 
  paginator?: MatPaginator;

  @ViewChild(MatSort, { static: true }) 
  sort?: MatSort;
  
  constructor(
    private productoService:ProductoService
  ) {
  
   }

  ngOnInit(): void {
    this.obtenerProductos();
  }

  obtenerProductos() {
    console.log('listar');
    this.productoService.listarProductos().subscribe( res => {
      this.productos = res.data;
      this.dataSource = new MatTableDataSource(this.productos);
      //this.dataSource.paginator = this.paginator;
      //this.dataSource.sort = this.sort;
    });
  }

}
