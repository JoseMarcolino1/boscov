import { Component } from '@angular/core';
import { FilmeService } from '../filme/filme.service';
import { FilmeOutput } from 'src/app/interfaces/filme';

@Component({
  selector: 'app-filme-list',
  templateUrl: './filme-list.component.html',
})
export class FilmeListComponent {
  filmes: FilmeOutput[] = [];

  constructor(private filmeService: FilmeService) {}

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
}
