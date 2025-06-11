import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { GenerosRoutingModule } from './generos-routing.module';
import { GeneroCreateComponent } from './genero-create/genero-create.component';
import { SharedModule } from 'src/app/shared/shared/shared.module';


@NgModule({
  declarations: [GeneroCreateComponent],
  imports: [
    CommonModule,
    GenerosRoutingModule,
    ReactiveFormsModule,
    SharedModule
    
  ]
})
export class GenerosModule { }
