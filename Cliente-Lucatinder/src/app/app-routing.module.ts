import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//Nuevo
import { PerfilAddComponent } from './components/perfil-add/perfil-add.component';

//Creo las rutas
const routes: Routes = [
  { path: 'add', component: PerfilAddComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
