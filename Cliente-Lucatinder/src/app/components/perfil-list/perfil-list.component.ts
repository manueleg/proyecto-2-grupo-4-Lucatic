import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Perfil } from '../../models/perfil';
import { PerfilService } from '../../service/perfil.service';

@Component({
  selector: 'app-perfil-list',
  templateUrl: './perfil-list.component.html',
  styleUrls: ['../../../assets/css/bootstrap.min.css',
  '../../../assets/css/grid.css',
  '../../../assets/css/styles_contactos_temp.css',
  './perfil-list.component.scss'],
  providers: [PerfilService]
})
export class PerfilListComponent implements OnInit {

  perfiles: Perfil[];

  constructor(private router: Router, private perfilService: PerfilService) {

  }

  ngOnInit() {
    this.perfilService.listarPerfiles().subscribe(
      (data) => this.perfiles = data,
      (error) => console.log(error)
    );
  }
   
  /*addLike(id1:number, id2:number):void{
    this.perfilService.login(id1)
    .subscribe( data => {
      alert("Like");
    });
  }*/

}
