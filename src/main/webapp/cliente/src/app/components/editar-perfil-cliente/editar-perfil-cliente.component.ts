import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';


@Component({
  selector: 'app-editar-perfil-cliente',
  templateUrl: './editar-perfil-cliente.component.html',
  styleUrls: ['./editar-perfil-cliente.component.css']
})
export class EditarPerfilClienteComponent implements OnInit {
  clienteForm: FormGroup;
  titulo = 'EDITAR PERFIL';
  id : String;

  constructor(private fbuilder: FormBuilder, private router:Router, private toastr: ToastrService, private _clienteService:ClienteService,
    private aRouter: ActivatedRoute) { 
    this.clienteForm = this.fbuilder.group({
      nombre: ['', Validators.required],
      apellidos: ['', Validators.required],
      nif: ['', Validators.required],
      direccionCompleta: ['', Validators.required],
      telefono: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required]

    })
    this.id = this.aRouter.snapshot.paramMap.get('idCliente')!;
    console.log(this.id);
  }

  ngOnInit(): void {
    this._clienteService.obtenerCliente(this.id).subscribe(data =>{
      this.clienteForm.setValue({
        nombre: data.nombre,
        apellidos: data.apellidos,
        nif: data.nif,
        direccionCompleta: data.direccionCompleta,
        telefono: data.telefono,
        email: data.email,
        password: data.password
      })
    })
    
  }

  editarCliente(){
    var CLIENTE = new Cliente(this.clienteForm.get('nombre')?.value,this.clienteForm.get('apellidos')?.value,this.clienteForm.get('nif')?.value,
    this.clienteForm.get('direccionCompleta')?.value,this.clienteForm.get('telefono')?.value,this.clienteForm.get('email')?.value,this.clienteForm.get('password')?.value
    )
    this._clienteService.editarCliente(this.id,CLIENTE).subscribe(data => {
      var jsonRespuesta : JSON = data;
        var respuesta : string = JSON.stringify(jsonRespuesta);
        if(this.clienteForm.get('nombre')?.value == ""){
          this.toastr.error('Debes introducir un nombre', 'CAMPO NOMBRE SIN RELLENAR');
        }
        else if(this.clienteForm.get('apellidos')?.value == ""){
          this.toastr.error('Debes introducir los apellidos', 'CAMPO APELLIDOS SIN RELLENAR');
        }
        else if(this.clienteForm.get('nif')?.value == ""){
          this.toastr.error('Debes introducir el NIF', 'CAMPO NIF SIN RELLENAR');
        }
        else if(this.clienteForm.get('direccionCompleta')?.value == ""){
          this.toastr.error('Debes introducir la direccion completa', 'CAMPO DIRECCION COMPLETA SIN RELLENAR');
        }
        else if(this.clienteForm.get('telefono')?.value == ""){
          this.toastr.error('Debes introducir un telefono', 'CAMPO TELEFONO SIN RELLENAR');
        }
        else if(this.clienteForm.get('email')?.value == ""){
          this.toastr.error('Debes introducir un email', 'CAMPO EMAIL SIN RELLENAR');
        }
        else if(this.clienteForm.get('password')?.value == ""){
          this.toastr.error('Debes introducir un password', 'CAMPO PASSWORD SIN RELLENAR');
        }
        else if(respuesta.includes("errorPassword")){
         this.toastr.error('Formato de contraseña incorrecto. Debe contener al menos 8 caracteres, 1 mayúscula, 1 minúscula y 1 número', 'PASSWORD INCORRECTA');
        }
        else{
          this.toastr.info('El perfil ha sido modificado correctamente!', 'PERFIL MODIFICADO');
          this.router.navigate(['/pagina-principal-cliente']);
        }
 

    }, error => {
      console.log(error);
      this.clienteForm.reset();
      this.toastr.error('Datos introducidos erroneos!!', 'ERROR AL GUARDAR PERFIL');
    })

  }



  
}