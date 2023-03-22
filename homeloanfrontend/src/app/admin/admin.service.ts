import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './model/employee';


@Injectable({
  providedIn: 'root'
})
export class AdminService {
 
  private baseUrl = 'http://localhost:9091/admin';

  constructor(private http: HttpClient) { }

  addEmployee(employee: Employee): Observable<Employee> {
    console.log("Inside admin service");
    return this.http.post<Employee>(`${this.baseUrl}/employee`, employee);
  }

  getEmployeeById(empId: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.baseUrl}/employee/${empId}`);
  }

  updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.baseUrl}/employee/${employee.id}`, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/employee/${id}`, { responseType: 'text' });
  }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.baseUrl}/employees`);
  }
}
