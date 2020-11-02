import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { Login, Medi } from '../Medi';


@Component({
  selector: 'codehub-mdr-login-page',
  templateUrl: './mdr-login-page.component.html',
  styleUrls: ['./mdr-login-page.component.scss']
})
export class MDRLoginPageComponent implements OnInit {

  constructor(email: string, password: string) { }

  myForm: FormGroup;
    ngOnInit(): void {
      this.myForm = new FormGroup({
        email: new FormControl("", [Validators.required,Validators.minLength(8)]),
        password: new FormControl("", Validators.required),
        sign_in: new FormControl(),
      });
    }

  onClickSubmit() {
    let medi:Login = {

      email:this.myForm.get('email').value,
      password:this.myForm.get('password').value,
      };
  
    }

}