import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PerfilRoutingModule } from './perfil-routing.module';
import { PerfilPageComponent } from './perfil-page/perfil-page.component';


@NgModule({
  declarations: [
    PerfilPageComponent
  ],
  imports: [
    CommonModule,
    PerfilRoutingModule,
    FormsModule 
  ]
})
export class PerfilModule { }
