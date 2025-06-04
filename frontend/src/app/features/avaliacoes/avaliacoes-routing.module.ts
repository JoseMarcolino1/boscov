import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AvaliacaoCreateComponent } from './avaliacao-create/avaliacao-create.component';
import { AuthGuard } from 'src/app/core/auth/auth.guard';
import { AvaliacaoEditComponent } from './avaliacao-edit/avaliacao-edit.component';
const routes: Routes = [
  {
    path: 'create/:id',
    component: AvaliacaoCreateComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'edit/:idFilme',
    component: AvaliacaoEditComponent ,
  }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AvaliacoesRoutingModule { }
