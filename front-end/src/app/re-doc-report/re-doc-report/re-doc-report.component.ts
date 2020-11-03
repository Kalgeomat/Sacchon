import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/doctor';
import { DoctorsService } from 'src/app/doctors.service';

@Component({
  selector: 'app-re-doc-report',
  templateUrl: './re-doc-report.component.html',
  styleUrls: ['./re-doc-report.component.scss']
})
export class ReDocReportComponent implements OnInit {

  dataD: Doctor[];   

  constructor(private httpDoctors: DoctorsService) { }

  ngOnInit(): void {

    this.httpDoctors.getDoctors().subscribe( result => this.dataD = result );

  }

}
