import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AddEmployeeComponent,
    ViewEmployeeComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],exports:[
    AddEmployeeComponent,
    ViewEmployeeComponent
  ]
})
export class AdminModule { }
