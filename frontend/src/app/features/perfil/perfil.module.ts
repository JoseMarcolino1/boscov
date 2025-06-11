import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PerfilRoutingModule } from './perfil-routing.module';
import { PerfilPageComponent } from './perfil-page/perfil-page.component';
import { EditarPerfilComponent } from './editar-perfil/editar-perfil.component';


@NgModule({
  declarations: [
    PerfilPageComponent,
    EditarPerfilComponent
  ],
  imports: [
    CommonModule,
    PerfilRoutingModule,
    ReactiveFormsModule,
    FormsModule 
  ]
})
export class PerfilModule { }
