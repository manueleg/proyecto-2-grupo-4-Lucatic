import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-perfil-delete',
  templateUrl: './perfil-delete.component.html',
  styleUrls: ['./perfil-delete.component.scss']
})
export class PerfilDeleteComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  deleteUser(Perfil: PerfilDeleteComponent): void {
    this.deleteUser.apply(Perfil)
      .subscribe( data => {
        this.deleteUser = this.deleteUser.apply(u => u !== Perfil);
      })
  };

}
