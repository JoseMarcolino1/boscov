import { Component, OnInit } from '@angular/core';
import { FilmeService } from '../filme/filme.service';
import { FilmeOutput } from 'src/app/interfaces/filme';
import { AvaliacaoService } from '../../avaliacoes/avaliacao.service';
import { AvaliacaoOutput } from 'src/app/interfaces/avaliacao';

@Component({
  selector: 'app-filme-list',
  templateUrl: './filme-list.component.html',
})
export class FilmeListComponent implements OnInit {
  filmes: FilmeOutput[] = [];
  avaliacoesUsuario: AvaliacaoOutput[] = [];

  constructor(
    private filmeService: FilmeService,
    private avaliacoesService: AvaliacaoService
  ) {}

  ngOnInit() {
    this.filmeService.getFilmes().subscribe({
      next: (res) => {
        console.log('✅ Filmes carregados:', res);
        this.filmes = res;
      },
      error: (err) => {
        console.error('❌ Erro ao buscar filmes:', err);
        if (err instanceof ErrorEvent) {
          console.error('👉 Erro de cliente:', err.error.message);
        } else {
          console.error('👉 Erro de servidor:');
          console.error('Status:', err.status);
          console.error('Status text:', err.statusText);
          console.error('URL:', err.url);
          console.error('Response:', err.error);
        }
      },
    });
    console.log('🔎 Buscando avaliações do usuári2222o...');
    this.avaliacoesService.getMinhasAvaliacoes().subscribe({
      next: (res) => {
        console.log('✅ Avaliações do usuário carregadas:', res);
        this.avaliacoesUsuario = res;
      },
      error: (err) => {
        console.error('Erro ao buscar avaliações:', err);
      },
    });
  }

  getGeneros(filme: FilmeOutput): string {
    if (!filme.generos || filme.generos.length === 0) {
      return 'Sem gênero';
    }
    return filme.generos.map((g) => g.descricao).join(', ');
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  getUserRole(): string | null {
    const token = localStorage.getItem('token');
    if (!token) return null;
    const payload = JSON.parse(atob(token.split('.')[1]));
    return payload.role || null;
  }

  isAdmin(): boolean {
    return this.getUserRole() === 'ADMIN';
  }

  getMinhaAvaliacaoDoFilme(filmeId: number): AvaliacaoOutput | undefined {
    return this.avaliacoesUsuario.find((a) => a.idFilme === filmeId);
  }
}
