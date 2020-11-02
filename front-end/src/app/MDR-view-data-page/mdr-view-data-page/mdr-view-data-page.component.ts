import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Medi, ViewData } from 'src/app/Medi';

@Component({
  selector: 'codehub-mdr-view-data-page',
  templateUrl: './mdr-view-data-page.component.html',
  styleUrls: ['./mdr-view-data-page.component.scss']
})
export class MDRViewDataPageComponent implements OnInit {

  constructor() { }

  myForm: FormGroup;
 
  ngOnInit(): void {

    this.myForm = new FormGroup({

      from_date: new FormControl(),
      to_date: new FormControl(),
      submit_go: new FormControl(),
      average_daily_glycose: new FormControl(),
      average_carb_intake_: new FormControl(),
      blood_level_glycose_inputs: new FormControl(),
      carb_intake_inputs: new FormControl(),
      
    });

  }

  onClickSubmit_go() {
    let medi:ViewData ={
  
      from_date:this.myForm.get('from_date').value,
      to_date:this.myForm.get('to_date').value,
      
      };
    }

  onClickSubmit_edit() {
    let medi:Medi ={
      

      };
    }

  onClickSubmit_delete() {
      let medi:Medi ={
        
        };
      
}
