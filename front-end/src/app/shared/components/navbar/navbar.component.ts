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

  constructor(private router:Router) { }

  ngOnInit(): void {

  }

  logOut(){
    sessionStorage.removeItem("credentials")
    this.isLogged = false
    this.router.navigate(['login']) 
  }

}
