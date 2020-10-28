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
      spemail: new FormControl("", Validators.required),
      spname: new FormControl("", Validators.required),
      sppassword: new FormControl("", Validators.required),
      spsurname: new FormControl("", Validators.required),
      spaddress: new FormControl(),
      sptelephone: new FormControl(),
      spbirthday: new FormControl("", Validators.required),
      spsex: new FormControl("", Validators.required)
    });

  }

}
