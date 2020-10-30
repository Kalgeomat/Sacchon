import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { HttpDoctorsService } from './http-doctors.service';
import { LoginService } from './login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit,OnDestroy{
  title = 'sacchon-fe';

  // username: string
  // password: string
  isLogged:boolean;
  subscription: Subscription;
  


  constructor(private router:Router, private loginService:LoginService) {}

  ngOnInit(): void {

    // this.username = 'john';
    // this.password = 'john';
    //   sessionStorage.setItem("credentials", this.username + ":" + this.password)
      // this.router.navigate(['view'])

    // this.httpDoctors.getDoctors().subscribe((data) => {
    //   console.log(data);      
    // });

    if(sessionStorage.getItem("credentials") === null){
      this.isLogged = false
      this.router.navigate(['login'])
    }
    else{
      this.isLogged = true
      // this.router.navigate(['medidatarepo'])
    }
    this.subscription = this.loginService.responseOfAuth.subscribe(data=>{
      this.isLogged = data;
    });
    
   
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }



}
