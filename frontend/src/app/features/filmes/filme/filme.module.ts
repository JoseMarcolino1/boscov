import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilmeListComponent } from '../filme-list/filme-list.component';
import { FilmeRoutingModule } from './filme-routing.module';


@NgModule({
  declarations: [FilmeListComponent],
  imports: [
    CommonModule,
    FilmeRoutingModule
  ]
})
export class FilmeModule { }
