import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearAdminComponent } from './components/crear-admin/crear-admin.component';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';
import { CrearPlatoComponent } from './components/crear-plato/crear-plato.component';
import { CrearRestauranteComponent } from './components/crear-restaurante/crear-restaurante.component';
import { CrearRiderComponent } from './components/crear-rider/crear-rider.component';
import { ListarAdminsComponent } from './components/listar-admins/listar-admins.component';
import { ListarClientesComponent } from './components/listar-clientes/listar-clientes.component';
import { ListarPlatosComponent } from './components/listar-platos/listar-platos.component';
import { ListarRestaurantesComponent } from './components/listar-restaurantes/listar-restaurantes.component';

//Componentes
import { ListarRidersComponent } from './components/listar-riders/listar-riders.component';
import { LoginComponent } from './components/login/login.component';
import { PaginaPrincipalClienteComponent } from './components/pagina-principal-cliente/pagina-principal-cliente.component';
import { PaginaPrincipalComponent } from './components/pagina-principal/pagina-principal.component';
import { ListarPlatosClienteComponent } from './components/listar-platos-cliente/listar-platos-cliente.component';
import { ListarRestaurantesClienteComponent } from './components/listar-restaurantes-cliente/listar-restaurantes-cliente.component';
import { RegisterComponent } from './components/register/register.component';
import { EditarPerfilClienteComponent } from './components/editar-perfil-cliente/editar-perfil-cliente.component';
import { PantallaCargaInicialComponent } from './components/pantalla-carga-inicial/pantalla-carga-inicial.component';
import { CrearPedidoComponent } from './components/crear-pedido/crear-pedido.component';
import { ListarPedidosRealizadosClienteComponent } from './components/listar-pedidos-realizados-cliente/listar-pedidos-realizados-cliente.component';
import { ListarPedidosClienteComponent } from './components/listar-pedidos-cliente/listar-pedidos-cliente.component';
import { ListarEntregasClienteComponent } from './components/listar-entregas-cliente/listar-entregas-cliente.component';
import { PaginaPrincipalRiderComponent } from './components/pagina-principal-rider/pagina-principal-rider.component';
import { ListarEntregasRiderComponent } from './components/listar-entregas-rider/listar-entregas-rider.component';
import { RealizarValoracionComponent } from './components/realizar-valoracion/realizar-valoracion.component';
import { VerValoracionesRestauranteComponent } from './components/ver-valoraciones-restaurante/ver-valoraciones-restaurante.component';
import { VerValoracionesRestauranteAdminComponent } from './components/ver-valoraciones-restaurante-admin/ver-valoraciones-restaurante-admin.component';
import { VerValoracionesRiderComponent } from './components/ver-valoraciones-rider/ver-valoraciones-rider.component';
import { VerFacturaComponent } from './components/ver-factura/ver-factura.component';

const routes: Routes = [
  { path: '', component: PantallaCargaInicialComponent},
  { path: 'pantallaInicial', component: PantallaCargaInicialComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'pagina-principal', component: PaginaPrincipalComponent},
  { path: 'pagina-principal-cliente', component: PaginaPrincipalClienteComponent},
  { path: 'pagina-principal-rider', component: PaginaPrincipalRiderComponent},
  { path: 'listar-riders', component: ListarRidersComponent},
  { path: 'editarPerfil-cliente', component: EditarPerfilClienteComponent},
  { path: 'listar-platos-cliente', component: ListarPlatosClienteComponent},
  { path: 'listar-restaurantes-cliente', component: ListarRestaurantesClienteComponent},
  { path: 'ver-valoraciones-restaurante/:nombre', component: VerValoracionesRestauranteComponent},
  { path: 'ver-valoraciones-restaurante', component: VerValoracionesRestauranteComponent},
  { path: 'ver-valoraciones-restaurante-admin/:nombre', component: VerValoracionesRestauranteAdminComponent},
  { path: 'ver-valoraciones-restaurante-admin', component: VerValoracionesRestauranteAdminComponent},
  { path: 'ver-valoraciones-rider/:id', component: VerValoracionesRiderComponent},
  { path: 'ver-valoraciones-rider', component: VerValoracionesRiderComponent},
  { path: 'ver-factura/:id', component: VerFacturaComponent},
  { path: 'ver-factura', component: VerFacturaComponent},
  { path: 'crear-rider', component: CrearRiderComponent},
  { path: 'editar-rider/:id', component: CrearRiderComponent},
  { path: 'editar-plato/:id', component: CrearPlatoComponent},
  { path: 'listar-platos', component: ListarPlatosComponent},
  { path: 'listar-pedidos', component: ListarPedidosClienteComponent},
  { path: 'listar-pedidos-realizados', component: ListarPedidosRealizadosClienteComponent},
  { path: 'listar-entregas-cliente', component: ListarEntregasClienteComponent},
  { path: 'listar-entregas-rider', component: ListarEntregasRiderComponent},
  { path: 'listar-pedidos-realizados-cliente', component: ListarPedidosRealizadosClienteComponent},
  { path: 'crear-plato', component: CrearPlatoComponent},
  { path: 'crear-plato/:id', component: CrearPlatoComponent},
  { path: 'crear-pedido', component: CrearPedidoComponent},
  { path: 'crear-pedido/:id', component: CrearPedidoComponent},
  { path: 'realizar-valoracion', component: RealizarValoracionComponent},
  { path: 'realizar-valoracion/:id', component: RealizarValoracionComponent},
  { path: 'listar-admins', component: ListarAdminsComponent},
  { path: 'crear-admin', component: CrearAdminComponent},
  { path: 'editar-admin/:id', component: CrearAdminComponent},
  { path: 'listar-clientes', component: ListarClientesComponent},
  { path: 'crear-cliente', component: CrearClienteComponent},
  { path: 'editar-cliente/:id', component: CrearClienteComponent},
  { path: 'listar-restaurantes', component: ListarRestaurantesComponent},
  { path: 'crear-restaurante', component: CrearRestauranteComponent},
  { path: 'editar-restaurante/:id', component: CrearRestauranteComponent},
  { path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
