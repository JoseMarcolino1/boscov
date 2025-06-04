import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/core/auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
    usuarioNome: string | null = '';

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    if (this.authService.isAuthenticated()) {
      this.authService.getUsuarioLogado().subscribe({
        next: (usuario) => {
          this.usuarioNome = usuario.nome;
          localStorage.setItem('usuarioApelido', usuario.apelido || '');
        },
        error: (err) => {
          console.error('Erro ao obter usuário logado:', err);
          this.usuarioNome = null; // ou '', pra sumir do template
        },
      });
    }
  }

  isLoggedIn(): boolean {
    return this.authService.isAuthenticated();
  }
}
