import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'codehub-mdr-past-consultations-page',
  templateUrl: './mdr-past-consultations-page.component.html',
  styleUrls: ['./mdr-past-consultations-page.component.scss']
})
export class MDRPastConsultationsPageComponent implements OnInit {

  constructor() { }


  myForm: FormGroup;
  ngOnInit(): void {

    this.myForm = new FormGroup({

      past_consultations: new FormControl(),
      
    });


  }

}
