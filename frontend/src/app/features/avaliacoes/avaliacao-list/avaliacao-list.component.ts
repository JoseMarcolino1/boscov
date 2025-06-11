import { Component, OnInit } from '@angular/core';
import { AvaliacaoOutput } from 'src/app/interfaces/avaliacao';
import { AvaliacaoService } from '../avaliacao.service';
import { AuthService } from 'src/app/core/auth/auth.service';

@Component({
  selector: 'app-avaliacao-list',
  templateUrl: './avaliacao-list.component.html',
  styleUrls: ['./avaliacao-list.component.css'],
})
export class AvaliacaoListComponent implements OnInit {
  avaliacoes: AvaliacaoOutput[] = [];

  constructor(
    private avaliacaoService: AvaliacaoService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.loadAvavaliacoes();
  }

  loadAvavaliacoes(): void {
    this.avaliacaoService.getMinhasAvaliacoes().subscribe({
      next: (avaliacoes) => {
        this.avaliacoes = avaliacoes;
      },
      error: (error) => {
        console.error('Erro ao carregar avaliações:', error);
      },
    });
  }
}
