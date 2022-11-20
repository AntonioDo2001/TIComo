import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Restaurante } from 'src/app/models/Restaurante';
import { RestauranteService } from 'src/app/services/restaurante.service';

@Component({
  selector: 'app-crear-restaurante',
  templateUrl: './crear-restaurante.component.html',
  styleUrls: ['./crear-restaurante.component.css']
})
export class CrearRestauranteComponent implements OnInit {

  restauranteForm: FormGroup;
  titulo = 'CREAR RESTAURANTE';
  id : String;

  constructor(private fbuilder: FormBuilder, private router:Router, private toastr: ToastrService, private _restauranteService:RestauranteService,
    private aRouter: ActivatedRoute) { 
    this.restauranteForm = this.fbuilder.group({
      nombre: ['', Validators.required],
      razonSocial: ['', Validators.required],
      cif: ['', Validators.required],
      direccionCompleta: ['', Validators.required],
      telefono: ['', Validators.required],
      email: ['', Validators.required],
      categoria: ['', Validators.required]

    })
    this.id = this.aRouter.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    this.esEditar();
  }
  agregarRestaurante(){
    var camposRellenos: boolean = false;
    
    if(this.restauranteForm.get('nombre')?.value == ""){
      this.toastr.error('Debes introducir un nombre', 'CAMPO NOMBRE SIN RELLENAR');
    }
    else if(this.restauranteForm.get('razonSocial')?.value == ""){
      this.toastr.error('Debes introducir una razon social', 'CAMPO RAZON SOCIAL SIN RELLENAR');
    }
    else if(this.restauranteForm.get('CIF')?.value == ""){
      this.toastr.error('Debes introducir un CIF', 'CAMPO CIF SIN RELLENAR');
    }
    else if(this.restauranteForm.get('direccionCompleta')?.value == ""){
      this.toastr.error('Debes introducir una direccion completa', 'CAMPO DIRECCION COMPLETA SIN RELLENAR');
    }
    else if(this.restauranteForm.get('telefono')?.value == ""){
      this.toastr.error('Debes introducir un telefono', 'CAMPO TELEFONO SIN RELLENAR');
    }
    else if(this.restauranteForm.get('email')?.value == ""){
      this.toastr.error('Debes introducir un email', 'CAMPO EMAIL SIN RELLENAR');
    }
    else if(this.restauranteForm.get('categoria')?.value == ""){
      this.toastr.error('Debes introducir una categoria', 'CAMPO CATEGORIA SIN RELLENAR');
    }
    else{
      camposRellenos = true;
    }
  
    
    var RESTAURANTE = new Restaurante(this.restauranteForm.get('nombre')?.value,this.restauranteForm.get('razonSocial')?.value,this.restauranteForm.get('cif')?.value,
    this.restauranteForm.get('direccionCompleta')?.value,this.restauranteForm.get('telefono')?.value,this.restauranteForm.get('email')?.value,this.restauranteForm.get('categoria')?.value)

    if(this.id !==null){
      //editamos Restaurante
      if(camposRellenos){
        this._restauranteService.editarRestaurante(this.id,RESTAURANTE).subscribe(data => {
          var jsonRespuesta : JSON = data;
          var respuesta : string = JSON.stringify(jsonRespuesta);
          if(respuesta.includes("tlfFormErr")){
            this.toastr.error('El formato del telefono es incorrecto. Debe ser un número de 9 dígitos', 'FORMATO DE TELEFONO INVÁLIDO');
           }
           else if(respuesta.includes("emailFormato")){
            this.toastr.error('El formato del email es incorrecto. Debe seguir un formato <<nombreCorreo@correo.terminacion>>', 'FORMATO DE EMAIL INVÁLIDO');
           }
          else{
            this.toastr.info('El Restaurante ha sido modificado correctamente!', 'RESTAURANTE MODIFICADO');
            this.router.navigate(['/listar-restaurantes']);
          }
          
  
        }, error => {
          console.log(error);
          this.restauranteForm.reset();
          this.toastr.error('Datos introducidos erroneos!!', 'ERROR AL GUARDAR RESTAURANTE');
        })

      }
    else{
      this.toastr.error('Aun quedan campos sin rellenar', 'CAMPOS SIN RELLENAR');
    }
      
    } else{
      if(camposRellenos){
         //agregamos Restaurante
      console.log(RESTAURANTE);
      this._restauranteService.guardarRestaurante(RESTAURANTE).subscribe(data => {
        var jsonRespuesta : JSON = data;
        var respuesta : string = JSON.stringify(jsonRespuesta);
        if(respuesta.includes("tlfFormErr")){
          this.toastr.error('El formato del telefono es incorrecto. Debe ser un número de 9 dígitos', 'FORMATO DE TELEFONO INVÁLIDO');
         }
         else if(respuesta.includes("emailFormato")){
          this.toastr.error('El formato del email es incorrecto. Debe seguir un formato <<nombreCorreo@correo.terminacion>>', 'FORMATO DE EMAIL INVÁLIDO');
         }
        else{
          this.toastr.success('El Restaurante introducido se ha guardado correctamente!', 'RESTAURANTE GUARDADO');
          this.router.navigate(['/listar-restaurantes']);
        }
      
      }, error => {
        console.log(error);
        this.restauranteForm.reset();
        this.toastr.error('Datos introducidos erroneos!!', 'ERROR AL GUARDAR RESTAURANTE');
      })

      }
      else{
        this.toastr.error('Aun quedan campos sin rellenar', 'CAMPOS SIN RELLENAR');
      }
     
    }

    
  }

  esEditar() {
    if(this.id !== null){
      this.titulo = 'EDITAR RESTAURANTE';
      this._restauranteService.obtenerRestaurante(this.id).subscribe(data =>{
        this.restauranteForm.setValue({
          nombre: data.nombre,
          razonSocial: data.razonSocial,
          cif: data.cif,
          direccionCompleta: data.direccionCompleta,
          telefono: data.telefono,
          email: data.email,
          categoria: data.categoria
        })
      })
    }

  }

}
