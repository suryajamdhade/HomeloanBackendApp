import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EnquiryComponent } from './enquiry/enquiry.component';



@NgModule({
  declarations: [
    EnquiryComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    EnquiryComponent
  ]
})
export class REModule { }
