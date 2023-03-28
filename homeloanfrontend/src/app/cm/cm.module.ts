import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditScoreComponent } from './credit-score/credit-score.component';
import { CreditScoreUpdateComponent } from './credit-score-update/credit-score-update.component';
import { LoanApplicationComponent } from './loan-application/loan-application.component';
import { LoanApplicationListComponent } from './loan-application-list/loan-application-list.component';
import { LoanApplicationDetailsComponent } from './loan-application-details/loan-application-details.component';

import { FormsModule } from '@angular/forms';
import { CmRoutingModule } from './cm-routing.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    CreditScoreComponent,
    CreditScoreUpdateComponent,
    LoanApplicationComponent,
    LoanApplicationListComponent,
    LoanApplicationDetailsComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    CmRoutingModule
  ],
  exports:[
    CreditScoreComponent,
    CreditScoreUpdateComponent,
    LoanApplicationDetailsComponent,
    LoanApplicationListComponent
  ]
})
export class CMModule { }
