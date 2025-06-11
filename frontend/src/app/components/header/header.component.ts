import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  usuarioNome: string | null = '';

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    if (this.isLoggedIn()) {
      this.authService.getUsuarioLogado().subscribe({
        next: (usuario) => {
          this.usuarioNome = usuario.nome;
          localStorage.setItem('usuarioApelido', usuario.apelido || '');
        },
        error: (err) => {
          console.error('Erro ao obter usuário logado:', err);
          this.usuarioNome = null;
        },
      });
    } else {
      this.usuarioNome = null;
    }
  }

  logout() {
    this.authService.logout();
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  navigateToProfile() {
    if (this.isLoggedIn()) {
      this.router.navigate(['/perfil']);
    } else {
      this.router.navigate(['/login']);
    }
  }

  isAdmin(): boolean {
    const admin = this.authService.isAdmin();
    if (admin) {
      return true;
    } else {
      return false;
    }
  }
}
