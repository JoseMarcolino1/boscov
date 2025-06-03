import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilmeListComponent } from '../filme-list/filme-list.component';
import { FilmeRoutingModule } from './filme-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FilmeCreateComponent } from '../filme-create/filme-create.component';


@NgModule({
  declarations: [
    FilmeListComponent,
    FilmeCreateComponent 
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FilmeRoutingModule
  ]
})
export class FilmeModule { }
