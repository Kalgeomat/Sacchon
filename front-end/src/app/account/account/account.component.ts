import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorsService } from 'src/app/doctors.service';
import { PatientsService } from 'src/app/patients.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  isLogged:boolean;

  constructor(private patientService: PatientsService, private doctorService: DoctorsService, private router:Router) { }

  ngOnInit(): void {
  }

  onClickDRemove(){
    this.doctorService.deleteDoctor().subscribe(data => {
      alert("Account Removed!");
      this.ngOnInit();
      sessionStorage.removeItem("credentials");
      this.isLogged = false;
      this.router.navigate(['login']); 
    });
  }

  onClickPRemove(){
    this.patientService.deletePatient().subscribe(data => {
      alert("Account Removed!");
      this.ngOnInit();
      sessionStorage.removeItem("credentials");
      this.isLogged = false;
      this.router.navigate(['login']); 
    });
  }

}
