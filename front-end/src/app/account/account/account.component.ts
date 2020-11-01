import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorsService } from 'src/app/doctors.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  isLogged:boolean;

  constructor(private doctorService: DoctorsService, private router:Router) { }

  ngOnInit(): void {
  }

  onClickRemove(){
    this.doctorService.deleteDoctor().subscribe(data => {
      alert("Account Removed!");
      this.ngOnInit();
      sessionStorage.removeItem("credentials");
      this.isLogged = false;
      this.router.navigate(['login']); 
    });



  }

}
