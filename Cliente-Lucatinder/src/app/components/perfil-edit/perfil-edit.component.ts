import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';
import {Perfil} from '../../models/perfil';
import { PerfilService } from '../../service/perfil.service';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-perfil-edit',
  templateUrl: './perfil-edit.component.html',
  styleUrls: ['./perfil-edit.component.css'],
  providers: [PerfilService]
})
export class PerfilEditComponent implements OnInit {

  perfil: Perfil=this.perfilService.getPerfilLoggedIn();
 // angForm: FormGroup

  constructor(/*private fb: FormBuilder,*/ private router: Router, private perfilService: PerfilService) {
   // this.createForm();
   }

   /*
  createForm(){
    this.angForm=this.fb.group({

    });
  }
*/
  modificarPerfil(): void{
    this.perfilService.modificarPerfil(this.perfil).subscribe(data => {alert("Perfil modificado correctamente.");});
  }

  ngOnInit() {
  }

}
