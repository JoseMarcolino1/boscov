import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './core/auth/auth.guard';

// Aqui vão as rotas principais da aplicação
const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {
    path: 'home',
    loadChildren: () =>
      import('./features/home/home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'login',
    loadChildren: () =>
      import('./features/auth/auth.module').then((m) => m.AuthModule),
  },
  {
    path: 'filmes',
    loadChildren: () =>
      import('./features/filmes/filme/filme.module').then((m) => m.FilmeModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'perfil',
    loadChildren: () =>
      import('./features/perfil/perfil.module').then((m) => m.PerfilModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'usuarios',
    loadChildren: () =>
      import('./features/usuarios/usuario/usuario.module').then((m) => m.UsuarioModule),
    canActivate: [AuthGuard],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
