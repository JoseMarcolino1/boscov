import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PerfilPageComponent } from './perfil-page/perfil-page.component';
import { EditarPerfilComponent } from './editar-perfil/editar-perfil.component';

const routes: Routes = [
  {
    path: '',
    component: PerfilPageComponent
  },
  {
    path: 'editar',
    component: EditarPerfilComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PerfilRoutingModule { }
