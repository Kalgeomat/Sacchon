import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from 'src/app/patient';
import { PatientsService } from 'src/app/patients.service';

@Component({
  selector: 'app-signup-patient-form',
  templateUrl: './signup-patient-form.component.html',
  styleUrls: ['./signup-patient-form.component.scss']
})
export class SignupPatientFormComponent implements OnInit {

  signupPatientForm: FormGroup;

  constructor(private patientService: PatientsService, private router:Router) { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.signupPatientForm = new FormGroup({
      spusername: new FormControl("", Validators.required),
      spemail: new FormControl("", Validators.required),
      spname: new FormControl("", Validators.required),
      sppassword: new FormControl("", Validators.required),
      spsurname: new FormControl("", Validators.required),
      spaddress: new FormControl(),
      sptelephone: new FormControl(),
      spbirthday: new FormControl("", Validators.required)
    });

  }

  onClickSubmit() {
    let patient:Patient ={
      username:this.signupPatientForm.get('spusername').value,
      email:this.signupPatientForm.get('spemail').value,
      password:this.signupPatientForm.get('sppassword').value,
      firstName:this.signupPatientForm.get('spname').value,
      lastName:this.signupPatientForm.get('spsurname').value,
      address:this.signupPatientForm.get('spaddress').value,
      telephoneNumber:this.signupPatientForm.get('sptelephone').value,
      dob:this.signupPatientForm.get('spbirthday').value
    };
   

    this.patientService.addPatient(patient).subscribe(data => {
      // alert(JSON.stringify(data));
      this.ngOnInit();
      this.router.navigate(['login']);
    });
    
  }

}
