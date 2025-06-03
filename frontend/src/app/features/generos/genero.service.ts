import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/app/environment';

@Injectable({
  providedIn: 'root'
})
export class GeneroService {
  private readonly API = environment.apiUrl + '/generos';


  constructor(private http: HttpClient) { }

 
  getGeneros() {
    const token = localStorage.getItem('token');
    const headers = {
      Authorization: `Bearer ${token}`
    };
    return this.http.get<any[]>(this.API + '/all', { headers });
  }

}
