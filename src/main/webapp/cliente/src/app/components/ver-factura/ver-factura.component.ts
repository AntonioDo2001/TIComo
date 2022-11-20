import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Entrega } from 'src/app/models/Entrega';
import { EntregaService } from 'src/app/services/entrega.service';

@Component({
  selector: 'app-ver-factura',
  templateUrl: './ver-factura.component.html',
  styleUrls: ['./ver-factura.component.css']
})
export class VerFacturaComponent implements OnInit {
  facturaForm: FormGroup;
  listEntregas:Entrega[] = [];
  idEntrega = "";

  constructor(private fbuilder: FormBuilder,private _entregaService:EntregaService,private router:Router,private aRouter: ActivatedRoute) { 
    this.facturaForm = this.fbuilder.group({
      nombreCliente: [''],
      apellidosCliente: [''],
      direccion: [''],
      telefonoCliente: [''],
      fechayhora: [''],
      pedidosRealizados: [''],
      precioTotal: [''],
      nombreRestaurante: ['']

    })
    this.idEntrega = this.aRouter.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    this._entregaService.getEntregas().subscribe(data =>{
      this.listEntregas = data;
      let entrega;
      for(let i=0;i<this.listEntregas.length;i++){
        if(this.listEntregas[i].id == this.idEntrega){
          entrega = this.listEntregas[i];
        }
      }
        
      this.facturaForm.setValue({
        nombreCliente: entrega?.nombreCliente,
        apellidosCliente: entrega?.apellidosCliente,
        direccion: entrega?.direccion,
        telefonoCliente: entrega?.telefonoCliente,
        fechayhora: entrega?.fechayhora,
        pedidosRealizados: entrega?.pedidosRealizados,
        precioTotal: entrega?.precioTotal,
        nombreRestaurante: entrega?.nombreRestaurante
      })
    })
  }

}
