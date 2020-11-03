import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/patient';
import { PatientsService } from 'src/app/patients.service';

@Component({
  selector: 'app-da-new-patient',
  templateUrl: './da-new-patient.component.html',
  styleUrls: ['./da-new-patient.component.scss']
})
export class DaNewPatientComponent implements OnInit {

  newPatients: Patient[];

  constructor(private patientService:PatientsService, private router:Router) { }

  ngOnInit(): void {

    this.patientService.getNewPatientsInNeed().subscribe( result => this.newPatients = result );
  }

  viewOPData() {
    this.router.navigate(['doctoradvice/patient']);
  }

  

}
