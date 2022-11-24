import { Component, OnInit } from '@angular/core';
import { Toast, ToastrService } from 'ngx-toastr';
import { Restaurante } from 'src/app/models/Restaurante';
import { RestauranteService } from 'src/app/services/restaurante.service';

@Component({
  selector: 'app-listar-restaurantes-cliente',
  templateUrl: './listar-restaurantes-cliente.component.html',
  styleUrls: ['./listar-restaurantes-cliente.component.css']
})
export class ListarRestaurantesClienteComponent implements OnInit {

  listRestaurantes: Restaurante[] = [];

  constructor(private _restauranteService: RestauranteService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.obtenerRestaurantes();
  }

  obtenerRestaurantes(){
    this._restauranteService.getRestaurantes().subscribe(data =>{
      this.listRestaurantes = data;
    }, error => {
      console.log(error);

    })
    
  }


}
