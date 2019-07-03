import { Component, OnInit } from '@angular/core';
import { PerfilService } from '../../service/perfil.service';

@Component({
  selector: 'app-perfil-match',
  templateUrl: './perfil-match.component.html',
  styleUrls: ['./perfil-match.component.scss'],
  providers: [PerfilService] //necesitas añadir el servicio como un proveedor
})
export class PerfilMatchComponent implements OnInit {

  matches: Array<any>;

  constructor(private perfilService: PerfilService) {}

  ngOnInit() {
    //Se implementa un patron Observer
    //El metodo getAll está definido en perfil.service.ts
    /*this.perfilService.listarMatches(perfil).subscribe(
      data => {
        this.matches = data;
        //Con lo anterior bastaría. 
        //   Ya se podrían ver los perfiles en el Front
      },
      error => console.log(error)
    )*/
  }
}

