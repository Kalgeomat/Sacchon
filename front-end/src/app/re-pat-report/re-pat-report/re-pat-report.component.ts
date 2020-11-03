import { Component, OnInit } from '@angular/core';
import { PatientDue } from 'src/app/patientDue';
import { PatientsService } from 'src/app/patients.service';

@Component({
  selector: 'app-re-pat-report',
  templateUrl: './re-pat-report.component.html',
  styleUrls: ['./re-pat-report.component.scss']
})
export class RePatReportComponent implements OnInit {


  duepatients: PatientDue[];

  constructor(private patientService: PatientsService) { }

  ngOnInit(): void {

    this.patientService.getAllPatientsInNeed().subscribe( result => this.duepatients = result);
  }



}
