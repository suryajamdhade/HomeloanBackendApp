import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditScoreComponent } from './credit-score/credit-score.component';
import { CreditScoreUpdateComponent } from './credit-score-update/credit-score-update.component';
import { LoanApplicationComponent } from './loan-application/loan-application.component';
import { LoanApplicationListComponent } from './loan-application-list/loan-application-list.component';
import { LoanApplicationDetailsComponent } from './loan-application-details/loan-application-details.component';
import { LoanApplicationApprovalComponent } from './loan-application-approval/loan-application-approval.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    CreditScoreComponent,
    CreditScoreUpdateComponent,
    LoanApplicationComponent,
    LoanApplicationListComponent,
    LoanApplicationDetailsComponent,
    LoanApplicationApprovalComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports:[
    CreditScoreComponent,
    CreditScoreUpdateComponent
  ]
})
export class CMModule { }
