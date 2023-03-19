import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoanApplication } from '../model/LoanApplication';
import { LoanApplicationService } from '../loan-application.service';
import { CreditManagerService } from '../credit-manager.service';

@Component({
  selector: 'app-loan-application-details',
  templateUrl: './loan-application-details.component.html',
  styleUrls: ['./loan-application-details.component.css']
})
export class LoanApplicationDetailsComponent implements OnInit {
  loanApplication!: LoanApplication;
  errorMessage: any;

  constructor(
    private route: ActivatedRoute,
    private loanApplicationService: LoanApplicationService,
    private creditManagerService: CreditManagerService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      console.log('Loan application id:', id);
      this.loanApplicationService.getLoanApplicationById(id)
        .subscribe((loanApplication: LoanApplication) => {
          this.loanApplication = loanApplication;
        });
    });
  }

  approveLoanApplication() {
    if (confirm('Are you sure you want to approve this loan application?')) {
      this.creditManagerService.approveLoanApplication(this.loanApplication.id)
        .subscribe(
          response => {
            console.log('Loan application approved:', response);
            this.loanApplication.status = 'Approved';
          },
          error => {
            console.log('Error approving loan application:', error);
            this.errorMessage = error.error;
          }
        );
    }
  }


  
  rejectLoanApplication() {
    if (confirm('Are you sure you want to reject this loan application?')) {
      this.creditManagerService.rejectLoanApplication(this.loanApplication.id)
        .subscribe(
          response => {
            console.log('Loan application reject:', response);
            this.loanApplication.status = 'Rejected';
          },
          error => {
            console.log('Error rejecting loan application:', error);
            this.errorMessage = error.error;
          }
        );
    }
  }
}
