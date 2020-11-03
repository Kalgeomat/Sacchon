import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ReporterService } from 'src/app/reporter.service';

@Component({
  selector: 'app-period-form',
  templateUrl: './period-form.component.html',
  styleUrls: ['./period-form.component.scss']
})
export class PeriodFormComponent implements OnInit {

  periodForm: FormGroup;

  constructor(private reporterService:ReporterService) { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.periodForm = new FormGroup({
      pfrom: new FormControl("", Validators.required),
      pto: new FormControl("", Validators.required)
    });
  }

  onClickGo() {
    // this.reporterService.getAverageGlucose(s,e).subscribe( result => this.dreport = result );
  }

  // onClickCGo() {
  //   // this.reporterService.getAverageCarbs(s,e).subscribe( result => this.dreport = result );
  // }

}
