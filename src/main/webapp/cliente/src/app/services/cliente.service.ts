import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  url = 'http://localhost:8080/ticomo/clientes/';

  constructor( private http: HttpClient) { }

  getClientes(): Observable<any> {
    return this.http.get(this.url);
  }

  eliminarCliente(id: String): Observable<any> {
    return this.http.delete(this.url + id);
  }

  guardarCliente(cliente: Cliente) : Observable<any>{
    return this.http.post(this.url, cliente);
  }

  obtenerCliente(id : String): Observable<any>{
    return this.http.get(this.url + id);

  }
  editarCliente(id: String, cliente:Cliente): Observable<any>{
    return this.http.put(this.url + id, cliente);
  }


}
