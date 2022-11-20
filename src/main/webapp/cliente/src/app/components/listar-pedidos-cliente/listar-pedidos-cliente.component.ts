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
  nombreRestaurante:String = "";
  idEntrega : String|undefined = "";
  listPedidos: Pedido[] = [];
  listPedidosSinRealizar: Pedido[] = [];
  cliente: Cliente = new Cliente("","","","","","","")
  
  constructor( private _pedidoService: PedidoService, private toastr: ToastrService,private helper: HelperService,private router:Router,private aRouter: ActivatedRoute,
    private _clienteService:ClienteService,private _entregaService:EntregaService) { }

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
    var pedidosRealizados = "";
    var precioTotal = 0;
    for(let i=0;i<this.listPedidosSinRealizar.length; i++){
      pedidosRealizados = pedidosRealizados + this.listPedidosSinRealizar[i].nombrePlato + " -> Cantidad: " + this.listPedidosSinRealizar[i].cantidadPlato + " Precio plato: " 
      +this.listPedidosSinRealizar[i].precioPlato + " | ";
      precioTotal = precioTotal + this.listPedidosSinRealizar[i].precioTotal;
    }
    if(this.listPedidosSinRealizar.length == 0){
      this.toastr.error('No tiene ningún pedido que pueda pagar', 'ERROR AL PAGAR');
    }
    else{
      this.nombreRestaurante = this.listPedidosSinRealizar[0].nombreRestaurante;
      var ENTREGA = new Entrega(data.id,data.nombre,data.apellidos,data.direccionCompleta,data.telefono,pedidosRealizados,precioTotal,this.nombreRestaurante)
    this._entregaService.guardarEntrega(ENTREGA).subscribe(data => {
      this.idEntrega = data.id;
      
      ENTREGA.setid(this.idEntrega);
      for(let i = 0 ; i < this.listPedidosSinRealizar.length ; i++){
        this._pedidoService.pedidoRealizado(this.listPedidosSinRealizar[i].id, ENTREGA).subscribe(data => {
          }, error => {
            console.log(error);
            this.toastr.error('Error al realizar pedido', 'ERROR AL MARCAR PEDIDO COMO REALIZADO ');
          })
    }
      this.toastr.success('Se ha creado una entrega con estos pedidos', 'ENTREGA CREADA');
      }, error => {
        console.log(error);
        this.toastr.error('Error al crear la entrega', 'ERROR AL CREAR ENTREGA ');
      })
    }
    
      this.cliente = data;
    }, error => {
      console.log(error);

    })

    
          
  }

  eliminarPedido(id: any){
    this._pedidoService.eliminarPedido(id).subscribe(data =>{
      this.toastr.error('El pedido ha sido eliminado correctamente', 'PEDIDO ELIMINADO');
      this.listPedidosSinRealizar = [];
      this.obtenerPedidos();
      

    }, error => {
      console.log(error);
    })
  }

}
