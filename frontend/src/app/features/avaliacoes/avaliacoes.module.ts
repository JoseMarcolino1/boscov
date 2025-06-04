import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AvaliacoesRoutingModule } from './avaliacoes-routing.module';
import { AvaliacaoCreateComponent } from './avaliacao-create/avaliacao-create.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AvaliacaoEditComponent } from './avaliacao-edit/avaliacao-edit.component';


@NgModule({
  declarations: [AvaliacaoCreateComponent, AvaliacaoEditComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    AvaliacoesRoutingModule
  ]
})
export class AvaliacoesModule { }
