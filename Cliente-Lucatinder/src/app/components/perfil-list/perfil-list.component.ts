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
  perfilSesion: Perfil;//Variable para recojer el perfil que esta logueado

  constructor(private router: Router, private perfilService: PerfilService) {

  }

  ngOnInit() {
    this.perfilSesion = this.perfilService.getPerfilLoggedIn();//Aquí recojo el usuario logueado para poder recoger luego su id
    this.perfilService.listarPerfiles().subscribe(
      (data) => this.perfiles = data,
      (error) => console.log(error)
    );
  }
   
  addLike(id1:number, id2:number):void{
    this.perfilService.addLike(id1, id2).subscribe( data => {
      
    });
  }

  //No ha dado tiempo de implementarlo.
  /*addDisike(id1:number, id2:number):void{
    this.perfilService.addDislike(id1, id2)
  }
 
  //No ha dado tiempo de implementarlo.
  listarIntereses() {
    this.perfilService.getPerfilIntereses(this.perfilService.getPerfilLoggedIn()).subscribe(
      data => {
        this.perfiles = data;
      },
      error => console.log(error)
    )
  }*/

}
