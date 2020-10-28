import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup-doctor-form',
  templateUrl: './signup-doctor-form.component.html',
  styleUrls: ['./signup-doctor-form.component.scss']
})
export class SignupDoctorFormComponent implements OnInit {

  signupDoctorForm: FormGroup;

  constructor() { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.signupDoctorForm = new FormGroup({
      sdemail: new FormControl("", Validators.required),
      sdpassword: new FormControl("", Validators.required),
      sdname: new FormControl("", Validators.required),
      sdsurname: new FormControl("", Validators.required),
      sdaddress: new FormControl(),
      sdtelephone: new FormControl(),
      sdbirthday: new FormControl("", Validators.required)
    });
  }

}
