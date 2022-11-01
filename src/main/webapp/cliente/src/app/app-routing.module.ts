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

const routes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'pagina-principal', component: PaginaPrincipalComponent},
  { path: 'pagina-principal-cliente', component: PaginaPrincipalClienteComponent},
  { path: 'listar-riders', component: ListarRidersComponent},
  { path: 'editarPerfil-cliente', component: EditarPerfilClienteComponent},
  { path: 'listar-platos-cliente', component: ListarPlatosClienteComponent},
  { path: 'listar-restaurantes-cliente', component: ListarRestaurantesClienteComponent},
  { path: 'crear-rider', component: CrearRiderComponent},
  { path: 'editar-rider/:id', component: CrearRiderComponent},
  { path: 'editar-plato/:id', component: CrearPlatoComponent},
  { path: 'listar-platos', component: ListarPlatosComponent},
  { path: 'crear-plato', component: CrearPlatoComponent},
  { path: 'crear-plato/:id', component: CrearPlatoComponent},
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
