import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Doctor } from 'src/app/doctor';
import { DoctorsService } from 'src/app/doctors.service';

@Component({
  selector: 'app-signup-doctor-form',
  templateUrl: './signup-doctor-form.component.html',
  styleUrls: ['./signup-doctor-form.component.scss']
})
export class SignupDoctorFormComponent implements OnInit {

  signupDoctorForm: FormGroup;

  constructor(private doctorService: DoctorsService) { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.signupDoctorForm = new FormGroup({
      sdusername: new FormControl("", Validators.required),
      sdemail: new FormControl("", Validators.required),
      sdpassword: new FormControl("", Validators.required),
      sdname: new FormControl("", Validators.required),
      sdsurname: new FormControl("", Validators.required),
      sdaddress: new FormControl(),
      sdtelephone: new FormControl(),
      sdbirthday: new FormControl("", Validators.required)
    });
  }


  onClickSubmit() {
    let doctor:Doctor ={
      username:this.signupDoctorForm.get('sdusername').value,
      email:this.signupDoctorForm.get('sdemail').value,
      password:this.signupDoctorForm.get('sdpassword').value,
      firstName:this.signupDoctorForm.get('sdname').value,
      lastName:this.signupDoctorForm.get('sdsurname').value,
      address:this.signupDoctorForm.get('sdaddress').value,
      telephoneNumber:this.signupDoctorForm.get('sdtelephone').value,
      dob:this.signupDoctorForm.get('sdbirthday').value
    };
   

    this.doctorService.addDoctor(doctor).subscribe(data => {
      alert(JSON.stringify(data));
      this.ngOnInit();
    });
    
  }



}
