import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/doctor';
import { HttpDoctorsService } from 'src/app/http-doctors.service';

@Component({
  selector: 'app-re-doc-report',
  templateUrl: './re-doc-report.component.html',
  styleUrls: ['./re-doc-report.component.scss']
})
export class ReDocReportComponent implements OnInit {

  dataD: Doctor = {
    email: '',
    password: '',
    firstName: '',
    lastName: '',
    address: '',
    telephoneNumber: 0,
    gender: 0
  };

  constructor(private httpDoctors: HttpDoctorsService) { }

  ngOnInit(): void {

    this.httpDoctors.getDoctors().subscribe( result => this.dataD = result );

  }

}
