import { Component } from '@angular/core';
import { AuthService } from 'src/app/core/auth/auth.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {
  

  constructor(private authService: AuthService) { 

  }

  isLoggedIn(): boolean {
    return this.authService.isAuthenticated();
  }
} 
