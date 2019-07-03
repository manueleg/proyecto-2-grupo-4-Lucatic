import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PerfilMatchComponent } from './components/perfil-match/perfil-match.component';

import { PerfilEditComponent } from './components/perfil-edit/perfil-edit.component';

import { PerfilAddComponent } from './components/perfil-add/perfil-add.component';
<<<<<<< HEAD
import { PerfilListComponent } from './components/perfil-list/perfil-list.component';
import { PerfilDeleteComponent } from './components/perfil-delete/perfil-delete.component';
=======
import { PerfilDeleteComponent } from './components/perfil-delete/perfil-delete.component';

>>>>>>> 845d3c68d9ddb4d1ec52b55322c977b2ff5402e8



@NgModule({
  declarations: [
    AppComponent,
    PerfilMatchComponent,
    PerfilEditComponent,
    PerfilAddComponent,
<<<<<<< HEAD
    PerfilListComponent,
    PerfilDeleteComponent,
=======
    PerfilDeleteComponent,



>>>>>>> 845d3c68d9ddb4d1ec52b55322c977b2ff5402e8

  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
  })

export class AppModule { }
