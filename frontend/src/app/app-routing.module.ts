import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Aqui vão as rotas principais da aplicação
const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'login',
    loadChildren: () =>
      import('./features/auth/auth.module').then((m) => m.AuthModule),
  },
  {
    path: 'filmes',
    loadChildren: () =>
      import('./features/filmes/filme/filme.module').then((m) => m.FilmeModule),
  },
  {
    path: 'perfil',
    loadChildren: () =>
      import('./features/perfil/perfil.module').then((m) => m.PerfilModule),
  },
  {
    path: 'usuarios',
    loadChildren: () =>
      import('./features/usuarios/usuario/usuario.module').then((m) => m.UsuarioModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
