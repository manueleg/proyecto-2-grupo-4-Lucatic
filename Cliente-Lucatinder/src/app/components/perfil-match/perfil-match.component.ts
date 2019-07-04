import { Component, OnInit, Input } from '@angular/core';
import { PerfilService } from '../../service/perfil.service';
import { Perfil } from '../../models/perfil';

@Component({
  selector: 'app-perfil-match',
  templateUrl: './perfil-match.component.html',
  styleUrls: ['./perfil-match.component.scss'],
  providers: [PerfilService] //necesitas añadir el servicio como un proveedor
})
export class PerfilMatchComponent implements OnInit {

  //@Input() perfilLogin: Perfil;
  matches: Array<any>;

  constructor(private perfilService: PerfilService) {}

  ngOnInit() {
    //El metodo listarMatches está definido en perfil.service.ts
     //El metodo getPerfilLoggedIn() está definido en perfil.service.ts
    this.perfilService.listarMatches(this.perfilService.getPerfilLoggedIn()).subscribe(
      data => {
        this.matches = data;
        //Con lo anterior bastaría. 
        //   Ya se podrían ver los perfiles en el Front
      },
      error => console.log(error)
    )
  }
}