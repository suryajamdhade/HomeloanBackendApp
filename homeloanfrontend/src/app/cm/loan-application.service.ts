import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoanApplication } from './model/LoanApplication';

@Injectable({
  providedIn: 'root'
})
export class LoanApplicationService {

  private baseUrl = 'http://localhost:4000/loan-applications';

  constructor(private http: HttpClient) { }

  createLoanApplication(loanApplication: LoanApplication): Observable<LoanApplication> {
    return this.http.post<LoanApplication>(this.baseUrl, loanApplication);
  }

  getLoanApplicationById(id: number): Observable<LoanApplication> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<LoanApplication>(url);
  }

  getAllLoanApplications(): Observable<LoanApplication[]> {
    return this.http.get<LoanApplication[]>(this.baseUrl);
  }

  updateLoanApplication(id: number, loanApplication: LoanApplication): Observable<LoanApplication> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.put<LoanApplication>(url, loanApplication);
  }

  
}
