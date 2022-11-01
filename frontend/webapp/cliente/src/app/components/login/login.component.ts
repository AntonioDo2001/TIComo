import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {  Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { HelperService } from 'src/app/models/HelperService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  idCliente: string;

  constructor(private fbuilder: FormBuilder,private authenticationService:AuthenticationService, private router:Router,private toastr: ToastrService,private _authService:AuthenticationService,private helper: HelperService) {
    this.loginForm = this.fbuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]

    })
    this.idCliente = "";
 
  }

  ngOnInit(): void {
  }
  onLogin():void{

    
    
    this.authenticationService.loginUser(this.loginForm.get('email')?.value,this.loginForm.get('password')?.value).subscribe(res =>{
      var jsonRespuesta : JSON = res;
      var respuesta : string = JSON.stringify(jsonRespuesta);

      if(respuesta.includes("incorrecto")){
        this.toastr.error('Email o Password incorrectos', 'LOGIN INCORRECTO');
      }
      else if(respuesta.includes("clienteLogin")){
      this.idCliente = (respuesta.substring(57,81));
      this.helper.changeMessage(this.idCliente);
      this.helper.customMessage.subscribe(msg => this.idCliente = msg);
      
      this.toastr.success('Te has logeado como cliente', 'LOGIN CORRECTO');
      this.router.navigate(['/pagina-principal-cliente']);
      }
      else if(respuesta.includes("adminLogin")){
        this.toastr.success('Te has logeado como admin', 'LOGIN CORRECTO');
        this.router.navigate(['/pagina-principal']);
        }
        else if(respuesta.includes("riderLogin")){
          this.toastr.success('Te has logeado como rider, ESTA FUNCIONALIDAD DE AÑADIRÁ EN EL SIGUIENTE SPRING :)', 'LOGIN CORRECTO');
          this.router.navigate(['/login']);
          }

    } , error => {
      console.log(error);
      this.toastr.error('Email o Password incorrectos', 'LOGIN INCORRECTO');
    });


  }

  devolverIdCliente() : string {
    return this.idCliente;
  }
  

}


