import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Carb } from 'src/app/carb';
import { Consultation } from 'src/app/consultation';
import { ConsultationsService } from 'src/app/consultations.service';
import { ConsultationU } from 'src/app/consultationU';
import { Doctor } from 'src/app/doctor';
import { DoctorsService } from 'src/app/doctors.service';
import { Glucose } from 'src/app/glucose';
import { MeasurementsService } from 'src/app/measurements.service';
import { ReversePipe } from 'src/app/reverse.pipe';

@Component({
  selector: 'app-da-one-patient',
  templateUrl: './da-one-patient.component.html',
  styleUrls: ['./da-one-patient.component.scss']
})
export class DaOnePatientComponent implements OnInit { 

  carbs: Carb[];   
  glucoses: Glucose[];
  consults: Consultation[];
  enableEdit = false;
  enableEditIndex = null;
  doctor: Doctor;
  consultationForm: FormGroup;

  constructor(private doctorId: DoctorsService, private consultationsService: ConsultationsService, private measurements: MeasurementsService, private consultations: ConsultationsService, private router:Router) { }

  ngOnInit(): void {

    this.measurements.getCarbs().subscribe( result => this.carbs = result );
    this.measurements.getGlucose().subscribe( result => this.glucoses = result );

    this.consultations.getConsultations().subscribe( result => this.consults = result );

    // this.doctorId.getDoctorById().subscribe( result => this.doctor = result );

    this.consultationForm = new FormGroup({
      consultation: new FormControl()
    });

  }

  consult() {
    this.router.navigate(['doctoradvice/consultation']);
  }

  onEditClick(e, i) {
    this.enableEdit = true;
    this.enableEditIndex = i;
    console.log(i, e);
  }

  saveConsult(dc) {
    let consultation:ConsultationU ={
      description:this.consultationForm.get('consultation').value,
      dateCreated:dc 
    };

    this.consultationsService.updateConsultation(consultation).subscribe(data => {
      alert(JSON.stringify(data));
      this.ngOnInit();
    });

    this.enableEdit = false;

  }

  
}


