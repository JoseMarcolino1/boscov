import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './core/auth/auth.guard';
import { AcessoNegadoComponent } from './features/pages/acesso-negado/acesso-negado.component';

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
      import('./features/usuarios/usuario/usuario.module').then(
        (m) => m.UsuarioModule
      ),
  },
  {
    path: 'generos',
    loadChildren: () =>
      import('./features/generos/generos.module').then((m) => m.GenerosModule),
  },
  {
    path: 'avaliacoes',
    loadChildren: () =>
      import('./features/avaliacoes/avaliacoes.module').then(
        (m) => m.AvaliacoesModule
      ),
  },
  {
    path: 'acesso-negado',
    component: AcessoNegadoComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
