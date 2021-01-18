import { Usuario } from "./usuario";

export interface Producto {
    id:number;
    nombre:string;
    precio:number;
    vendido:boolean;
    robadoPerdido:string;
    fechaCreacion:String;
    usuarioCreacion: Usuario;
    fechaModificacion:string;
    usuarioModificacion:Usuario;
    usuarioVendedor:Usuario;


}