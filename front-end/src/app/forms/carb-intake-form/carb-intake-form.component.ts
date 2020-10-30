import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-carb-intake-form',
  templateUrl: './carb-intake-form.component.html',
  styleUrls: ['./carb-intake-form.component.scss']
})
export class CarbIntakeFormComponent implements OnInit {

  carbIntakeForm: FormGroup;

  constructor() { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.carbIntakeForm = new FormGroup({
      cilevel: new FormControl("", Validators.required),
      cidate: new FormControl("", Validators.required)
    });
  }

  onClickSubmit() {
    let carb:Carb ={
      carbInTake:this.carbIntakeForm.get('cilevel').value,
      dateMeasured:this.carbIntakeForm.get('cidate').value,
      patient_id:1
    };

    this.carbService.addCarb(carb).subscribe(data => {
      alert(JSON.stringify(data));
      this.ngOnInit();
    });
    
  }

}
