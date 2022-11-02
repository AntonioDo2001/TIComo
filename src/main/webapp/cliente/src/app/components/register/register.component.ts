import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Cliente } from 'src/app/models/Cliente';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;

  constructor(private fbuilder: FormBuilder,private authenticationService:AuthenticationService, private router:Router,private toastr: ToastrService,private _authService:AuthenticationService) { 
    this.registerForm = this.fbuilder.group({
      nombre: ['', Validators.required],
      apellidos: ['', Validators.required],
      nif: ['', Validators.required],
      direccionCompleta: ['', Validators.required],
      telefono: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required]

    })
  }

  ngOnInit(): void {
  }

  onRegister():void {
    let camposRellenos = false;
    var CLIENTE = new Cliente(this.registerForm.get('nombre')?.value,this.registerForm.get('apellidos')?.value,this.registerForm.get('nif')?.value,
    this.registerForm.get('direccionCompleta')?.value,this.registerForm.get('telefono')?.value,this.registerForm.get('email')?.value,this.registerForm.get('password')?.value
    )
    if(this.registerForm.get('nombre')?.value == ""){
      this.toastr.error('Debes introducir un nombre', 'CAMPO NOMBRE SIN RELLENAR');
    }
    else if(this.registerForm.get('apellidos')?.value == ""){
      this.toastr.error('Debes introducir los apellidos', 'CAMPO APELLIDOS SIN RELLENAR');
    }
    else if(this.registerForm.get('nif')?.value == ""){
      this.toastr.error('Debes introducir el NIF', 'CAMPO NIF SIN RELLENAR');
    }
    else if(this.registerForm.get('direccionCompleta')?.value == ""){
      this.toastr.error('Debes introducir la direccion completa', 'CAMPO DIRECCION COMPLETA SIN RELLENAR');
    }
    else if(this.registerForm.get('telefono')?.value == ""){
      this.toastr.error('Debes introducir un telefono', 'CAMPO TELEFONO SIN RELLENAR');
    }
    else if(this.registerForm.get('email')?.value == ""){
      this.toastr.error('Debes introducir un email', 'CAMPO EMAIL SIN RELLENAR');
    }
    else if(this.registerForm.get('password')?.value == ""){
      this.toastr.error('Debes introducir un password', 'CAMPO PASSWORD SIN RELLENAR');
    }
    else{
      camposRellenos = true;
    }

    if(camposRellenos){
      this.authenticationService.registerCliente(CLIENTE).subscribe(res =>{

        var jsonRespuesta : JSON = res;
          var respuesta : string = JSON.stringify(jsonRespuesta);
          if(respuesta.includes("errorPassword")){
           this.toastr.error('Formato de contraseña incorrecto. Debe contener al menos 8 caracteres, 1 mayúscula, 1 minúscula y 1 número', 'PASSWORD INCORRECTA');
           this.registerForm.get('password')?.reset;
          }
          else if(respuesta.includes("emailRepetido")){
            this.toastr.error('El email introducido ya ha sido registrado por un cliente', 'EMAIL EXISTENTE');
          }
          else{
            this.router.navigate(['/login']);
            this.toastr.success('Usuario creado correctamente', 'REGISTRO EXITOSO');
          }
  
      } , error => {
        
        console.log(error)
        this.toastr.error('Ha habido un error con el registro(Correo ya registrado o datos mal introducidos', 'REGISTRO INCORRECTO');
      });

    }else{
      this.toastr.error('Hay campos sin rellenar', 'HAY CAMPOS INCOMPLETOS');
    }
    
  }

}
