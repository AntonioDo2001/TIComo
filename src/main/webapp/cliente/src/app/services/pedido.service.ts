import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Entrega } from '../models/Entrega';
import { Pedido } from '../models/Pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  url = 'http://localhost:8080/ticomo/pedidos/';

  constructor( private http: HttpClient) { }

  getPedidos(): Observable<any> {
    return this.http.get(this.url);
  }

  eliminarPedido(id: String): Observable<any> {
    return this.http.delete(this.url + id);
  }

  guardarPedido(pedido: Pedido) : Observable<any>{
    return this.http.post(this.url, pedido);
  }

  obtenerPedidosCliente(idCliente : String): Observable<any>{
    return this.http.get(this.url + idCliente);

  }


  pedidoRealizado(id: String | undefined, entrega : Entrega): Observable<any>{
    return this.http.put(this.url + id,entrega);

  pedidoRealizado(id: String | undefined, pedido:Pedido): Observable<any>{
    return this.http.put(this.url + id,pedido);

  }
  


}