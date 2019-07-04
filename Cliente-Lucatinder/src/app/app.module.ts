import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PerfilMatchComponent } from './components/perfil-match/perfil-match.component';

import { PerfilEditComponent } from './components/perfil-edit/perfil-edit.component';

import { PerfilAddComponent } from './components/perfil-add/perfil-add.component';

import { PerfilListComponent } from './components/perfil-list/perfil-list.component';

import { PerfilDeleteComponent } from './components/perfil-delete/perfil-delete.component';
import { LoginComponent } from './components/login/login.component';
//Nuevo
import { PerfilService } from './service/perfil.service';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    PerfilMatchComponent,
    PerfilEditComponent,
    PerfilAddComponent,
    PerfilListComponent,
    PerfilDeleteComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
     //Nuevo
     HttpClientModule,
     FormsModule 
  ],
   //Nuevo el provider
  providers: [PerfilService],
  bootstrap: [AppComponent]
  })

export class AppModule { }

