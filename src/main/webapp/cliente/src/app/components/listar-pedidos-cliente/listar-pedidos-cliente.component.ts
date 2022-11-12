import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HelperService } from 'src/app/models/HelperService';
import { Pedido } from 'src/app/models/Pedido';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-listar-pedidos-cliente',
  templateUrl: './listar-pedidos-cliente.component.html',
  styleUrls: ['./listar-pedidos-cliente.component.css']
})
export class ListarPedidosClienteComponent implements OnInit {
  idCliente = "";
  listPedidos: Pedido[] = [];
  
  constructor( private _pedidoService: PedidoService, private toastr: ToastrService,private helper: HelperService,private router:Router,private aRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.idCliente = this.aRouter.snapshot.paramMap.get('idCliente')!;
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
    console.log(this.idCliente);
    this.obtenerPedidos();
    this.helper.changeMessage(this.idCliente);
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
  }
  obtenerPedidos(){
    console.log("El id es")
    console.log(this.idCliente)
    this._pedidoService.obtenerPedidosCliente(this.idCliente).subscribe(data =>{
      console.log(data);
      this.listPedidos = data;
    }, error => {
      console.log(error);

    })
    
  }

}
