import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-consultation-form',
  templateUrl: './consultation-form.component.html',
  styleUrls: ['./consultation-form.component.scss']
})
export class ConsultationFormComponent implements OnInit {

  consultationForm: FormGroup;

  constructor() { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.consultationForm = new FormGroup({
      consultation: new FormControl("", Validators.required)
    });
  }

}
