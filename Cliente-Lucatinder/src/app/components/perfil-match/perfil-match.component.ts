import { Component, OnInit } from '@angular/core';
import { PerfilService } from '../services/perfil.service';

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
  }

}


  ngOnInit() {
    //Se implementa un patron Observer
    //El metodo getAll está definido en beer.service.ts
    this.beerService.getAll().subscribe(
      data => {
        this.beers = data;
        //Con lo anterior bastaría. 
        //   Ya se podrían ver las cervezas en el Front
        //   Si quiero añadir una iamgen a cada nombre uso un nuevo servicio
        //   Con este bucle añado una imagen a cada cerveza
        for (const beer of this.beers) {
          this.giphyService.get(beer.name).subscribe(url => beer.giphyUrl = url);
        }
      },
      error => console.log(error)
    )
  }
}