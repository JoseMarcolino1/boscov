import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/app/environment';
import { GeneroOutput } from 'src/app/interfaces/filme';

@Injectable({
  providedIn: 'root',
})
export class GeneroService {
  private readonly API = environment.apiUrl + '/generos';

  constructor(private http: HttpClient) {}

  getGeneros() {
    const token = localStorage.getItem('token');
    const headers = {
      Authorization: `Bearer ${token}`,
    };
    return this.http.get<any[]>(this.API + '/all', { headers });
  }

  createGenero(descricao: string): Observable<GeneroOutput> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return this.http.post<GeneroOutput>(
      `${this.API}/create`,
      { descricao },
      { headers }
    );
  }
}
