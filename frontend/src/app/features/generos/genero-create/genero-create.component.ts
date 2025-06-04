import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GeneroService } from '../genero.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-genero-create',
  templateUrl: './genero-create.component.html',
  styleUrls: ['./genero-create.component.css']
})
export class GeneroCreateComponent {
  form!: FormGroup;

  
  constructor(
    private fb: FormBuilder,
    private generoService: GeneroService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      descricao: ['', Validators.required],
    });
  }

  salvar() {
    if (this.form.valid) {
      const descricao = this.form.value.descricao;
      this.generoService.createGenero(descricao).subscribe({
        next: () => {
          alert('Gênero criado com sucesso!');
          this.router.navigate(['/filmes']);
        },
        error: (err) => {
          console.error('Erro ao criar gênero:', err);
          alert('Erro ao criar gênero');
        },
      });
    }
  }
}
