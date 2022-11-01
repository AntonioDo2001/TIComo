import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Plato } from 'src/app/models/Plato';
import { PlatoService } from 'src/app/services/plato.service';

@Component({
  selector: 'app-listar-platos-cliente',
  templateUrl: './listar-platos-cliente.component.html',
  styleUrls: ['./listar-platos-cliente.component.css']
})
export class ListarPlatosClienteComponent implements OnInit {

  listPlatos: Plato[] = [];
  
  constructor( private _platoService: PlatoService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.obtenerPlatos();
  }
  obtenerPlatos(){
    this._platoService.getPlatos().subscribe(data =>{
      console.log(data);
      this.listPlatos = data;
    }, error => {
      console.log(error);

    })
    
  }

}
