import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { Employee } from '../model/employee';


@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent {
  employee: Employee = new Employee();

  constructor(private adminService: AdminService) { }

  saveEmployee(): void {
    console.log("Inside add employee component");
    this.adminService.addEmployee(this.employee).subscribe(

      
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
