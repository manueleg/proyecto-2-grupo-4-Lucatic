import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/models/perfil';
import { PerfilService } from 'src/app/service/perfil.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil-add',
  templateUrl: './perfil-add.component.html',
  styleUrls: ['./perfil-add.component.scss']
})
export class PerfilAddComponent implements OnInit {

  perfil: Perfil = new Perfil();

  constructor(private router: Router, private PerfilService: PerfilService) { }

  crearPerfil(): void {
    this.PerfilService.createPerfil(this.perfil)
        .subscribe( data => {
          alert("Perfil generado correctamente.");
        });

  };

  ngOnInit() {
  }

}
