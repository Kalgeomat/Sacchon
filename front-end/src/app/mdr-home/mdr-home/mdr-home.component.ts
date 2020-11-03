import { Component, OnInit } from '@angular/core';
import { Consultation } from 'src/app/consultation';
import { ConsultationsService } from 'src/app/consultations.service';

@Component({
  selector: 'app-mdr-home',
  templateUrl: './mdr-home.component.html',
  styleUrls: ['./mdr-home.component.scss']
})
export class MdrHomeComponent implements OnInit {

  patientName:string;

  consults: Consultation[];

  constructor(private consultationsService: ConsultationsService) { }

  ngOnInit(): void {

    this.consultationsService.getConsultations().subscribe( result => this.consults = result );

    this.patientName = sessionStorage.getItem("luFirstName");


  }

  onClickCSubmit() {}

  onClickGSubmit() {}

}
