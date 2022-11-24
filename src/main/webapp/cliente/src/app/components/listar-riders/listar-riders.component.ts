import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Rider } from 'src/app/models/Rider';
import { RiderService } from 'src/app/services/rider.service';

@Component({
  selector: 'app-listar-riders',
  templateUrl: './listar-riders.component.html',
  styleUrls: ['./listar-riders.component.css']
})
export class ListarRidersComponent implements OnInit {
  listRiders: Rider[] = [];
  
  constructor( private _riderService: RiderService, private toastr: ToastrService) { }


  ngOnInit(): void {
    this.obtenerRiders();
  }


  obtenerRiders(){
    this._riderService.getRiders().subscribe(data =>{
      this.listRiders = data;
    }, error => {
      console.log(error);

    })
    
  }
  eliminarRider(id: any){
    this._riderService.eliminarRider(id).subscribe(data =>{
      this.toastr.error('El rider ha sido eliminado correctamente', 'RIDER ELIMINADO');
      this.obtenerRiders();

    }, error => {
      console.log(error);
    })
  }

  activarRider(rider:Rider){
    if(rider.cuentaActiva == true){
      this.toastr.error('La cuenta del rider ya estaba activa', 'RIDER YA ACTIVO');
    }
    else{
      rider.cuentaActiva = true;
      this._riderService.activarODesactivarRider(rider).subscribe(data =>{
        this.toastr.info('La cuenta del rider ha sido activada', 'RIDER ACTIVADO');
      }, error=>{
        console.log(error);
        this.toastr.error('Error al activar cuenta del rider', 'ERROR ACTIVACION');
      })
    }
    
  }
  desactivarRider(rider:Rider){
    if(rider.cuentaActiva == false){
      this.toastr.error('La cuenta del rider ya estaba desactivada', 'RIDER YA DESACTIVADO');
    }
    else{
      rider.cuentaActiva = false;
      this._riderService.activarODesactivarRider(rider).subscribe(data =>{
        this.toastr.info('La cuenta del rider ha sido desactivada', 'RIDER DESACTIVADO');
      }, error=>{
        console.log(error);
        this.toastr.error('Error al desactivar cuenta del rider', 'ERROR DESACTIVACION');
      })
    }
    
  }

}
