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

  activarCliente(cliente:Cliente){
    if(cliente.cuentaActiva == true){
      this.toastr.error('La cuenta del cliente ya estaba activa', 'CLIENTE YA ACTIVO');
    }
    else{
      cliente.cuentaActiva = true;
      this._clienteService.activarODesactivarCliente(cliente).subscribe(data =>{
        this.toastr.info('La cuenta del cliente ha sido activada', 'CLIENTE ACTIVADO');
      }, error=>{
        console.log(error);
        this.toastr.error('Error al activar cuenta del cliente', 'ERROR ACTIVACION');
      })
    }
    
  }
  desactivarCliente(cliente:Cliente){
    if(cliente.cuentaActiva == false){
      this.toastr.error('La cuenta del cliente ya estaba desactivada', 'CLIENTE YA DESACTIVADO');
    }
    else{
      cliente.cuentaActiva = false;
      this._clienteService.activarODesactivarCliente(cliente).subscribe(data =>{
        this.toastr.info('La cuenta del cliente ha sido desactivada', 'CLIENTE DESACTIVADO');
      }, error=>{
        console.log(error);
        this.toastr.error('Error al desactivar cuenta del cliente', 'ERROR DESACTIVACION');
      })
    }
    
  }

}
