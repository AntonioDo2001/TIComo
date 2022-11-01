import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';
@Component({
  selector: 'app-listar-clientes',
  templateUrl: './listar-clientes.component.html',
  styleUrls: ['./listar-clientes.component.css']
})
export class ListarClientesComponent implements OnInit {
  listClientes: Cliente[] = [];
  
  constructor( private _clienteService: ClienteService, private toastr: ToastrService) { }


  ngOnInit(): void {
    this.obtenerClientes();
  }


  obtenerClientes(){
    this._clienteService.getClientes().subscribe(data =>{
      console.log(data);
      this.listClientes = data;
    }, error => {
      console.log(error);

    })
    
  }
  eliminarCliente(id: any){
    this._clienteService.eliminarCliente(id).subscribe(data =>{
      this.toastr.error('El cliente ha sido eliminado correctamente', 'CLIENTE ELIMINADO');
      this.obtenerClientes();

    }, error => {
      console.log(error);
    })
  }

}
