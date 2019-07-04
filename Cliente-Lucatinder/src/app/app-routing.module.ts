import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//Nuevo
import { PerfilAddComponent } from './components/perfil-add/perfil-add.component';
import { PerfilListComponent } from './components/perfil-list/perfil-list.component';
import { LoginComponent } from './components/login/login.component';

//Creo las rutas
const routes: Routes = [
  { path: 'add', component: PerfilAddComponent },
  { path: 'perfilList', component: PerfilListComponent },
  { path: 'login', component: LoginComponent },
  { path: '', component: LoginComponent }
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
