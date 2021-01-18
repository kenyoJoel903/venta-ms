import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { menu } from 'src/app/constant/constant';
import { Producto } from 'src/app/model/producto';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-perdido',
  templateUrl: './perdido.component.html',
  styleUrls: ['./perdido.component.css']
})
export class PerdidoComponent implements OnInit {

  menus:Array<any> = [];

  dataSource = new MatTableDataSource<Producto>();
  displayedColumns = ['nombre', 'precio', 'usuarioModificacion','fechaModificacion'];

  productos:Array<Producto> = [];

  @ViewChild(MatPaginator, { static: true }) 
  paginator?: MatPaginator;

  @ViewChild(MatSort, { static: true }) 
  sort?: MatSort;

  constructor(
    private productoService:ProductoService
  ) { }

  ngOnInit(): void {
    this.menus = menu;
    this.obtenerProductos();
  }

  obtenerProductos() {
    console.log('listar');
    this.productoService.listarProductos().subscribe( res => {
      this.productos = res.data;
      this.productos = this.productos.filter( p => p.robadoPerdido);
      this.dataSource = new MatTableDataSource(this.productos);
      //this.dataSource.paginator = this.paginator;
      //this.dataSource.sort = this.sort;
    });
  }


}
