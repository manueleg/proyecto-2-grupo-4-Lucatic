import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Perfil } from '../models/perfil';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  constructor(private http:HttpClient) { }

  private perfilUrl = 'http://localhost:8080/indexrest';

  public createPerfil(perfil) {
    return this.http.post<Perfil>(this.perfilUrl, perfil);
  }

  public modificarPerfil(perfil){
   return this.http.put<Perfil>(this.perfilUrl, perfil);
  } 

  listarPerfiles(): Observable<any> {
    return this.http.get(this.perfilUrl + "/readperfiles");
  }
  
  public listarMatches(perfil){
    return this.http.get<Perfil>(this.perfilUrl+ '/listMatches/'+ perfil.idusuario);
  }

}
