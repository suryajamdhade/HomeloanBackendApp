import { Component } from '@angular/core';
import { CreditManagerService } from '../credit-manager.service';

@Component({
  selector: 'app-credit-score',
  templateUrl: './credit-score.component.html',
  styleUrls: ['./credit-score.component.css']
})
export class CreditScoreComponent {

  creditScore: number = 0;

  custId: number = 0;
  constructor(private creditManagerService: CreditManagerService) { }

  getCreditScore(custId: number){
    this.creditManagerService.getCreditScore(custId).subscribe((creditScore: number) => {
      this.creditScore = creditScore;
    });
  }
}
