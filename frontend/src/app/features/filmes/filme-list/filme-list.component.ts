import { Component } from '@angular/core';
import { FilmeService } from '../filme/filme.service';

@Component({
  selector: 'app-filme-list',
  templateUrl: './filme-list.component.html',
})
export class FilmeListComponent {
  filmes: any[] = [];

  constructor(private filmeService: FilmeService) {}

  ngOnInit() {
    this.filmeService.getFilmes().subscribe({
      next: (res) => {
        this.filmes = res;
      },
      error: (err) => {
        console.error('Erro ao buscar filmes:', err);
      },
    });
  }

  getGeneros(filme: any): string {
    if (!filme.generos || filme.generos.length === 0) {
      return 'Sem gênero';
    }
    return filme.generos.map((g: any) => g.nome).join(', ');
  }
}
