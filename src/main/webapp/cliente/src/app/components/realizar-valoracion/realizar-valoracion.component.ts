import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Entrega } from 'src/app/models/Entrega';
import { Valoracion } from 'src/app/models/Valoracion';
import { EntregaService } from 'src/app/services/entrega.service';
import { ValoracionService } from 'src/app/services/valoracion.service';

@Component({
  selector: 'app-realizar-valoracion',
  templateUrl: './realizar-valoracion.component.html',
  styleUrls: ['./realizar-valoracion.component.css']
})
export class RealizarValoracionComponent implements OnInit {

  valoracionForm: FormGroup;
  idEntrega : string;
  listEntregas: Entrega[] = [];
  entrega : Entrega = new Entrega("","","","","","",0,"");

  constructor(private fbuilder: FormBuilder, private router:Router, private toastr: ToastrService, private _valoracionService:ValoracionService,
    private aRouter: ActivatedRoute,private _entregaService:EntregaService) { 
    this.valoracionForm = this.fbuilder.group({
      valoracionRider: ['', Validators.required],
      comentarioRider: [''],
      valoracionRestaurante: ['', Validators.required],
      comentarioRestaurante: ['']

    })
    
    this.idEntrega = this.aRouter.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    
    
  }
  agregarValoracion(){

    if(this.valoracionForm.get('valoracionRider')?.value < 0 || this.valoracionForm.get('valoracionRider')?.value > 5 || this.valoracionForm.get('valoracionRider')?.value == ""){
      this.toastr.error('La valoracion del rider debe estar entre 0 y 5', 'VALORACIÓN RIDER ERRONEA');
    }
    else if(this.valoracionForm.get('valoracionRestaurante')?.value < 0 || this.valoracionForm.get('valoracionRestaurante')?.value > 5 || this.valoracionForm.get('valoracionRestaurante')?.value == ""){
      this.toastr.error('La valoracion del restaurante debe estar entre 0 y 5', 'VALORACIÓN RESTAURANTE ERRONEA');
    }
    else{
      this._entregaService.getEntregas().subscribe(data =>{
        this.listEntregas = data;
        for(let i=0; i<this.listEntregas.length;i++){
          if(this.listEntregas[i].id == this.idEntrega){
            this.entrega = this.listEntregas[i];
          }
        }
        let VALORACIONRIDER = new Valoracion(this.idEntrega,"rider",this.valoracionForm.get('valoracionRider')?.value,this.valoracionForm.get('comentarioRider')?.value,
        this.entrega.idRider);
        let VALORACIONRESTAURANTE = new Valoracion(this.idEntrega,"restaurante",this.valoracionForm.get('valoracionRestaurante')?.value,this.valoracionForm.get('comentarioRestaurante')?.value,
        this.entrega.nombreRestaurante);
  
  
        this._valoracionService.nuevaValoracion(VALORACIONRIDER).subscribe(data =>{
          this.toastr.success('Se ha realizado una valoración al rider que envió su pedido', 'VALORACION REALIZADA CON EXITO');
        }, error =>{
          this.toastr.error('Error al realizar la valoración al rider', 'ERROR VALORACION');
          console.log(error);
        })
  
        this._valoracionService.nuevaValoracion(VALORACIONRESTAURANTE).subscribe(data =>{
          this.toastr.success('Se ha realizado una valoración al restaurante que hizo su pedido', 'VALORACION REALIZADA CON EXITO');
        }, error =>{
          this.toastr.error('Error al realizar la valoración al restaurante', 'ERROR VALORACION');
          console.log(error);
        })
        this._entregaService.marcarEntregaEntregado(this.entrega).subscribe(data =>{
  
        },error => {
  
        })
  
        this.router.navigate(['/pagina-principal-cliente']);
  
  
        
      }, error => {
        console.log(error);
  
      })
    }
    
    
  }

}
