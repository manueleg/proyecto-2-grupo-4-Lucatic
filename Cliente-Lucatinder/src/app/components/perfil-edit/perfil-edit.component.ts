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

  perfil: Perfil=new Perfil();6
  perfilList: Array<Perfil>;

  constructor(private router: Router, private perfilService: PerfilService) { }

  modificarPerfil(): void{
    this.perfilService.modificarPerfil(this.perfil).subscribe(data => {alert("Perfil modificado correctamente.");});
  }

  ngOnInit() {
  }

}
