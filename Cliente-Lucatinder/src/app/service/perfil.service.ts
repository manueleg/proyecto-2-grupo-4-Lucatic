import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Perfil } from '../models/perfil';
import { Observable } from 'rxjs';
import { Identifiers } from '@angular/compiler';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  private isPerfilLoggedIn;
  public perfilLogged:Perfil;

  constructor(private http:HttpClient) {
    this.isPerfilLoggedIn = false;
   }

  public API = 'http://localhost:8080';
  public LUCATINDER_API = this.API + '/indexrest';

  public createPerfil(perfil) {
    return this.http.post<Perfil>(this.LUCATINDER_API, perfil);
  }

  public modificarPerfil(perfil){
   return this.http.put<Perfil>(this.LUCATINDER_API, perfil);
  } 

  public deletePerfil(perfil){
    return this.http.put<Perfil>(this.LUCATINDER_API, perfil);
   } 

  listarPerfiles(): Observable<any> {
    return this.http.get(this.LUCATINDER_API + "/readperfiles");
  }


  listarMatches(perfil){
    return this.http.get<Perfil[]>(this.LUCATINDER_API+ '/listMatches/'+ perfil.idusuario);
  }

  setPerfilLoggedIn(perfil:Perfil) {
    this.isPerfilLoggedIn = true;
    this.perfilLogged = perfil;
    localStorage.setItem('currentPerfil', JSON.stringify(perfil));
  }

  getPerfilLoggedIn() {
  	return JSON.parse(localStorage.getItem('currentPerfil'));
  }

  login(idusuario:number){
    return this.http.get<Perfil>(this.LUCATINDER_API+ '/'+ idusuario);
  }
  
  addLike(id1:number, id2:number){
    return this.http.get(this.LUCATINDER_API + "/like?id1=" + id1 + "?id2=" + id2);
  }
  
}
