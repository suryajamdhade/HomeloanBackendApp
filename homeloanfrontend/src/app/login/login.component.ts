import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { JwtResponse } from '../admin/model/JwtResponse';
import { LoginService } from '../login.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username!: string;
  password!: string;
  //@Output() loggedIn = new EventEmitter<boolean>();

 

  constructor(private loginService: LoginService, private authService : AuthService, private router: Router) {
    // Check if the user is already authenticated
    if (localStorage.getItem('token')) {
      //this.loggedIn.emit(true);
      this.authService.loggedIn.next(true);
      this.router.navigate(['/admin']);
    }
  }



  onSubmit() {
    this.loginService.login(this.username, this.password).subscribe(
      (response: JwtResponse) => {
        // Save the token in local storage
        localStorage.setItem('token', response.token);
          console.log(response.token);
        // Emit the loggedIn event
      
        //this.loggedIn.emit(true);
        this.authService.loggedIn.next(true);
        // Redirect the user to the home page
        this.router.navigate(['/admin']);
      },
      (error) => {
        // Handle the error
        console.error('Error logging in: ', error);
      }
    );
  }

  logout() {
    console.log("inside logout method of login component");
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
  
}
