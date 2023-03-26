import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Employee } from '../model/employee';


@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {
  employees!: Employee[];

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.adminService.getEmployees().subscribe(
      data => {
        console.log(data);
        this.employees = data;
      },
      error => {
        console.log(error);
        // Display error message
      });
  }

  updateEmployee(employee: Employee): void {
    this.adminService.updateEmployee(employee).subscribe(
      data => {
        console.log(data);
        // Display success message
      },
      error => {
        console.log(error);
        // Display error message
      });
  }

  deleteEmployee(id: number): void {
    this.adminService.deleteEmployee(id).subscribe(
      data => {
        console.log(data);
        // Display success message
      },
      error => {
        console.log(error);
        // Display error message
      });
  }
}
