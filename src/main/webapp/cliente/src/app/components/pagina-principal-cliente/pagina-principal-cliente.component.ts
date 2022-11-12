import { Component, OnInit } from '@angular/core';
import { HelperService } from 'src/app/models/HelperService';

@Component({
  selector: 'app-pagina-principal-cliente',
  templateUrl: './pagina-principal-cliente.component.html',
  styleUrls: ['./pagina-principal-cliente.component.css']
})
export class PaginaPrincipalClienteComponent implements OnInit {
  idCliente: string = "";

  constructor(private helper: HelperService) { }

  ngOnInit(): void {
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
    console.log(this.idCliente);
    this.helper.changeMessage(this.idCliente);
    this.helper.customMessage.subscribe(msg => this.idCliente = msg);
  }

  
}
