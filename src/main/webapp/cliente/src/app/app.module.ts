import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from './services/authentication.service';
import { HelperService } from './models/HelperService';

//Componentes
import { AppComponent } from './app.component';
import { CrearRiderComponent } from './components/crear-rider/crear-rider.component';
import { ListarRidersComponent } from './components/listar-riders/listar-riders.component';
import { FormularioRegistroComponent } from './components/formulario-registro/formulario-registro.component';
import { PaginaPrincipalComponent } from './components/pagina-principal/pagina-principal.component';
import { LoginComponent } from './components/login/login.component';
import { ListarPlatosComponent } from './components/listar-platos/listar-platos.component';
import { CrearPlatoComponent } from './components/crear-plato/crear-plato.component';
import { CrearAdminComponent } from './components/crear-admin/crear-admin.component';
import { ListarAdminsComponent } from './components/listar-admins/listar-admins.component';
import { ListarClientesComponent } from './components/listar-clientes/listar-clientes.component';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';
import { CrearRestauranteComponent } from './components/crear-restaurante/crear-restaurante.component';
import { ListarRestaurantesComponent } from './components/listar-restaurantes/listar-restaurantes.component';
import { PaginaPrincipalClienteComponent } from './components/pagina-principal-cliente/pagina-principal-cliente.component';
import { ListarPlatosClienteComponent } from './components/listar-platos-cliente/listar-platos-cliente.component';
import { ListarRestaurantesClienteComponent } from './components/listar-restaurantes-cliente/listar-restaurantes-cliente.component';
import { RegisterComponent } from './components/register/register.component';
import { EditarPerfilClienteComponent } from './components/editar-perfil-cliente/editar-perfil-cliente.component'

@NgModule({
  declarations: [
    AppComponent,
    CrearRiderComponent,
    ListarRidersComponent,
    FormularioRegistroComponent,
    PaginaPrincipalComponent,
    LoginComponent,
    ListarPlatosComponent,
    CrearPlatoComponent,
    CrearAdminComponent,
    ListarAdminsComponent,
    ListarClientesComponent,
    CrearClienteComponent,
    CrearRestauranteComponent,
    ListarRestaurantesComponent,
    PaginaPrincipalClienteComponent,
    ListarPlatosClienteComponent,
    ListarRestaurantesClienteComponent,
    RegisterComponent,
    EditarPerfilClienteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule

  ],
  providers: [AuthenticationService,HelperService],
  bootstrap: [AppComponent]
})
export class AppModule { }
