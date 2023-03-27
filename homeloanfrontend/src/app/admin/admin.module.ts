import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';
import { FormsModule } from '@angular/forms';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminRoutingModule } from './admin-routing.module';



@NgModule({
  declarations: [
    AddEmployeeComponent,
    ViewEmployeeComponent,
    AdminDashboardComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    AdminRoutingModule
  ],exports:[
    AddEmployeeComponent,
    ViewEmployeeComponent,
    AdminDashboardComponent
  ]
})
export class AdminModule { }
