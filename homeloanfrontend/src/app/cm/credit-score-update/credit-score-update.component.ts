import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CreditManagerService } from '../credit-manager.service';

@Component({
  selector: 'app-credit-score-update',
  templateUrl: './credit-score-update.component.html',
  styleUrls: ['./credit-score-update.component.css']
})
export class CreditScoreUpdateComponent {

  customerId: number;
  creditScore: number = 0;

  constructor(private creditManagerService: CreditManagerService, private route: ActivatedRoute) { 
    this.customerId = this.route.snapshot.params['customerId'];
  }

  updateCreditScore(){
    this.creditManagerService.updateCreditScore(this.customerId, this.creditScore).subscribe((creditScore: number) => {
      console.log("Credit score updated successfully.");
    });
  }
}