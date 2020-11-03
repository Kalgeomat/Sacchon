import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Medi } from '../Medi';


@Component({
  selector: 'codehub-mdr-account-page',
  templateUrl: './mdr-account-page.component.html',
  styleUrls: ['./mdr-account-page.component.scss']
})
export class MDRAccountPageComponent implements OnInit {

  constructor() { }

  myForm: FormGroup;
  ngOnInit(): void {
    this.myForm = new FormGroup({
      
      submit: new FormControl(),
      
    });
}


onClickSubmit_carb_intake_grams() {

  }
}