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
import { EditarPerfilClienteComponent } from './components/editar-perfil-cliente/editar-perfil-cliente.component';
import { PantallaCargaInicialComponent } from './components/pantalla-carga-inicial/pantalla-carga-inicial.component';
import { ListarPedidosClienteComponent } from './components/listar-pedidos-cliente/listar-pedidos-cliente.component';
import { ListarPedidosRiderComponent } from './components/listar-pedidos-rider/listar-pedidos-rider.component';
import { CrearPedidoComponent } from './components/crear-pedido/crear-pedido.component';
import { PaginaPagoPedidoComponent } from './components/pagina-pago-pedido/pagina-pago-pedido.component';
import { ValorarRiderComponent } from './components/valorar-rider/valorar-rider.component';
import { ValorarRestauranteComponent } from './components/valorar-restaurante/valorar-restaurante.component';
import { ListarPedidosRealizadosClienteComponent } from './components/listar-pedidos-realizados-cliente/listar-pedidos-realizados-cliente.component';
import { ListarEntregasRiderComponent } from './components/listar-entregas-rider/listar-entregas-rider.component';
import { ListarEntregasClienteComponent } from './components/listar-entregas-cliente/listar-entregas-cliente.component';
import { PaginaPrincipalRiderComponent } from './components/pagina-principal-rider/pagina-principal-rider.component';
import { RealizarValoracionComponent } from './components/realizar-valoracion/realizar-valoracion.component';
import { VerValoracionesRestauranteComponent } from './components/ver-valoraciones-restaurante/ver-valoraciones-restaurante.component';
import { VerValoracionesRiderComponent } from './components/ver-valoraciones-rider/ver-valoraciones-rider.component';
import { VerValoracionesRestauranteAdminComponent } from './components/ver-valoraciones-restaurante-admin/ver-valoraciones-restaurante-admin.component';
import { VerFacturaComponent } from './components/ver-factura/ver-factura.component';

@NgModule({
  declarations: [
    AppComponent,
    CrearRiderComponent,
    ListarRidersComponent,

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
    EditarPerfilClienteComponent,
    PantallaCargaInicialComponent,
    ListarPedidosClienteComponent,
    ListarPedidosRiderComponent,
    CrearPedidoComponent,
    PaginaPagoPedidoComponent,
    ValorarRiderComponent,
    ValorarRestauranteComponent,
    ListarPedidosRealizadosClienteComponent,
    ListarEntregasRiderComponent,
    ListarEntregasClienteComponent,
    PaginaPrincipalRiderComponent,
    RealizarValoracionComponent,
    VerValoracionesRestauranteComponent,
    VerValoracionesRiderComponent,
    VerValoracionesRestauranteAdminComponent,
    VerFacturaComponent,
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
