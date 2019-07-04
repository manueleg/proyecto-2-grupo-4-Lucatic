import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Perfil } from '../../models/perfil';
import { PerfilService } from '../../service/perfil.service';

@Component({
  selector: 'app-perfil-list',
  templateUrl: './perfil-list.component.html',
  styleUrls: ['./perfil-list.component.scss'],
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

  
  listarIntereses(): void {
    this.listarIntereses.apply(this.listarIntereses)
        .subscribe( data => {
          alert("Intereses listados correctamente.");
        });

  };
  
  
   

}
