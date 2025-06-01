import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/app/environment';

@Injectable({
  providedIn: 'root'
})
export class FilmeService {
  private readonly API = `${environment.apiUrl}/filmes`;

  constructor(private http: HttpClient) {}

  getFilmes() {
    return this.http.get<any[]>(this.API);
  }
}
