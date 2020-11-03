import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Medi, SignUp } from 'src/app/Medi';


@Component({
  selector: 'codehub-mdr-sign-up-page',
  templateUrl: './mdr-sign-up-page.component.html',
  styleUrls: ['./mdr-sign-up-page.component.scss']
})
export class MDRSignUpPageComponent implements OnInit {
  [x: string]: any;

  constructor() { }

  myForm: FormGroup;
  ngOnInit(): void {
    this.myForm = new FormGroup({
      email: new FormControl("", Validators.required),
      password: new FormControl("", [Validators.required,Validators.minLength(8)]),
      name: new FormControl("", Validators.required),
      surename: new FormControl("", Validators.required),
      address: new FormControl("", Validators.required),
      telephone_number: new FormControl("", Validators.required),
      birthday: new FormControl("", Validators.required),
      sex: new FormControl("", Validators.required),
      sign_up: new FormControl(),
    });
  }


  onClickSubmit() {
    let medi:SignUp ={
  
      address:this.myForm.get('addres').value,
      dob:this.myForm.get('dirthday').value,
      email:this.myForm.get('email').value,
      firstName:this.myForm.get('name').value,
      gender:this.myForm.get('sex').value,
      lastName:this.myForm.get('surename').value,
      password:this.myForm.get('password').value,
      telephoneNumber:this.myForm.get('telephone_number').value,
      //isActive: 1;
      //doctor_id:
      //lastConsultedOrSignUp:
      
      };
      
      this.MediService.addMedi(medi).subscribe(data => {
        alert(JSON.stringify(data));
        this.ngOnInit();
      });

  
    }


}