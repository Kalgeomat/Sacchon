import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Home, Medi } from 'src/app/Medi';


@Component({
  selector: 'codehub-mdr-home-page',
  templateUrl: './mdr-home-page.component.html',
  styleUrls: ['./mdr-home-page.component.scss']
})
export class MDRHomePageComponent implements OnInit {
  [x: string]: any;

  constructor() { }

  myForm: FormGroup;
  ngOnInit(): void {
    this.myForm = new FormGroup({
      blood_glycose_level: new FormControl("", Validators.required),
      date_blood_glycose_level: new FormControl("",Validators.required),
      time_blood_glycose_level: new FormControl("",Validators.required),
      submit_blood_glycose_level: new FormControl(),
      carb_intake_grams: new FormControl("", Validators.required),
      date_carb_intake_grams: new FormControl("",Validators.required),
      submit_carb_intake_grams: new FormControl(),
      your_last_consultation: new FormControl("",Validators.required),
    });
}

onClickSubmit_blood_glycose_level() {
  let medi:Home = {

    bloodGlucoseLevel:this.myForm.get('blood_glycose_level').value,
    creationTime:this.myForm.get('time_blood_glycose_level').value,
    dateMeasured:this.myForm.get('date_blood_glycose_level').value,
    
    
    };
    
}

onClickSubmit_carb_intake_grams() {
  let medi:Home ={

    carbInTake:this.myForm.get('carb_intake_grams').value,
    dateMeasured:this.myForm.get('date_carb_intake_grams').value,
    
    };

    this.carbService.addCarb(medi).subscribe(data => {
      alert(JSON.stringify(data));
      this.ngOnInit();
    });

}

}