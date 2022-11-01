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
      console.log(data);
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

}
