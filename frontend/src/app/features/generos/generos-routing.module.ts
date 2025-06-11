import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GeneroCreateComponent } from './genero-create/genero-create.component';
import { AdminGuard } from 'src/app/core/auth/admin.guard';

const routes: Routes = [
  {
    path: 'create',
    component: GeneroCreateComponent,
    canActivate: [AdminGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GenerosRoutingModule { }
