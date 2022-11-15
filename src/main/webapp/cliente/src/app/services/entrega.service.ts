import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Entrega } from '../models/Entrega';

@Injectable({
  providedIn: 'root'
})
export class EntregaService {
  url = 'http://localhost:8080/ticomo/entregas/';

  constructor( private http: HttpClient) { }

  getEntregas(): Observable<any> {
    return this.http.get(this.url);
  }

  getEntregasCliente(id:String): Observable<any> {
    return this.http.get(this.url + id);
  }

  eliminarEntrega(id: String): Observable<any> {
    return this.http.delete(this.url + id);
  }

  guardarEntrega(entrega: Entrega) : Observable<any>{
    return this.http.post(this.url, entrega);
  }

  asignarRider(id : String, idRider: String): Observable<any>{
    return this.http.put(this.url + id, idRider );

  }
  


}