import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Entrega } from 'src/app/models/Entrega';
import { HelperService } from 'src/app/models/HelperService';
import { ClienteService } from 'src/app/services/cliente.service';
import { EntregaService } from 'src/app/services/entrega.service';

@Component({
  selector: 'app-listar-entregas-rider',
  templateUrl: './listar-entregas-rider.component.html',
  styleUrls: ['./listar-entregas-rider.component.css']
})
export class ListarEntregasRiderComponent implements OnInit {
  idRider = "";
  listEntregas: Entrega[] = [];
  listEntregasSinAsignar: Entrega[] = [];
  constructor(private toastr: ToastrService,private helper: HelperService,private router:Router,private aRouter: ActivatedRoute,
    private _clienteService:ClienteService,private _entregaService:EntregaService) { }

  ngOnInit(): void {
    this.idRider = this.aRouter.snapshot.paramMap.get('idRider')!;
    this.helper.customMessage.subscribe(msg => this.idRider = msg);
    this.obtenerEntregasSinAsignar();
    
    this.helper.changeMessage(this.idRider);
    this.helper.customMessage.subscribe(msg => this.idRider = msg);
    
  }

  obtenerEntregasSinAsignar(){
    this._entregaService.getEntregas().subscribe(data =>{
      
      this.listEntregas = data;
      for(let i = 0 ; i < this.listEntregas.length ; i++){
        if(this.listEntregas[i].estado == "listo"){
          this.listEntregasSinAsignar.push(this.listEntregas[i]);
        }
    }
    
    }, error => {
      console.log(error);

    })

    

    
    
  }
  asignarEntregaRider(idEntrega:String|undefined){
    let numeroMaximoPedidosSimultaneos = 5;
    let numeroEntregasActivasRider = 0;
    for(let i=0;i<this.listEntregas.length;i++){
      if(this.listEntregas[i].idRider == this.idRider){
        numeroEntregasActivasRider++;
      }
    }
    if(numeroEntregasActivasRider < numeroMaximoPedidosSimultaneos){
      this._entregaService.asignarRider(idEntrega,this.idRider).subscribe(data =>{
        this.toastr.success('Se te ha asignado una entrega', 'ENTREGA ELEGIDA');
        this.listEntregasSinAsignar = [];
        this.obtenerEntregasSinAsignar();
      }, error => {
        console.log(error);
  
      })
    }
    else{
      this.toastr.error('Ya tienes 5 repartos activos', 'ERROR AL ELEGIR ENTREGA');
    }


  }

}
