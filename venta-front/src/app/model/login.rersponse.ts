import { Usuario } from "./usuario";

export interface LoginResponse {
    usuario:Usuario;
    accessToken:string;
    tokenType: string;
}