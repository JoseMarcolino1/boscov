import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FilmeListComponent } from '../filme-list/filme-list.component';
import { FilmeCreateComponent } from '../filme-create/filme-create.component';
import { AdminGuard } from 'src/app/core/auth/admin.guard';

const routes: Routes = [
  {
    path: '',
    component: FilmeListComponent,
  },
  {
    path: 'create',
    component: FilmeCreateComponent,
    canActivate: [AdminGuard],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FilmeRoutingModule {}
