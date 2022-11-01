import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rider } from '../models/Rider';

@Injectable({
  providedIn: 'root'
})
export class RiderService {
  url = 'http://localhost:8080/ticomo/riders/';

  constructor( private http: HttpClient) { }

  getRiders(): Observable<any> {
    return this.http.get(this.url);
  }

  eliminarRider(id: String): Observable<any> {
    return this.http.delete(this.url + id);
  }

  guardarRider(rider: Rider) : Observable<any>{
    return this.http.post(this.url, rider);
  }

  obtenerRider(id : String): Observable<any>{
    return this.http.get(this.url + id);

  }
  editarRider(id: String, rider:Rider): Observable<any>{
    return this.http.put(this.url + id, rider);
  }


}
