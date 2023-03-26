import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './admin/add-employee/add-employee.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  
  { path : "login", component : LoginComponent},
  { path: "admin", component : AddEmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
