import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  usuarioNome: string | null = '';

  ngOnInit() {
    this.usuarioNome = localStorage.getItem('usuarioNome');
  }
}
