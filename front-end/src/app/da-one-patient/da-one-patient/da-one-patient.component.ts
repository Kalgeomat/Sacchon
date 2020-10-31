import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Carb } from 'src/app/carb';
import { Consultation } from 'src/app/consultation';
import { ConsultationsService } from 'src/app/consultations.service';
import { Glucose } from 'src/app/glucose';
import { MeasurementsService } from 'src/app/measurements.service';

@Component({
  selector: 'app-da-one-patient',
  templateUrl: './da-one-patient.component.html',
  styleUrls: ['./da-one-patient.component.scss']
})
export class DaOnePatientComponent implements OnInit {

  carbs: Carb[];   
  glucoses: Glucose[];
  consults: Consultation[];

  constructor(private measurements: MeasurementsService, private consultations: ConsultationsService, private router:Router) { }

  ngOnInit(): void {

    this.measurements.getCarbs().subscribe( result => this.carbs = result );
    this.measurements.getGlucose().subscribe( result => this.glucoses = result );

    this.consultations.getConsultations().subscribe( result => this.consults = result );

  }

  consult() {
    this.router.navigate(['doctoradvice/consultation']);
  }

}
