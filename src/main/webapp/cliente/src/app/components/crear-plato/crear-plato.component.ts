import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HelperService } from 'src/app/models/HelperService';
import { Plato } from 'src/app/models/Plato';
import { PlatoService } from 'src/app/services/plato.service';

@Component({
  selector: 'app-crear-plato',
  templateUrl: './crear-plato.component.html',
  styleUrls: ['./crear-plato.component.css']
})
export class CrearPlatoComponent implements OnInit {
  platosForm: FormGroup;
  titulo = 'CREAR PLATO';
  id : String;
  idRestaurante: String = "";

  constructor(private fbuilder: FormBuilder, private router:Router, private toastr: ToastrService, private _platoService:PlatoService,
    private aRouter: ActivatedRoute,private helper: HelperService) { 
    this.platosForm = this.fbuilder.group({
      nombre: ['', Validators.required],
      foto: ['', Validators.required],
      descripcion: ['', Validators.required],
      precio: ['', Validators.required],
      aptoVeganos: ['', Validators.required],
      idRestaurante: ['', Validators.required]

    })
    this.id = this.aRouter.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    this.helper.customMessage.subscribe(msg => this.idRestaurante = msg);
    console.log(this.idRestaurante);
    this.platosForm.setValue({
      nombre: "",
      foto: "",
      descripcion: "",
      precio: "",
      aptoVeganos: "",
      idRestaurante: this.idRestaurante
    })
    this.esEditar();
  }
  agregarPlato(){
    var camposRellenos: boolean = false;
    if(this.platosForm.get('nombre')?.value == ""){
      this.toastr.error('Debes introducir un nombre', 'CAMPO NOMBRE SIN RELLENAR');
    }
    else if(this.platosForm.get('foto')?.value == ""){
      this.toastr.error('Debes introducir una foto', 'CAMPO FOTO SIN RELLENAR');
    }
    else if(this.platosForm.get('descripcion')?.value == ""){
      this.toastr.error('Debes introducir una descripcion', 'CAMPO DESCRIPCION SIN RELLENAR');
    }
    else if(this.platosForm.get('precio')?.value == ""){
      this.toastr.error('Debes introducir un precio', 'CAMPO PRECIO SIN RELLENAR');
    }
    else if(this.platosForm.get('idRestaurante')?.value == ""){
      this.toastr.error('Debes introducir un id de restaurante', 'CAMPO ID RESTAURANTE SIN RELLENAR');
    }
    else{
      camposRellenos = true;
    }
    
    var PLATO = new Plato(this.platosForm.get('nombre')?.value,this.platosForm.get('foto')?.value,this.platosForm.get('descripcion')?.value,this.platosForm.get('precio')?.value,
    this.platosForm.get('aptoVeganos')?.value, this.platosForm.get('idRestaurante')?.value)

    if(this.id !==null){
      console.log("Estamos en editar");
      console.log(this.platosForm.get('aptoVeganos')?.value)
      console.log(this.platosForm.get('nombre')?.value)
      //editamos Plato
      if(camposRellenos){
        this._platoService.editarPlato(this.id,PLATO).subscribe(data => {
        this.idRestaurante = "";
        this.helper.changeMessage("");
        this.toastr.info('El Plato ha sido modificado correctamente!', 'PLATO MODIFICADO');
        this.router.navigate(['/listar-platos']);
  
        }, error => {
          console.log(error);
          this.toastr.error('El campo Apto Veganos tiene que ser true o false', 'FORMATO DE APTO VEGANOS INCORRECTO ');
        })

      }else{
        this.toastr.error('Aun quedan campos sin rellenar', 'CAMPOS SIN RELLENAR');
      }
      
    } else{
      //agregamos Plato
      console.log(PLATO);
      if(camposRellenos){
        this._platoService.guardarPlato(PLATO).subscribe(data => {
          this.idRestaurante = "";
          this.helper.changeMessage("");
          this.toastr.success('El Plato introducido se ha guardado correctamente!', 'PLATO GUARDADO');
          this.router.navigate(['/listar-platos']);
          }, error => {
            console.log(error);
            this.toastr.error('El campo Apto Veganos tiene que ser true o false', 'FORMATO DE APTO VEGANOS INCORRECTO ');
          })

      }
      else{
        this.toastr.error('Aun quedan campos sin rellenar', 'CAMPOS SIN RELLENAR');
      }
      
    }

    
  }

  vaciarIdRestaurante(){
    this.helper.changeMessage("");
  }

  esEditar() {
    if(this.id !== null){
      this.titulo = 'EDITAR PLATO';
      this._platoService.obtenerPlato(this.id).subscribe(data =>{
        this.platosForm.setValue({
          nombre: data.nombre,
          foto: data.foto,
          descripcion: data.descripcion,
          precio: data.precio,
          aptoVeganos: data.aptoVeganos,
          idRestaurante: data.idRestaurante
        })
      })
    }

  }

}