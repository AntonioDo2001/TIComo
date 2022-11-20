import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/Cliente';
import { Entrega } from 'src/app/models/Entrega';
import { HelperService } from 'src/app/models/HelperService';
import { Pedido } from 'src/app/models/Pedido';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-listar-pedidos-realizados-cliente',
  templateUrl: './listar-pedidos-realizados-cliente.component.html',
  styleUrls: ['./listar-pedidos-realizados-cliente.component.css']
})
export class ListarPedidosRealizadosClienteComponent implements OnInit {
  idCliente = "";
  listPedidos: Pedido[] = [];
  listPedidosRealizados: Pedido[] = [];
  
  constructor( private _pedidoService: PedidoService, private toastr: ToastrService,private helper: HelperService,private router:Router,private aRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.idCliente = this.aRouter.snapshot.paramMap.get('idCliente')!;
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
    this.obtenerPedidos();
    
    this.helper.changeMessage(this.idCliente);
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
  }
  obtenerPedidos(){

    this._pedidoService.obtenerPedidosCliente(this.idCliente).subscribe(data =>{
      
      this.listPedidos = data;
      for(let i = 0 ; i < this.listPedidos.length ; i++){
        if(this.listPedidos[i].pedidoRealizado == true){
          this.listPedidosRealizados.push(this.listPedidos[i]);
        }
    }
    }, error => {
      console.log(error);

    })
    
    

    
  }

  

}
