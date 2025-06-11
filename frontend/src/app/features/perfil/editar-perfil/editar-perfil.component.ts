import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/auth/auth.service';
import { UsuarioService } from '../../usuarios/usuario/usuario.service';

@Component({
  selector: 'app-editar-perfil',
  templateUrl: './editar-perfil.component.html',
  styleUrls: ['./editar-perfil.component.css'],
})
export class EditarPerfilComponent implements OnInit {
  form!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private userService: UsuarioService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      nome: ['', Validators.required],
      apelido: [''],
      email: [{ value: '', disabled: true }],
    });

    this.authService.getUsuarioLogado().subscribe({
      next: (usuario) => {
        this.form.patchValue({
          nome: usuario.nome,
          apelido: usuario.apelido,
          email: usuario.email,
        });
      },
      error: () => this.router.navigate(['/login']),
    });
  }

  salvar(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const dados = {
      nome: this.form.get('nome')?.value,
      apelido: this.form.get('apelido')?.value,
    };

    this.userService.atualizarUsuario(dados).subscribe({
      next: () => this.router.navigate(['/perfil']),
      error: (err) => alert('Erro ao atualizar: ' + err.message),
    });
  }
}
