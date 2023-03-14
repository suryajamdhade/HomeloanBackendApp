import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditScoreUpdateComponent } from './credit-score-update.component';

describe('CreditScoreUpdateComponent', () => {
  let component: CreditScoreUpdateComponent;
  let fixture: ComponentFixture<CreditScoreUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreditScoreUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreditScoreUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
