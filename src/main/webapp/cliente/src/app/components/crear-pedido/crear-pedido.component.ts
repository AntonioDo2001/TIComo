import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HelperService } from 'src/app/models/HelperService';
import { Pedido } from 'src/app/models/Pedido';
import { Restaurante } from 'src/app/models/Restaurante';
import { PedidoService } from 'src/app/services/pedido.service';
import { PlatoService } from 'src/app/services/plato.service';

@Component({
  selector: 'app-crear-pedido',
  templateUrl: './crear-pedido.component.html',
  styleUrls: ['./crear-pedido.component.css']
})
export class CrearPedidoComponent implements OnInit {
  pedidoForm: FormGroup;
  idCliente = "";
  idPlato = "";
  nombreRestaurante : String = "";
  restauranteObtenido : Restaurante | undefined;
  

  constructor(private fbuilder: FormBuilder, private router:Router, private toastr: ToastrService, private _pedidoService:PedidoService,
    private aRouter: ActivatedRoute,private helper: HelperService, private _platoService:PlatoService) { 
      this.pedidoForm = this.fbuilder.group({
        nombrePlato: ['', Validators.required],
        precioPlato: ['', Validators.required],
        cantidadPlato: ['', Validators.required]
      })
  }

  ngOnInit(): void {
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
    this.idPlato = this.aRouter.snapshot.paramMap.get('id')!;
    this._platoService.obtenerPlato(this.idPlato).subscribe(data =>{
      this.pedidoForm.setValue({
        nombrePlato: data.nombre,
        precioPlato: data.precio,
        cantidadPlato: 1
      })
    })



    console.log(this.idCliente);
  }
  agregarPedido(){
    
    var PEDIDO = new Pedido(this.pedidoForm.get('nombrePlato')?.value,this.pedidoForm.get('precioPlato')?.value,this.pedidoForm.get('cantidadPlato')?.value,this.idCliente)

        this._pedidoService.guardarPedido(PEDIDO).subscribe(data => {
          this.toastr.success('El Pedido introducido se ha guardado correctamente!', 'PEDIDO GUARDADO');
          this.router.navigate(['/listar-pedidos']);
          }, error => {
            console.log(error);
            this.toastr.error('Error al guardar el pedido, revise los datos', 'ERROR AL REALIZAR PEDIDO ');
          })

        
    

      

    
  }




}
