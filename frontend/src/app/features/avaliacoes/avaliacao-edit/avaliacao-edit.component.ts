import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AvaliacaoOutput } from 'src/app/interfaces/avaliacao';
import { AvaliacaoService } from '../avaliacao.service';

@Component({
  selector: 'app-avaliacao-edit',
  templateUrl: './avaliacao-edit.component.html',
  styleUrls: ['./avaliacao-edit.component.css']
})
export class AvaliacaoEditComponent {
  form!: FormGroup;
  idFilme!: number;
  avaliacao!: AvaliacaoOutput | null;

  constructor(
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private avaliacaoService: AvaliacaoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.idFilme = Number(this.route.snapshot.paramMap.get('idFilme'));
    this.loadAvaliacao();
  }

  loadAvaliacao(): void {
    this.avaliacaoService.getMinhaAvaliacaoPorFilme(this.idFilme).subscribe({
      next: (res) => {
        this.avaliacao = res;
        this.form = this.fb.group({
          nota: [this.avaliacao?.nota, [Validators.required, Validators.min(1), Validators.max(10)]],
          comentario: [this.avaliacao?.comentario, Validators.maxLength(500)]
        });
      },
      error: (err) => {
        console.error('Erro ao buscar avaliação:', err);
        alert('Erro ao buscar sua avaliação!');
        this.router.navigate(['/filmes']);
      },
    });
  }

  salvar(): void {
    if (this.form.valid) {
      const input = {
        ...this.form.value,
        idFilme: this.idFilme
      };
      this.avaliacaoService.editarAvaliacao(input).subscribe({
        next: () => {
          alert('Avaliação atualizada!');
          this.router.navigate(['/filmes']);
        },
        error: (err) => {
          console.error('Erro ao atualizar avaliação:', err);
          alert('Erro ao atualizar avaliação!');
        }
      });
    }
  }
}
