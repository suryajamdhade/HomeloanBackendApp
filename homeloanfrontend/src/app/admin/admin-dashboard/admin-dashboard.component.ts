import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {

  @Output() logout = new EventEmitter<void>();
  


  constructor(private router: Router) {}

  // get isLoggedIn() {
  //   return localStorage.getItem('token') !== null;
  // }

  onLogout() {
    console.log('Logout button clicked');
    this.logout.emit();
  }

  

}
