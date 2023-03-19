import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreditManagerService {
 
  private baseUrl = 'http://localhost:9094/cm-api';

  constructor(private http : HttpClient) { }

  getCreditScore(custId: number): Observable<number>{
    const url = `${this.baseUrl}/credit-score/${custId}`;
    return this.http.get<number>(url);
  }

  updateCreditScore(custId: number, creditScore: number): Observable<string> {
    const url = `${this.baseUrl}/credit-score/${custId}?creditScore=${creditScore}`;
    return this.http.post(url, null, { responseType: 'text' });
  }

  rejectLoanApplication(id: number) {
    const url = `${this.baseUrl}/rejectLoanApplication?id=${id}`;
    return this.http.patch(url, null, { responseType: 'text' });
  }
  approveLoanApplication(id: number): Observable<string>{
    const url = `${this.baseUrl}/approveLoanApplication?id=${id}`;
    return this.http.patch(url, null, { responseType: 'text' });
   
  }

  
}
