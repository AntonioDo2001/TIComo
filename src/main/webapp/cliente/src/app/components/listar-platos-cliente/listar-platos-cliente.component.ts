import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HelperService } from 'src/app/models/HelperService';
import { Pedido } from 'src/app/models/Pedido';
import { Plato } from 'src/app/models/Plato';
import { PedidoService } from 'src/app/services/pedido.service';
import { PlatoService } from 'src/app/services/plato.service';

@Component({
  selector: 'app-listar-platos-cliente',
  templateUrl: './listar-platos-cliente.component.html',
  styleUrls: ['./listar-platos-cliente.component.css']
})
export class ListarPlatosClienteComponent implements OnInit {
  idCliente = ""
  listPlatos: Plato[] = [];
  listPedidos: Pedido[] = [];
  
  constructor( private _platoService: PlatoService, private toastr: ToastrService,private helper: HelperService,private _pedidoService: PedidoService,private router:Router) { }

  ngOnInit(): void {
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
    this.obtenerPlatos();
    this.helper.changeMessage(this.idCliente);
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
    
  }
  obtenerPlatos(){
    this._platoService.getPlatos().subscribe(data =>{
      this.listPlatos = data;
    }, error => {
      console.log(error);

    })
    
  }

  comprobarPlatoMismoRestaurante(nombreRestaurante:String){
    this._pedidoService.obtenerPedidosCliente(this.idCliente).subscribe(data =>{
      this.listPedidos = data;
      let listPedidosSinRealizar : Pedido [] = [];

      for(let i=0;i<this.listPedidos.length;i++){
        if(this.listPedidos[i].pedidoRealizado == false){
          listPedidosSinRealizar.push(this.listPedidos[i]);
        }
      }
      if(listPedidosSinRealizar.length>0){
        if(listPedidosSinRealizar[0].nombreRestaurante != nombreRestaurante){
          this.toastr.error('Los pedidos deben ser todos del mismo restaurante', 'ERROR AL REALIZAR PEDIDO');
          this.router.navigate(['/listar-platos-cliente']);
        }
      }
      
    }, error => {
      console.log(error);

    })
  }

}
