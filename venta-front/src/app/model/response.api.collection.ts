import { ResponseApiBase } from "./response.api.base";

export interface ResponseApiCollection<T> extends ResponseApiBase {

    data:Array<T>;
}