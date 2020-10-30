import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup-patient-form',
  templateUrl: './signup-patient-form.component.html',
  styleUrls: ['./signup-patient-form.component.scss']
})
export class SignupPatientFormComponent implements OnInit {

  signupPatientForm: FormGroup;

  constructor() { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.signupPatientForm = new FormGroup({
      email: new FormControl("", Validators.required),
      firstName: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required),
      lastName: new FormControl("", Validators.required),
      address: new FormControl(),
      telephoneNumber: new FormControl(),
      dob: new FormControl("", Validators.required),
      gender: new FormControl("", Validators.required)
      // doctor_id: 1
    });

  }

}
