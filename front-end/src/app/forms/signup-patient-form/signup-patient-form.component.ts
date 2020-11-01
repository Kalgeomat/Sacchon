import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Patient } from 'src/app/patient';
import { PatientsService } from 'src/app/patients.service';

@Component({
  selector: 'app-signup-patient-form',
  templateUrl: './signup-patient-form.component.html',
  styleUrls: ['./signup-patient-form.component.scss']
})
export class SignupPatientFormComponent implements OnInit {

  signupPatientForm: FormGroup;

  constructor(private patientService: PatientsService) { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.signupPatientForm = new FormGroup({
      spusername: new FormControl("", Validators.required),
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

  onClickSubmit() {
    let patient:Patient ={
      username:this.signupPatientForm.get('spusername').value,
      email:this.signupPatientForm.get('spemail').value,
      password:this.signupPatientForm.get('sppassword').value,
      firstName:this.signupPatientForm.get('spname').value,
      lastName:this.signupPatientForm.get('spsurname').value,
      address:this.signupPatientForm.get('spaddress').value,
      telephoneNumber:this.signupPatientForm.get('sptelephone').value,
      dob:this.signupPatientForm.get('spbirthday').value,
      gender:1
    };
   

    this.patientService.addPatient(patient).subscribe(data => {
      alert(JSON.stringify(data));
      this.ngOnInit();
    });
    
  }

}
