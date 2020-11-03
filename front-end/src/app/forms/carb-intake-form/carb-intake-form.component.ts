import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Carb } from 'src/app/carb';
import { MeasurementsService } from 'src/app/measurements.service';

@Component({
  selector: 'app-carb-intake-form',
  templateUrl: './carb-intake-form.component.html',
  styleUrls: ['./carb-intake-form.component.scss']
})
export class CarbIntakeFormComponent implements OnInit {

  carbIntakeForm: FormGroup;

  constructor(private measurementsService: MeasurementsService) { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.carbIntakeForm = new FormGroup({
      cilevel: new FormControl("", Validators.required),
      cidate: new FormControl("", Validators.required)
    });
  }

  onClickCSubmit() {
    let carb:Carb ={
      carbInTake:this.carbIntakeForm.get('cilevel').value,
      dateMeasured:this.carbIntakeForm.get('cidate').value,
      patientId:parseInt(sessionStorage.getItem("luId"))
    };

    this.measurementsService.addCarb(carb).subscribe(data => {
      alert(JSON.stringify(data));
      this.ngOnInit();
    });
    
  }

}
