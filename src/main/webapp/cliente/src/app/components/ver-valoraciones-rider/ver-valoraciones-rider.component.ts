import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Valoracion } from 'src/app/models/Valoracion';
import { ValoracionService } from 'src/app/services/valoracion.service';

@Component({
  selector: 'app-ver-valoraciones-rider',
  templateUrl: './ver-valoraciones-rider.component.html',
  styleUrls: ['./ver-valoraciones-rider.component.css']
})
export class VerValoracionesRiderComponent implements OnInit {

  idRider = "";
  listValoraciones : Valoracion [] = [];
  listValoracionesRider : Valoracion [] = [];
  mediaValoraciones : string = "";
  constructor(private toastr: ToastrService,private router:Router,private aRouter: ActivatedRoute,
    private _valoracionService:ValoracionService) { }

  ngOnInit(): void {
    this.idRider = this.aRouter.snapshot.paramMap.get('id')!;
    this.obtenerValoracionesRider();
  }


  obtenerValoracionesRider(){
    this._valoracionService.getValoraciones().subscribe(data =>{
      this.listValoraciones = data;
      for(let i=0;i<this.listValoraciones.length;i++){
        if(this.listValoraciones[i].idRiderOnombreRestaurante == this.idRider){
          this.listValoracionesRider.push(this.listValoraciones[i]);
        }
      }
      let sumatorioValoraciones = 0;
      for(let i=0;i<this.listValoracionesRider.length;i++){
        sumatorioValoraciones = sumatorioValoraciones + this.listValoracionesRider[i].valoracion;
      }
      this.mediaValoraciones = (sumatorioValoraciones / this.listValoracionesRider.length).toFixed(1);
    }, error => {
      console.log(error);

    })
  }
}
