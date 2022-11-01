import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Plato } from '../models/Plato';

@Injectable({
  providedIn: 'root'
})
export class PlatoService {
  url = 'http://localhost:8080/ticomo/platos/';

  constructor( private http: HttpClient) { }

  getPlatos(): Observable<any> {
    return this.http.get(this.url);
  }

  eliminarPlato(id: String): Observable<any> {
    return this.http.delete(this.url + id);
  }

  guardarPlato(plato: Plato) : Observable<any>{
    return this.http.post(this.url, plato);
  }

  obtenerPlato(id : String): Observable<any>{
    return this.http.get(this.url + id);

  }
  editarPlato(id: String, plato:Plato): Observable<any>{
    return this.http.put(this.url + id, plato);
  }


}