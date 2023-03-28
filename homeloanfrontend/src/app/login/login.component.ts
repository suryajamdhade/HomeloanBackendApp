import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username!: string;
  password!: string;
  @Output() loggedIn = new EventEmitter<boolean>();

  constructor(private loginService: LoginService, private router: Router) {}

  onSubmit() {
    this.loginService.login(this.username, this.password)
      .subscribe(response => {
        console.log(response);
      });
      
      this.loggedIn.emit(true);
      this.router.navigate(['/admin']);
  }
}
