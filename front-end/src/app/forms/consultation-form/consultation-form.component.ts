import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Consultation } from 'src/app/consultation';
import { ConsultationsService } from 'src/app/consultations.service';

@Component({
  selector: 'app-consultation-form',
  templateUrl: './consultation-form.component.html',
  styleUrls: ['./consultation-form.component.scss']
})
export class ConsultationFormComponent implements OnInit {

  consultationForm: FormGroup;

  constructor(private router:Router, private route:ActivatedRoute, private consultationsService: ConsultationsService) { }
  
  ngOnInit(): void {
    //form instatiation, configuration, pedia formas
    this.consultationForm = new FormGroup({
      consultation: new FormControl("", Validators.required)
    });
  }

  onClickSubmit() {
    let myDate = new Date().getTime().toString(); 

    let consultation:Consultation ={
      description:this.consultationForm.get('consultation').value,
      dateCreated:myDate,
      doctorId:parseInt((sessionStorage.getItem("luId")))
    };

    this.route.params.subscribe( params => { this.router.navigate(['doctoradvice/consultation',params.id]);
      this.consultationsService.addConsultation(consultation, params.id).subscribe(data => {
        // alert(JSON.stringify(data));
        this.ngOnInit();
        this.router.navigate(['doctoradvice/patient/', params.id]);
      });
    });
    

  }

  

}
