import { Component, OnInit } from '@angular/core';
import { PerfilService } from '../../service/perfil.service';
import { Perfil } from '../../models/perfil';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  /*template: `
  <app-child [perfilLogin]="perfilLogin"></app-child>
  `,*/
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  constructor(private perfilService: PerfilService, private router: Router) {
   }

  ngOnInit() {
  }

  logIn(idusuario: number, event: Event): void {
    event.preventDefault(); // Avoid default action for the submit button of the login form
    
    // Calls service to login user to the api rest
    this.perfilService.login(idusuario).subscribe(
      
      res => {
        let p: Perfil = {idusuario: idusuario, nombre:null, genero:null, fecha_nac:null, poblacion:null, idIntereses:null, descripcion:null};        
        this.perfilService.setPerfilLoggedIn(p);
      },
      error => {
        console.error(error);

      },
      () => this.navigate()
    );

    /*
    Cuando queramos recoger el id del usuario logueado utilizar:
    <div *ngIf="perfilLogged">
       {{perfilLogged.idusuario}}
    </div>
    */
  }

  navigate() {
    this.router.navigateByUrl('/perfilList');
  }

}
