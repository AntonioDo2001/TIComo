import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/Cliente';
import { Entrega } from 'src/app/models/Entrega';
import { HelperService } from 'src/app/models/HelperService';
import { Pedido } from 'src/app/models/Pedido';
import { ClienteService } from 'src/app/services/cliente.service';
import { EntregaService } from 'src/app/services/entrega.service';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-listar-pedidos-cliente',
  templateUrl: './listar-pedidos-cliente.component.html',
  styleUrls: ['./listar-pedidos-cliente.component.css']
})
export class ListarPedidosClienteComponent implements OnInit {
  idCliente = "";
  listPedidos: Pedido[] = [];
  listPedidosSinRealizar: Pedido[] = [];
  cliente: Cliente = new Cliente("","","","","","","")
  
  constructor( private _pedidoService: PedidoService, private toastr: ToastrService,private helper: HelperService,private router:Router,private aRouter: ActivatedRoute,
    private _clienteService:ClienteService,private _entregaService:EntregaService) { }

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
      for(let i = 0 ; i < this.listPedidos.length ; i++){
        if(this.listPedidos[i].pedidoRealizado == false){
          this.listPedidosSinRealizar.push(this.listPedidos[i]);
        }
    }
    }, error => {
      console.log(error);

    })

    
    
  }

  pagarPedidos(){

    this._clienteService.obtenerCliente(this.idCliente).subscribe(data =>{
      console.log(data);
      this.cliente = data;
    }, error => {
      console.log(error);

    })

    var ENTREGA = new Entrega(this.idCliente,this.cliente.nombre,this.cliente.apellidos,this.cliente.direccionCompleta,this.cliente.telefono)
    this._entregaService.guardarEntrega(ENTREGA).subscribe(data => {
      this.toastr.success('Se ha crado una entrega con estos pedidos', 'ENTREGA CREADA');
      }, error => {
        console.log(error);
        this.toastr.error('Error al crear la entrega', 'ERROR AL CREAR ENTREGA ');
      })

      for(let i = 0 ; i < this.listPedidosSinRealizar.length ; i++){
        console.log(this.listPedidosSinRealizar[i])
        this._pedidoService.pedidoRealizado(this.listPedidosSinRealizar[i].id, this.listPedidosSinRealizar[i]).subscribe(data => {
          }, error => {
            console.log(error);
            this.toastr.error('Error al realizar pedido', 'ERROR AL MARCAR PEDIDO COMO REALIZADO ');
          })
    }
  }

}
