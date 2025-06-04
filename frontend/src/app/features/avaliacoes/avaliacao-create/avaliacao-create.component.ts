import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/core/auth/auth.service';
import { AvaliacaoService } from '../avaliacao.service';

@Component({
  selector: 'app-avaliacao-create',
  templateUrl: './avaliacao-create.component.html',
  styleUrls: ['./avaliacao-create.component.css'],
})
export class AvaliacaoCreateComponent {
  form!: FormGroup;
  idFilme!: number;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private avaliacaoService: AvaliacaoService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.idFilme = Number(this.route.snapshot.paramMap.get('id'));
    this.form = this.fb.group({
      nota: [
        null,
        [Validators.required, Validators.min(1), Validators.max(10)],
      ],
      comentario: ['', Validators.required],
    });
  }

  
  salvar() {
    if (this.form.valid) {
      const idUsuario = this.authService.getUserId(); 
      const input = {
        ...this.form.value,
        idUsuario,
        idFilme: this.idFilme,
      };
      this.avaliacaoService.avaliar(input).subscribe({
        next: () => {
          alert('Avaliação enviada!');
          this.router.navigate(['/filmes']);
        },
        error: (err) => {
          console.error('Erro ao enviar avaliação:', err);
          alert('Erro ao enviar avaliação.');
        },
      });
    }
  }
}
