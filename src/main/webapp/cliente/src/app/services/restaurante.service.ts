import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurante } from '../models/Restaurante';

@Injectable({
  providedIn: 'root'
})
export class RestauranteService {
  url = 'http://localhost:8080/ticomo/restaurantes/';

  constructor( private http: HttpClient) { }

  getRestaurantes(): Observable<any> {
    return this.http.get(this.url);
  }

  eliminarRestaurante(id: String): Observable<any> {
    return this.http.delete(this.url + id);
  }

  guardarRestaurante(restaurante: Restaurante) : Observable<any>{
    return this.http.post(this.url, restaurante);
  }

  obtenerRestaurante(id : String): Observable<any>{
    return this.http.get(this.url + id);

  }
  editarRestaurante(id: String, restaurante:Restaurante): Observable<any>{
    return this.http.put(this.url + id, restaurante);
  }


}