import { Component } from '@angular/core';
import { LoanApplicationService } from '../loan-application.service';
import { LoanApplication } from '../model/LoanApplication';


@Component({
  selector: 'app-loan-application-list',
  templateUrl: './loan-application-list.component.html',
  styleUrls: ['./loan-application-list.component.css']
})
export class LoanApplicationListComponent {

  constructor(private loanApplicationService: LoanApplicationService) { }
  
  loanApplications: LoanApplication[] = [];

  ngOnInit() {
    this.getAllLoanApplications();
  }
  
  getAllLoanApplications() {
    this.loanApplicationService.getAllLoanApplications()
      .subscribe((loanApplications: LoanApplication[]) => {
        this.loanApplications = loanApplications;
      });
  }

  
}
