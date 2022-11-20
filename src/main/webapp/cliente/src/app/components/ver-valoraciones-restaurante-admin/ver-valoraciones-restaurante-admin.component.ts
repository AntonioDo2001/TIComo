import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Valoracion } from 'src/app/models/Valoracion';
import { ValoracionService } from 'src/app/services/valoracion.service';

@Component({
  selector: 'app-ver-valoraciones-restaurante-admin',
  templateUrl: './ver-valoraciones-restaurante-admin.component.html',
  styleUrls: ['./ver-valoraciones-restaurante-admin.component.css']
})
export class VerValoracionesRestauranteAdminComponent implements OnInit {

  nombreRestaurante = "";
  listValoraciones : Valoracion [] = [];
  listValoracionesRestaurantes : Valoracion [] = [];
  mediaValoraciones : string = "0";
  constructor(private toastr: ToastrService,private router:Router,private aRouter: ActivatedRoute,
    private _valoracionService:ValoracionService) { }

  ngOnInit(): void {
    this.nombreRestaurante = this.aRouter.snapshot.paramMap.get('nombre')!;
    this.obtenerValoracionesRestaurante();
  }


  obtenerValoracionesRestaurante(){
    this._valoracionService.getValoraciones().subscribe(data =>{
      this.listValoraciones = data;
      for(let i=0;i<this.listValoraciones.length;i++){
        if(this.listValoraciones[i].idRiderOnombreRestaurante == this.nombreRestaurante){
          this.listValoracionesRestaurantes.push(this.listValoraciones[i]);
        }
      }
      let sumatorioValoraciones = 0;
      for(let i=0;i<this.listValoracionesRestaurantes.length;i++){
        sumatorioValoraciones = sumatorioValoraciones + this.listValoracionesRestaurantes[i].valoracion;
      }
      this.mediaValoraciones = (sumatorioValoraciones / this.listValoracionesRestaurantes.length).toFixed(1);
    }, error => {
      console.log(error);

    })
  }
}