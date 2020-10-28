import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-blood-glucose-form',
  templateUrl: './blood-glucose-form.component.html',
  styleUrls: ['./blood-glucose-form.component.scss']
})
export class BloodGlucoseFormComponent implements OnInit {

  bloodGlucoseForm: FormGroup;

  constructor() { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.bloodGlucoseForm = new FormGroup({
      bglevel: new FormControl("", Validators.required),
      bgdate: new FormControl("", Validators.required),
      bgtime: new FormControl("", Validators.required)
    });
  }

}
