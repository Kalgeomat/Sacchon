import { Component, OnDestroy, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { LoginService } from './login.service';
import {filter} from 'rxjs/operators';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit,OnDestroy{
  title = 'sacchon-fe';

  isLogged:boolean;
  subscription: Subscription;
  rurl:string;
  
  
  constructor(private router:Router, private loginService:LoginService) {  }  


  ngOnInit(): void {       

    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)  
    ).subscribe((event: NavigationEnd) => {
      console.log(event.url);
      this.rurl=event.url;
      if(sessionStorage.getItem("credentials") === null && this.rurl !== "/signup"){
        this.isLogged = false
        this.router.navigate(['login'])
  
      }else if( this.rurl === "/signup"){
        this.isLogged = false
      }else{
        this.isLogged = true
      }
    });
    
    
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
