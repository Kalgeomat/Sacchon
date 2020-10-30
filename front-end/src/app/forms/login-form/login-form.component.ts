import { AfterViewInit, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit, AfterViewInit {

  loginForm: FormGroup;

  constructor() { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.loginForm = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    });
  }

  ngAfterViewInit(): void {
    const isPasswordValid: boolean = this.loginForm.get('password').valid;
    console.log(isPasswordValid);
  }

  // logIn() {
  //   var responseString = this.loginService.authorization(this.form);
  //   if (responseString == "OK") {
  //     this.username = this.form.get('login').value;
  //     this.password = this.form.get('password').value;
  //     sessionStorage.setItem("credentials", this.login + ":" + this.password)
  //     this.router.navigate(['view'])
  //   }
  //   else {
  //     alert("Wrong login or password!!!");
  //   }
  // }

}
