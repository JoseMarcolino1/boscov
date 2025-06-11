import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/app/environment';
import { UsuarioOutput } from 'src/app/interfaces/usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  private readonly API = environment.apiUrl + '/usuarios';

  constructor(private http: HttpClient) {}

  cadastrarUsuario(usuario: UsuarioOutput) {
    return this.http.post<UsuarioOutput>(`${this.API}/create`, usuario);
  }

  atualizarUsuario(dados: Partial<UsuarioOutput>) {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return this.http.put<UsuarioOutput>(`${this.API}/me`, dados, {headers});
  }
}
