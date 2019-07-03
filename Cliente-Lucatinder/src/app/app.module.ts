import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PerfilMatchComponent } from './components/perfil-match/perfil-match.component';

import { PerfilEditComponent } from './components/perfil-edit/perfil-edit.component';

import { PerfilAddComponent } from './components/perfil-add/perfil-add.component';




@NgModule({
  declarations: [
    AppComponent,
    PerfilMatchComponent,
    PerfilEditComponent,
    PerfilAddComponent,




  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
