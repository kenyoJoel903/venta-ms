import { ResponseApiBase } from "./response.api.base";

export interface ResponseApiObject<T> extends ResponseApiBase {
    data:T;
}