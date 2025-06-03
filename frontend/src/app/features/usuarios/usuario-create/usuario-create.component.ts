import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioService } from '../usuario/usuario.service';

@Component({
  selector: 'app-usuario-create',
  templateUrl: './usuario-create.component.html',
  styleUrls: ['./usuario-create.component.css']
})
export class UsuarioCreateComponent {
    form!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuarioService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      senha: ['', Validators.required],
      apelido: [''],
      dataNascimento: [''],
      tipoUsuario: ['USER', Validators.required] // default USER
    });
  }

  salvar() {
    if (this.form.valid) {
      this.usuarioService.cadastrarUsuario(this.form.value).subscribe({
        next: (res) => {
          console.log('Usuário cadastrado:', res);
          alert('Usuário criado com sucesso!');
          this.router.navigate(['/login']); // ou onde você preferir
        },
        error: (err) => {
          console.error('Erro ao cadastrar usuário:', err);
          alert('Erro ao cadastrar usuário');
        },
      });
    }
  }
}
