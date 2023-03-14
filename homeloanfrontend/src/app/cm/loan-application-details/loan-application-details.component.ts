import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoanApplicationService } from '../loan-application.service';
import { LoanApplication } from '../model/LoanApplication';

@Component({
  selector: 'app-loan-application-details',
  templateUrl: './loan-application-details.component.html',
  styleUrls: ['./loan-application-details.component.css']
})
export class LoanApplicationDetailsComponent {

  constructor(
    private route: ActivatedRoute,
    private loanApplicationService: LoanApplicationService
  ) { }

  loanApplication!: LoanApplication;

  ngOnInit(): void {
    const snapshot = this.route.snapshot;
    if(snapshot !== null){
    const id = +snapshot.paramMap.get('id')!;
    this.loanApplicationService.getLoanApplicationById(id)
      .subscribe(loanApplication => this.loanApplication = loanApplication);
    }
  }
  
}
