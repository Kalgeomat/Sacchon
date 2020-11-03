import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  isLogged:boolean;
  subscription: Subscription;
  // luRole:string;
  
  constructor(private router:Router) { }

  ngOnInit(): void {
    // this.luRole = sessionStorage.getItem('luRole');


  }

  logOut(){
    sessionStorage.removeItem("credentials");
    this.isLogged = false;
    this.router.navigate(['login']);
  }

}
