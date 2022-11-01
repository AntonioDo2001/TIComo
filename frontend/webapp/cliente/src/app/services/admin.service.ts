import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../models/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  url = 'http://localhost:8080/ticomo/admins/';

  constructor( private http: HttpClient) { }

  getAdmins(): Observable<any> {
    return this.http.get(this.url);
  }

  eliminarAdmin(id: String): Observable<any> {
    return this.http.delete(this.url + id);
  }

  guardarAdmin(admin: Admin) : Observable<any>{
    return this.http.post(this.url, admin);
  }

  obtenerAdmin(id : String): Observable<any>{
    return this.http.get(this.url + id);

  }
  editarAdmin(id: String, admin:Admin): Observable<any>{
    return this.http.put(this.url + id, admin);
  }


}