import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Valoracion } from '../models/Valoracion';

@Injectable({
  providedIn: 'root'
})
export class ValoracionService {
  url = 'http://localhost:8080/ticomo/valoraciones/';

  constructor( private http: HttpClient) { }

  getValoraciones(): Observable<any> {
    return this.http.get(this.url);
  }

  nuevaValoracion(valoracion: Valoracion): Observable<any> {
    return this.http.post(this.url,valoracion);
  }



}