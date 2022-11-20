import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Admin } from 'src/app/models/Admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-listar-admins',
  templateUrl: './listar-admins.component.html',
  styleUrls: ['./listar-admins.component.css']
})
export class ListarAdminsComponent implements OnInit {

  listAdmins: Admin[] = [];
  
  constructor( private _adminService: AdminService, private toastr: ToastrService) { }


  ngOnInit(): void {
    this.obtenerAdmins();
  }


  obtenerAdmins(){
    this._adminService.getAdmins().subscribe(data =>{
      this.listAdmins = data;
    }, error => {
      console.log(error);

    })
    
  }
  eliminarAdmin(id: any){
    this._adminService.eliminarAdmin(id).subscribe(data =>{
      this.toastr.error('El admin ha sido eliminado correctamente', 'ADMIN ELIMINADO');
      this.obtenerAdmins();

    }, error => {
      console.log(error);
    })
  }

}


