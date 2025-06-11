import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilmeListComponent } from '../filme-list/filme-list.component';
import { FilmeRoutingModule } from './filme-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FilmeCreateComponent } from '../filme-create/filme-create.component';
import { SharedModule } from 'src/app/shared/shared/shared.module';


@NgModule({
  declarations: [
    FilmeListComponent,
    FilmeCreateComponent 
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FilmeRoutingModule,
    SharedModule
  ]
})
export class FilmeModule { }
