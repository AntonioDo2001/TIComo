import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';


@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {
  clienteForm: FormGroup;
  titulo = 'CREAR CLIENTE';
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
    this.id = this.aRouter.snapshot.paramMap.get('id')!;
    console.log(this.id);
  }

  ngOnInit(): void {
    this.esEditar();
  }
  agregarCliente(){
    let camposRellenos = false;
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
    else{
      camposRellenos = true;
    }
    
    var CLIENTE = new Cliente(this.clienteForm.get('nombre')?.value,this.clienteForm.get('apellidos')?.value,this.clienteForm.get('nif')?.value,
    this.clienteForm.get('direccionCompleta')?.value,this.clienteForm.get('telefono')?.value,this.clienteForm.get('email')?.value,this.clienteForm.get('password')?.value
    )

    if(camposRellenos){
      if(this.id !==null){
        //editamos Cliente
        this._clienteService.editarCliente(this.id,CLIENTE).subscribe(data => {
          var jsonRespuesta : JSON = data;
          var respuesta : string = JSON.stringify(jsonRespuesta);
          
          if(respuesta.includes("errorPassword")){
           this.toastr.error('Formato de contraseña incorrecto. Debe contener al menos 8 caracteres, 1 mayúscula, 1 minúscula y 1 número', 'PASSWORD INCORRECTA');
           this.clienteForm.get('password')?.reset;
          }
          else if(respuesta.includes("emailFormato")){
            this.toastr.error('El formato del email es incorrecto. Debe seguir un formato <<nombreCorreo@correo.terminacion>>', 'FORMATO DE EMAIL INVÁLIDO');
           }
           else if(respuesta.includes("tlfFormErr")){
            this.toastr.error('El formato del telefono es incorrecto. Debe ser un número de 9 dígitos', 'FORMATO DE TELEFONO INVÁLIDO');
           }
          else{
            this.toastr.info('El Cliente ha sido modificado correctamente!', 'CLIENTE MODIFICADO');
            this.router.navigate(['/listar-clientes']);
          }
        }, error => {
          console.log(error);
          this.clienteForm.reset();
          this.toastr.error('Datos introducidos erroneos!!', 'ERROR AL GUARDAR CLIENTE');
        })
      } else{
        //agregamos Cliente
        this._clienteService.guardarCliente(CLIENTE).subscribe(data => {
          var jsonRespuesta : JSON = data;
          var respuesta : string = JSON.stringify(jsonRespuesta);
          if(respuesta.includes("errorPassword")){
           this.toastr.error('Formato de contraseña incorrecto. Debe contener al menos 8 caracteres, 1 mayúscula, 1 minúscula y 1 número', 'PASSWORD INCORRECTA');
           this.clienteForm.get('password')?.reset;
          }
          else if(respuesta.includes("emailFormato")){
            this.toastr.error('El formato del email es incorrecto. Debe seguir un formato <<nombreCorreo@correo.terminacion>>', 'FORMATO DE EMAIL INVÁLIDO');
           }
           else if(respuesta.includes("tlfFormErr")){
            this.toastr.error('El formato del telefono es incorrecto. Debe ser un número de 9 dígitos', 'FORMATO DE TELEFONO INVÁLIDO');
           }
          else{
            this.toastr.success('El Cliente introducido se ha guardado correctamente!', 'CLIENTE GUARDADO');
            this.router.navigate(['/listar-clientes']);
          }
        
        }, error => {
          console.log(error);
          this.clienteForm.reset();
          this.toastr.error('Datos introducidos erroneos!!', 'ERROR AL GUARDAR CLIENTE');
        })
      }

    }else{
      this.toastr.error('Hay campos sin rellenar', 'HAY CAMPOS INCOMPLETOS');
    }
    

    
  }

  esEditar() {
    if(this.id !== null){
      this.titulo = 'EDITAR CLIENTE';
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

  }

}
