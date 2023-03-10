import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreditManagerService {

  private baseUrl = 'http://localhost:4000/cm-api';

  constructor(private http : HttpClient) { }

  getCreditScore(custId: number): Observable<number>{
    const url = `${this.baseUrl}/credit-score/${custId}`;
    return this.http.get<number>(url);
  }

  updateCreditScore(custId: number, creditScore: number): Observable<number> {
    const url = `${this.baseUrl}/credit-score/${custId}`;
    return this.http.post<number>(url, creditScore);
  }

  approveOrRejectLoan(applicationId: number, isApproved: boolean): Observable<void> {
    const url = `${this.baseUrl}/loan-applications/${applicationId}`;
    return this.http.put<void>(url, isApproved);
  }
  
 
  
}
