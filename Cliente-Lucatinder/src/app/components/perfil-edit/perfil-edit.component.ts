import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';
import {Perfil} from '../../models/perfil';
import { PerfilService } from '../../service/perfil.service';

@Component({
  selector: 'app-perfil-edit',
  templateUrl: './perfil-edit.component.html',
  styleUrls: ['./perfil-edit.component.css']
})
export class PerfilEditComponent implements OnInit {

  perfil: Perfil=new Perfil();

  constructor(private router: Router, private perfilService: PerfilService) { }

  modificarPerfil(): List<Perfil>{
    
  }

  ngOnInit() {
  }

}
