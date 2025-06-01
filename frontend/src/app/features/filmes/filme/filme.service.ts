import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/app/environment';
import { FilmeOutput } from 'src/app/interfaces/filme';

@Injectable({
  providedIn: 'root',
})
export class FilmeService {
  private readonly API = `${environment.apiUrl}/filmes`;

  constructor(private http: HttpClient) {}

  getFilmes(): Observable<FilmeOutput[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });

    return this.http.get<FilmeOutput[]>(`${this.API}/all`, { headers });
  }
}
