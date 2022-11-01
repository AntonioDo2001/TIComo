import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject} from 'rxjs';
import { Cliente } from '../models/Cliente';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  url = 'http://localhost:8080/ticomo/authentication/';
  authSubject = new BehaviorSubject(false);
  private token: string | null;

  constructor( private http: HttpClient) {
    this.token = '';
  }

  registerCliente(cliente: Cliente) : Observable<any>{
    return this.http.post(this.url + "register", cliente);
  }

  loginUser( email : string, password : string): Observable<any>{
    var urlLogin : string = this.url + "login/" + email + "/" + password;
    console.log(urlLogin);
    return this.http.get(urlLogin);
  }
  

}