import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {  Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { HelperService } from 'src/app/models/HelperService';
import { ClienteService } from 'src/app/services/cliente.service';
import { RiderService } from 'src/app/services/rider.service';
import { Cliente } from 'src/app/models/Cliente';
import { Rider } from 'src/app/models/Rider';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  idCliente: string;
  idRider: string;

  constructor(private fbuilder: FormBuilder,private authenticationService:AuthenticationService, private router:Router,private toastr: ToastrService,private _authService:AuthenticationService,private helper: HelperService,
    private _clienteService:ClienteService,private _riderService:RiderService) {
    this.loginForm = this.fbuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]

    })
    this.idCliente = "";
    this.idRider = "";
 
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

      this._clienteService.obtenerCliente(this.idCliente).subscribe(data =>{
        let cliente:Cliente = data;
        if(cliente.cuentaActiva==true){
          this.toastr.success('Te has logeado como cliente', 'LOGIN CORRECTO');
          this.router.navigate(['/pagina-principal-cliente']);
        }
        else if(cliente.cuentaActiva == false){
          this.toastr.info('Te has logeado como cliente pero tu cuenta no esta activa', 'CUENTA DESACTIVADA');

        }
      },error => {
        this.toastr.error('Error obteniendo cliente', 'COMPROBACION CLIENTE ACTIVO ERRONEA');
        console.log(error)
      })
      }
      else if(respuesta.includes("adminLogin")){
        this.toastr.success('Te has logeado como admin', 'LOGIN CORRECTO');
        this.router.navigate(['/pagina-principal']);
        }
        else if(respuesta.includes("riderLogin")){
          this.idRider = (respuesta.substring(53,77));
          this.helper.changeMessage(this.idRider);
          this.helper.customMessage.subscribe(msg => this.idRider = msg);

          this._riderService.obtenerRider(this.idRider).subscribe(data =>{
            let rider:Rider = data;
            if(rider.cuentaActiva==true){
              this.toastr.success('Te has logeado como rider)', 'LOGIN CORRECTO');
              this.router.navigate(['/pagina-principal-rider']);
            }
            else if(rider.cuentaActiva == false){
              this.toastr.info('Te has logeado como rider pero tu cuenta no esta activa', 'CUENTA DESACTIVADA');
    
            }
          },error => {
            this.toastr.error('Error obteniendo rider', 'COMPROBACION RIDER ACTIVO ERRONEA');
            console.log(error)
          })
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


