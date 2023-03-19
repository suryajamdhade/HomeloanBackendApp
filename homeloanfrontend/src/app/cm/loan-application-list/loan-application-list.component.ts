import { Component, OnInit } from '@angular/core';
import { LoanApplication } from '../model/LoanApplication';
import { LoanApplicationService } from '../loan-application.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loan-application-list',
  templateUrl: './loan-application-list.component.html',
  styleUrls: ['./loan-application-list.component.css']
})
export class LoanApplicationListComponent implements OnInit {

  loanApplications!: LoanApplication[];

  
  constructor(private loanApplicationService: LoanApplicationService, private router: Router) { }

  ngOnInit() {
    this.getAllLoanApplications();
  }

  getAllLoanApplications(): void {
    this.loanApplicationService.getAllLoanApplications()
      .subscribe(loanApplications => this.loanApplications = loanApplications);
  }

  showLoanApplicationDetails(id: number) {
    console.log('Clicked loan application id:', id);
    this.router.navigate(['/loan-application', id]);
  }

}
