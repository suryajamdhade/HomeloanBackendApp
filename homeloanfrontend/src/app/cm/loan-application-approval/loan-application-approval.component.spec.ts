import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanApplicationApprovalComponent } from './loan-application-approval.component';

describe('LoanApplicationApprovalComponent', () => {
  let component: LoanApplicationApprovalComponent;
  let fixture: ComponentFixture<LoanApplicationApprovalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanApplicationApprovalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoanApplicationApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
