import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HelperService } from 'src/app/models/HelperService';
import { HelperValoracion } from 'src/app/models/HelperValoracion';
import { ClienteService } from 'src/app/services/cliente.service';
import { EntregaService } from 'src/app/services/entrega.service';

@Component({
  selector: 'app-entregas-clientes',
  templateUrl: './entregas-clientes.component.html',
  styleUrls: ['./entregas-clientes.component.css']
})
export class EntregasClientesComponent implements OnInit {

  constructor(private toastr: ToastrService,private helper: HelperService,private helperValoracion: HelperValoracion,private router:Router,private aRouter: ActivatedRoute,
    private _clienteService:ClienteService,private _entregaService:EntregaService) { }

  ngOnInit(): void {
  }

}
