import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FilmeListComponent } from '../filme-list/filme-list.component';

const routes: Routes = [
  {
    path: '',
    component: FilmeListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FilmeRoutingModule { }
