import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/patient';
import { PatientsService } from 'src/app/patients.service';

@Component({
  selector: 'app-da-home',
  templateUrl: './da-home.component.html',
  styleUrls: ['./da-home.component.scss']
})
export class DaHomeComponent implements OnInit {

  dataP: Patient[]; 
  dataPI: Patient[];

  constructor(private patients: PatientsService) { }

  ngOnInit(): void {

    this.patients.getDocPatients().subscribe( result => this.dataP = result );
    this.patients.getDocPatientsInNeed().subscribe( result => this.dataPI = result );

  }

}
