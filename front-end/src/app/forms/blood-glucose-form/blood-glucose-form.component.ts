import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Glucose } from 'src/app/glucose';
import { GlucoseU } from 'src/app/glucoseU';
import { MeasurementsService } from 'src/app/measurements.service';

@Component({
  selector: 'app-blood-glucose-form',
  templateUrl: './blood-glucose-form.component.html',
  styleUrls: ['./blood-glucose-form.component.scss']
})
export class BloodGlucoseFormComponent implements OnInit {

  bloodGlucoseForm: FormGroup;

  constructor(private measurementsService: MeasurementsService) { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.bloodGlucoseForm = new FormGroup({
      bglevel: new FormControl("", Validators.required),
      bgdatetime: new FormControl("", Validators.required)
    });
  }

  onClickGSubmit() {
    let datetime=this.bloodGlucoseForm.get('bgdatetime').value;    
    let rightdatetime=new Date(datetime.replace(/-/g,'/').replace('T',' '));    

    let glucose:Glucose ={
      bloodGlucoseLevel:this.bloodGlucoseForm.get('bglevel').value,
      dateMeasured:rightdatetime.toISOString(),
      patientId:parseInt(sessionStorage.getItem("luId"))
    };

    this.measurementsService.addGlucose(glucose).subscribe(data => {
      // alert(JSON.stringify(data));
      this.ngOnInit();
    });

  }

}
