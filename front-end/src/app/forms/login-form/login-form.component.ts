import { AfterViewInit, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit, AfterViewInit {

  loginForm: FormGroup;
  username: string;
  password: string;
  responseString: User;
  user: User;

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

    this.username = this.loginForm.get('username').value;
    this.password = this.loginForm.get('password').value;
    sessionStorage.setItem("checkcredentials", this.username + ":" + this.password);

    this.loginService.authorization(this.loginForm).subscribe(result => {
      this.user = result;

      if( this.user.role == "ROLE_PATIENT" || this.user.role == "ROLE_DOCTOR" || this.user.role == "ROLE_CHIEF_DOCTOR" ){

        this.username = this.loginForm.get('username').value;
        this.password = this.loginForm.get('password').value;
        sessionStorage.setItem("credentials", this.username + ":" + this.password);

        sessionStorage.setItem( 'luUsername', this.user.username );
        sessionStorage.setItem( 'luId', this.user.id.toString() );
        sessionStorage.setItem( 'luFirstName', this.user.firstName );
        sessionStorage.setItem( 'luLastName', this.user.lastName );
        sessionStorage.setItem( 'luRole', this.user.role );
        sessionStorage.setItem( 'username', this.user.username );

        if ( this.user.role == "ROLE_PATIENT" ){
          this.router.navigate(['medidatarepo']);
        }else if ( this.user.role == "ROLE_DOCTOR") {
          this.router.navigate(['doctoradvice']);
        }else if ( this.user.role == "ROLE_CHIEF_DOCTOR" ){
          this.router.navigate(['reporter']);
        }        
        

      }    


    } );

   
  }
  

}
