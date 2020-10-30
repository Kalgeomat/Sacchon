import { AfterViewInit, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit, AfterViewInit {

  loginForm: FormGroup;
  username: string;
  password: string;

  constructor(private router: Router, private loginService: LoginService) { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.loginForm = new FormGroup({
      username: new FormControl(),
      password: new FormControl()
    });
  }

  ngAfterViewInit(): void {
    const isPasswordValid: boolean = this.loginForm.get('password').valid;
    console.log(isPasswordValid);
  }

  logIn() {
    var responseString = this.loginService.authorization(this.loginForm);
    if (responseString == "OK") {
      this.username = this.loginForm.get('username').value;
      this.password = this.loginForm.get('password').value;
      sessionStorage.setItem("credentials", this.username + ":" + this.password);
      this.router.navigate(['medidatarepo']);
      // this.router.navigate(['doctoradvice'])
      // this.router.navigate(['reporter'])
    }
    else {
      alert("Wrong login or password!!!");
    }
  }

}
