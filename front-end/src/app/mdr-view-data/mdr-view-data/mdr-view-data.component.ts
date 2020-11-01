import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Carb } from 'src/app/carb';
import { CarbU } from 'src/app/carbU';
import { Consultation } from 'src/app/consultation';
import { ConsultationsService } from 'src/app/consultations.service';
import { Glucose } from 'src/app/glucose';
import { MeasurementsService } from 'src/app/measurements.service';

@Component({
  selector: 'app-mdr-view-data',
  templateUrl: './mdr-view-data.component.html',
  styleUrls: ['./mdr-view-data.component.scss']
})
export class MdrViewDataComponent implements OnInit {

  carbs: Carb[];   
  glucoses: Glucose[];
  consults: Consultation[];
  enableEdit = false;
  enableEditIndex = null;
  // consultationForm: FormGroup;
  carbIntakeForm: FormGroup;

  constructor(private consultationsService: ConsultationsService, private measurements: MeasurementsService, private router:Router) { }

  

  ngOnInit(): void {

    this.measurements.getCarbs().subscribe( result => this.carbs = result );
    this.measurements.getGlucose().subscribe( result => this.glucoses = result );

    this.consultationsService.getConsultations().subscribe( result => this.consults = result );

    // this.consultationForm = new FormGroup({
    //   consultation: new FormControl()
    // });

    this.carbIntakeForm = new FormGroup({
      cilevel: new FormControl(),
      cidate: new FormControl()
    });

  }

  
  onEditClick(e, i) {
    this.enableEdit = true;
    this.enableEditIndex = i;
    console.log(i, e);
  }

  onDeleteClick(e, i) {
    console.log(i, e);

    this.measurements.deleteCarb().subscribe(data => {
      alert("Carb input Removed!");
      this.ngOnInit();       
    });
  }

  saveCarb() {


    let carb:CarbU ={
      carbInTake:this.carbIntakeForm.get('cilevel').value,
      dateMeasured:this.carbIntakeForm.get('cidate').value
    };

    this.measurements.updateCarb(carb).subscribe(data => {
      alert(JSON.stringify(data));
      this.ngOnInit();
    });

    this.enableEdit = false;

  }

  saveGlucose() {

  }

  // saveConsult(dc) {
  //   let consultation:ConsultationU ={
  //     description:this.consultationForm.get('consultation').value,
  //     dateCreated:dc 
  //   };

  //   this.consultationsService.updateConsultation(consultation).subscribe(data => {
  //     alert(JSON.stringify(data));
  //     this.ngOnInit();
  //   });

  //   this.enableEdit = false;

  // }

}
