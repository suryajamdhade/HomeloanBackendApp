import { Component } from '@angular/core';
import { EnquiryInfo } from '../model/enquiry';


@Component({
  selector: 'app-enquiry',
  templateUrl: './enquiry.component.html',
  styleUrls: ['./enquiry.component.css']
})
export class EnquiryComponent {


  enquiry: EnquiryInfo = {
    enqId: 0,
    custName: '',
    custDOB: '',
    custAge: 0,
    custEmail: '',
    custMobileNo: 0,
    custAdharCardNo: 0,
    custPanCardNo: ''
  };
}
