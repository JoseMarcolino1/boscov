import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/core/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private auth: AuthService,
    private router: Router
  ) {
    this.form = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      senha: ['', Validators.required]
    });
  }

  login() {
    if (this.form.valid) {
      this.auth.login(this.form.value).subscribe({
        next: (res: any) => {
          this.auth.saveToken(res.token);
          this.router.navigate(['/']);
        },
        error: () => alert('Email ou senha inválidos')
      });
    }
  }
}
