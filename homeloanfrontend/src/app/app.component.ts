import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  isLoggedIn = false;
  title: any;

  constructor(private authService: AuthService,private router: Router) {

    authService.loggedIn.subscribe((loggedIn: boolean) => {
      this.isLoggedIn = loggedIn;
    });
  }

  
  // onLoggedIn(loggedIn: boolean) {
  //   debugger;
  //   console.log('isLoggedIn: ', loggedIn);
  //   this.isLoggedIn = loggedIn;
  //   console.log('isLoggedIn: ', loggedIn);
  // }

  onLogout() {
    debugger;
    localStorage.removeItem('token');
    console.log("token is removed");
    this.isLoggedIn = false;
    console.log("isloggedin is set to false");
    this.router.navigate(['/login']);
  }
}
