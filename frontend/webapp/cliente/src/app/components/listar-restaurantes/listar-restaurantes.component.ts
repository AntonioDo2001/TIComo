import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { HelperService } from 'src/app/models/HelperService';
import { Restaurante } from 'src/app/models/Restaurante';
import { RestauranteService } from 'src/app/services/restaurante.service';

@Component({
  selector: 'app-listar-restaurantes',
  templateUrl: './listar-restaurantes.component.html',
  styleUrls: ['./listar-restaurantes.component.css']
})
export class ListarRestaurantesComponent implements OnInit {
  listRestaurantes: Restaurante[] = [];


  constructor(private _restauranteService: RestauranteService, private toastr: ToastrService,private helper: HelperService) { }

  ngOnInit(): void {
    this.obtenerRestaurantes();
  }

  obtenerRestaurantes(){
    this._restauranteService.getRestaurantes().subscribe(data =>{
      console.log(data);
      this.listRestaurantes = data;
    }, error => {
      console.log(error);

    })
    
  }
  eliminarRestaurante(id: any){
    this._restauranteService.eliminarRestaurante(id).subscribe(data =>{
      this.toastr.error('El restaurante ha sido eliminado correctamente', 'RESTAURANTE ELIMINADO');
      this.obtenerRestaurantes();

    }, error => {
      console.log(error);
    })
  }
  enviaridRestaurantePlato(idRestaurante: String | undefined){
    var idRest : String = idRestaurante!;
    this.helper.changeMessage(idRest.toString());
    this.helper.customMessage.subscribe(msg => idRest = msg);
  }

}


