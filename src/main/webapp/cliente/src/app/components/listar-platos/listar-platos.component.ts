import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Plato } from 'src/app/models/Plato';
import { PlatoService } from 'src/app/services/plato.service';

@Component({
  selector: 'app-listar-platos',
  templateUrl: './listar-platos.component.html',
  styleUrls: ['./listar-platos.component.css']
})
export class ListarPlatosComponent implements OnInit {

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
  eliminarPlato(id: any){
    this._platoService.eliminarPlato(id).subscribe(data =>{
      this.toastr.error('El plato ha sido eliminado correctamente', 'PLATO ELIMINADO');
      this.obtenerPlatos();

    }, error => {
      console.log(error);
    })
  }

}
