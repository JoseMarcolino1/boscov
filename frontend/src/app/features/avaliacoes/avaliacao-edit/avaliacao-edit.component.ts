import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AvaliacaoOutput } from 'src/app/interfaces/avaliacao';
import { AvaliacaoService } from '../avaliacao.service';

@Component({
  selector: 'app-avaliacao-edit',
  templateUrl: './avaliacao-edit.component.html',
  styleUrls: ['./avaliacao-edit.component.css'],
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

    // Inicialize o form aqui para evitar erro de binding
    this.form = this.fb.group({
      nota: [
        null,
        [Validators.required, Validators.min(1), Validators.max(10)],
      ],
      comentario: [''],
    });

    this.loadAvaliacao();
  }

  loadAvaliacao(): void {
    this.avaliacaoService.getMinhaAvaliacaoPorFilme(this.idFilme).subscribe({
      next: (res) => {
        this.form.patchValue({
          nota: res.nota,
          comentario: res.comentario,
        });
      },
      error: (err) => {
        console.error('Erro ao buscar avaliação:', err);
      },
    });
  }

  salvar(): void {
    if (this.form.valid) {
      const input = {
        ...this.form.value,
        idFilme: this.idFilme,
      };
      this.avaliacaoService.editarAvaliacao(this.idFilme,input).subscribe({
        next: () => {
          alert('Avaliação atualizada!');
          this.router.navigate(['/filmes']);
        },
        error: (err) => {
          console.error('Erro ao atualizar avaliação:', err);
          alert('Erro ao atualizar avaliação!');
        },
      });
    }
  }
}
