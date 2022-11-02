import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Admin } from 'src/app/models/Admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-crear-admin',
  templateUrl: './crear-admin.component.html',
  styleUrls: ['./crear-admin.component.css']
})
export class CrearAdminComponent implements OnInit {
  adminForm: FormGroup;
  titulo = 'CREAR ADMININSTRADOR';
  id : String;

  constructor(private fbuilder: FormBuilder, private router:Router, private toastr: ToastrService, private _adminService:AdminService,
    private aRouter: ActivatedRoute) { 
    this.adminForm = this.fbuilder.group({
      nombre: ['', Validators.required],
      apellidos: ['', Validators.required],
      zona: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required]

    })
    this.id = this.aRouter.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    this.esEditar();
  }
  agregarAdmin(){
    let camposRellenos = false;
    if(this.adminForm.get('nombre')?.value == ""){
      this.toastr.error('Debes introducir un nombre', 'CAMPO NOMBRE SIN RELLENAR');
    }
    else if(this.adminForm.get('apellidos')?.value == ""){
      this.toastr.error('Debes introducir los apellidos', 'CAMPO APELLIDOS SIN RELLENAR');
    }
    else if(this.adminForm.get('zona')?.value == ""){
      this.toastr.error('Debes introducir una zona', 'CAMPO ZONA SIN RELLENAR');
    }
    else if(this.adminForm.get('email')?.value == ""){
      this.toastr.error('Debes introducir un email', 'CAMPO EMAIL SIN RELLENAR');
    }
    else if(this.adminForm.get('password')?.value == ""){
      this.toastr.error('Debes introducir un password', 'CAMPO PASSWORD SIN RELLENAR');
    }
    else{
      camposRellenos = true;
    }
    

    var ADMIN = new Admin(this.adminForm.get('nombre')?.value,this.adminForm.get('apellidos')?.value,this.adminForm.get('zona')?.value,
    this.adminForm.get('email')?.value,this.adminForm.get('password')?.value
    )

    if(camposRellenos){
      if(this.id !==null){
        //editamos Admin
        this._adminService.editarAdmin(this.id,ADMIN).subscribe(data => {
  
          var jsonRespuesta : JSON = data;
          var respuesta : string = JSON.stringify(jsonRespuesta);
          if(respuesta.includes("errorPassword")){
           this.toastr.error('Formato de contraseña incorrecto. Debe contener al menos 8 caracteres, 1 mayúscula, 1 minúscula y 1 número', 'PASSWORD INCORRECTA');
           this.adminForm.get('password')?.reset;
          }
          else{
            this.toastr.info('El Admin ha sido modificado correctamente!', 'ADMINISTRADOR MODIFICADO');
            this.router.navigate(['/listar-admins']);
          }
  
        }, error => {
          console.log(error);
          this.adminForm.reset();
          this.toastr.error('Datos introducidos erroneos!!', 'ERROR AL GUARDAR ADMINISTRADOR');
        })
      } else{
        //agregamos Admin
        console.log(ADMIN);
        this._adminService.guardarAdmin(ADMIN).subscribe(data => {
          var jsonRespuesta : JSON = data;
          var respuesta : string = JSON.stringify(jsonRespuesta);
          
          if(respuesta.includes("errorPassword")){
           this.toastr.error('Formato de contraseña incorrecto. Debe contener al menos 8 caracteres, 1 mayúscula, 1 minúscula y 1 número', 'PASSWORD INCORRECTA');
           this.adminForm.get('password')?.reset;
          }
          else{
            this.toastr.success('El Admin introducido se ha guardado correctamente!', 'ADMINISTRADOR GUARDADO');
            this.router.navigate(['/listar-admins']);
          }      
        }, error => {
          console.log(error);
          this.adminForm.reset();
          this.toastr.error('Datos introducidos erroneos!!', 'ERROR AL GUARDAR ADMINISTRADOR');
        })
      }

    }else{
      this.toastr.error('Hay campos sin rellenar', 'HAY CAMPOS INCOMPLETOS');

    }
    

    
  }

  esEditar() {
    if(this.id !== null){
      this.titulo = 'EDITAR ADMINISTRADOR';
      this._adminService.obtenerAdmin(this.id).subscribe(data =>{
        this.adminForm.setValue({
          nombre: data.nombre,
          apellidos: data.apellidos,
          zona: data.zona,
          email: data.email,
          password: data.password
        })
      })
    }

  }

}
