import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-period-form',
  templateUrl: './period-form.component.html',
  styleUrls: ['./period-form.component.scss']
})
export class PeriodFormComponent implements OnInit {

  periodForm: FormGroup;

  constructor() { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.periodForm = new FormGroup({
      pfrom: new FormControl("", Validators.required),
      pto: new FormControl("", Validators.required)
    });
  }

}
