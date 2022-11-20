import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Entrega } from 'src/app/models/Entrega';
import { HelperService } from 'src/app/models/HelperService';
import { ClienteService } from 'src/app/services/cliente.service';
import { EntregaService } from 'src/app/services/entrega.service';

@Component({
  selector: 'app-listar-entregas-cliente',
  templateUrl: './listar-entregas-cliente.component.html',
  styleUrls: ['./listar-entregas-cliente.component.css']
})
export class ListarEntregasClienteComponent implements OnInit {
  idCliente = "";
  listEntregasCliente: Entrega[] = [];

  constructor(private toastr: ToastrService,private helper: HelperService,private router:Router,private aRouter: ActivatedRoute,
    private _clienteService:ClienteService,private _entregaService:EntregaService) { }

  ngOnInit(): void {

    this.idCliente = this.aRouter.snapshot.paramMap.get('idCliente')!;
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
    this.obtenerEntregasCliente();
    
    this.helper.changeMessage(this.idCliente);
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);

  }
  obtenerEntregasCliente(){
    this._entregaService.getEntregasCliente(this.idCliente).subscribe(data =>{
      this.listEntregasCliente = data;
    }, error => {
      console.log(error);

    })

    
    
  }

  comprobarEntrega(estado:String){
    if(estado!="reparto"){
      this.toastr.error('No puedes marcar como entregado una entrega que no está en reparto', 'ERROR AL MARCAR ENTREGADO');
      this.router.navigate(['/listar-entregas-cliente']);
    }
    
        
  }

 

 

}
