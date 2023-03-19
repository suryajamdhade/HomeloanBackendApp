import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoanApplicationDetailsComponent } from './loan-application-details/loan-application-details.component';

const cmRoutes: Routes = [
    { path: 'loan-application/:id', component: LoanApplicationDetailsComponent }

];

@NgModule({
  imports: [RouterModule.forChild(cmRoutes)],
  exports: [RouterModule]
})
export class CmRoutingModule { }
