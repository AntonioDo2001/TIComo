import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Rider } from 'src/app/models/Rider';
import { RiderService } from 'src/app/services/rider.service';

@Component({
  selector: 'app-crear-rider',
  templateUrl: './crear-rider.component.html',
  styleUrls: ['./crear-rider.component.css']
})
export class CrearRiderComponent implements OnInit {
  riderForm: FormGroup;
  titulo = 'CREAR RIDER';
  id : String;

  constructor(private fbuilder: FormBuilder, private router:Router, private toastr: ToastrService, private _riderService:RiderService,
    private aRouter: ActivatedRoute) { 
    this.riderForm = this.fbuilder.group({
      nombre: ['', Validators.required],
      apellidos: ['', Validators.required],
      nif: ['', Validators.required],
      tipoVehiculo: ['', Validators.required],
      matricula: [''],
      carnet: [''],
      email: ['', Validators.required],
      password: ['', Validators.required]

    })
    this.id = this.aRouter.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    this.esEditar();
  }
  agregarRider(){
    console.log(this.riderForm)
    /*console.log(this.riderForm.get('Nombre')?.value);*/
    if(this.riderForm.get('nombre')?.value == ""){
      this.toastr.error('Debes introducir un nombre', 'CAMPO NOMBRE SIN RELLENAR');
    }
    else if(this.riderForm.get('apellidos')?.value == ""){
      this.toastr.error('Debes introducir los apellidos', 'CAMPO APELLIDOS SIN RELLENAR');
    }
    else if(this.riderForm.get('nif')?.value == ""){
      this.toastr.error('Debes introducir el NIF', 'CAMPO NIF SIN RELLENAR');
    }
    else if(this.riderForm.get('tipoVehiculo')?.value == ""){
      this.toastr.error('Debes introducir el tipo de vehiculo', 'CAMPO TIPO VEHICULO SIN RELLENAR');
    }
    else if(this.riderForm.get('email')?.value == ""){
      this.toastr.error('Debes introducir un email', 'CAMPO EMAIL SIN RELLENAR');
    }
    else if(this.riderForm.get('password')?.value == ""){
      this.toastr.error('Debes introducir un password', 'CAMPO PASSWORD SIN RELLENAR');
    }
    
    var RIDER = new Rider(this.riderForm.get('nombre')?.value,this.riderForm.get('apellidos')?.value,this.riderForm.get('nif')?.value,
    this.riderForm.get('tipoVehiculo')?.value,this.riderForm.get('matricula')?.value,this.riderForm.get('carnet')?.value,this.riderForm.get('email')?.value,this.riderForm.get('password')?.value
    )


    if(this.id !==null){
      //editamos Rider
      this._riderService.editarRider(this.id,RIDER).subscribe(data => {

        var jsonRespuesta : JSON = data;
        var respuesta : string = JSON.stringify(jsonRespuesta);
        
        if(respuesta.includes("errorPassword")){
         this.toastr.error('Formato de contraseña incorrecto. Debe contener al menos 8 caracteres, 1 mayúscula, 1 minúscula y 1 número', 'PASSWORD INCORRECTA');
         this.riderForm.get('password')?.reset;
        }
        else{
          this.toastr.info('El Rider ha sido modificado correctamente!', 'RIDER MODIFICADO');
          this.router.navigate(['/listar-riders']);
        }

      }, error => {
        console.log(error);
        this.riderForm.reset();
        this.toastr.error('Datos introducidos erroneos!!', 'ERROR AL GUARDAR RIDER');
      })
    } else{
      //agregamos Rider
      console.log(RIDER);
      this._riderService.guardarRider(RIDER).subscribe(data => {
        var jsonRespuesta : JSON = data;
        var respuesta : string = JSON.stringify(jsonRespuesta);

        if(respuesta.includes("errorPassword")){
         this.toastr.error('Formato de contraseña incorrecto. Debe contener al menos 8 caracteres, 1 mayúscula, 1 minúscula y 1 número', 'PASSWORD INCORRECTA');
         this.riderForm.get('password')?.reset;
        }
        else{
          this.toastr.success('El Rider introducido se ha guardado correctamente!', 'RIDER GUARDADO');
          this.router.navigate(['/listar-riders']);
        }




      }, error => {
        console.log(error);
        this.riderForm.reset();
        this.toastr.error('Datos introducidos erroneos!!', 'ERROR AL GUARDAR RIDER');
      })
    }

    
  }

  esEditar() {
    if(this.id !== null){
      this.titulo = 'EDITAR RIDER';
      this._riderService.obtenerRider(this.id).subscribe(data =>{

        
        this.riderForm.setValue({
          nombre: data.nombre,
          apellidos: data.apellidos,
          nif: data.nif,
          tipoVehiculo: data.tipoVehiculo,
          matricula: data.matricula,
          carnet: data.carnet,
          email: data.email,
          password: data.password
        })
      })
    }

  }

}
