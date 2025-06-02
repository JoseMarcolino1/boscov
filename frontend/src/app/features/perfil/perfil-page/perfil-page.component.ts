import { Component } from '@angular/core';
import { AuthService } from 'src/app/core/auth/auth.service';
import { UsuarioOutput } from 'src/app/interfaces/usuario';

@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.css'],
})
export class PerfilPageComponent {
  usuario: UsuarioOutput | null = null;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.authService.getUsuarioLogado().subscribe({
      next: (res) => {
        console.log('✅ Usuário carregado:', res);
        this.usuario = res;
      },
      error: (err) => {
        console.error('❌ Erro ao carregar perfil:', err);
      },
    });
  }
}
