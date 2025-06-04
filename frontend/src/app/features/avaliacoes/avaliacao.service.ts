import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/app/environment';
import { AvaliacaoInput, AvaliacaoOutput } from 'src/app/interfaces/avaliacao';

@Injectable({
  providedIn: 'root'
})
export class AvaliacaoService {

  private readonly API = `${environment.apiUrl}/avaliacoes`;

  constructor(private http: HttpClient) {}

  avaliar(input: AvaliacaoInput): Observable<AvaliacaoOutput> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return this.http.post<AvaliacaoOutput>(`${this.API}/create`, input, { headers });
  }

  getAll(): Observable<AvaliacaoOutput[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return this.http.get<AvaliacaoOutput[]>(`${this.API}/all`, { headers });
  }
}
