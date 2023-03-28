import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoanApplicationService } from '../loan-application.service';
import { LoanApplication } from '../model/LoanApplication';

@Component({
  selector: 'app-loan-application',
  templateUrl: './loan-application.component.html',
  styleUrls: ['./loan-application.component.css']
})
export class LoanApplicationComponent implements OnInit {
  loanApplication: LoanApplication = new LoanApplication();
  message!: string;

  constructor(private loanApplicationService: LoanApplicationService) { }

  ngOnInit(): void { }

  createLoanApplication(loanApplicationForm: NgForm): void {
    this.loanApplicationService.createLoanApplication(this.loanApplication).subscribe(
      (loanApplication: LoanApplication) => {
        this.message = `Loan application created with ID: ${loanApplication.id}`;
        loanApplicationForm.resetForm();
      },
      (error: any) => {
        this.message = 'Error creating loan application';
        console.error(error);
      }
    );
  }
}
