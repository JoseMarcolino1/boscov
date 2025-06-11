import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FilmeService } from '../filme/filme.service';
import { Router } from '@angular/router';
import { GeneroService } from '../../generos/genero.service';

@Component({
  selector: 'app-filme-create',
  templateUrl: './filme-create.component.html',
  styleUrls: ['./filme-create.component.css'],
})
export class FilmeCreateComponent {
  form!: FormGroup;
  generos: any[] = [];

  constructor(
    private fb: FormBuilder,
    private filmeService: FilmeService,
    private generoService: GeneroService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      nome: ['', Validators.required],
      diretor: ['', Validators.required],
      anoLancamento: ['', Validators.required],
      generosIds: [[], Validators.required],
      duracao: ['', Validators.required],
      produtora: ['', Validators.required],
      classificacao: ['', Validators.required],
      poster: [''],
    });

    this.generoService.getGeneros().subscribe({
      next: (res) => (this.generos = res),
      error: (err) => console.error('Erro ao carregar gêneros:', err),
    });
  }

  salvar() {
    this.form.markAllAsTouched();

    if (this.form.valid) {
      this.filmeService.salvarFilme(this.form.value).subscribe({
        next: (res) => {
          console.log('Filme cadastrado:', res);
          this.router.navigate(['/filmes']);
        },
        error: (err) => {
          console.error('Erro ao salvar filme:', err);
          alert('Erro ao salvar filme');
        },
      });
    } else {
      console.log('Formulário inválido! Mensagens de erro mostradas.');
    }
  }
}
