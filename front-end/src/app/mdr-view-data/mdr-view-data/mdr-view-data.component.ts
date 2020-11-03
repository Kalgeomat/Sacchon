import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Carb } from 'src/app/carb';
import { CarbU } from 'src/app/carbU';
import { Consultation } from 'src/app/consultation';
import { ConsultationsService } from 'src/app/consultations.service';
import { Glucose } from 'src/app/glucose';
import { GlucoseU } from 'src/app/glucoseU';
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
  bloodGlucoseForm: FormGroup;
  selectedItem = null;

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

    this.bloodGlucoseForm = new FormGroup({
      bglevel: new FormControl(),
      bgdatetime: new FormControl()
    });

  }

  
  onEditClick(e, i) {
    
    this.enableEdit = true;
    this.enableEditIndex = i;
    // this.selectedItem = c.id;
    console.log(i, e);
  }

  onCarbDeleteClick(id) {
    this.measurements.deleteCarb(id).subscribe(data => {
      alert("Carb input removed!");
      this.ngOnInit();       
    });    
  }

  
  onGlucoseDeleteClick(id) {
    this.measurements.deleteGlucose(id).subscribe(data => {
      alert("Blood Glucose input removed!");
      this.ngOnInit();       
    });
  }

  saveCarb(id) {
    let carb:CarbU ={
      carbInTake:this.carbIntakeForm.get('cilevel').value,
      dateMeasured:this.carbIntakeForm.get('cidate').value
    };

    this.measurements.updateCarb(carb, id).subscribe(data => {
      // alert(JSON.stringify(data));
      this.ngOnInit();
    });

    this.enableEdit = false;

  }

  saveGlucose(id) {
    let datetime=this.bloodGlucoseForm.get('bgdatetime').value;    
    let rightdatetime=new Date(datetime.replace(/-/g,'/').replace('T',' '));    

    let glucose:GlucoseU ={
      bloodGlucoseLevel:this.bloodGlucoseForm.get('bglevel').value,
      dateMeasured:rightdatetime.toISOString()
    };

    this.measurements.updateGlucose(glucose, id).subscribe(data => {
      // alert(JSON.stringify(data));
      this.ngOnInit();
    });

    this.enableEdit = false;

  }


}
