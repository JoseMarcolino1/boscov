import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GeneroCreateComponent } from './genero-create/genero-create.component';
import { AuthGuard } from 'src/app/core/auth/auth.guard';

const routes: Routes = [
  {
    path: 'create',
    component: GeneroCreateComponent,
    canActivate: [AuthGuard],
    data:{role: ['ADMIN']},
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GenerosRoutingModule { }
