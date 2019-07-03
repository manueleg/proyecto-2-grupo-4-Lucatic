import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Perfil } from '../models/perfil';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  constructor(private http:HttpClient) { }

  private perfilUrl = 'http://localhost:8080/indexrest';
}
