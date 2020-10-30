import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    // this.form = new FormGroup({
    //   login: new FormControl(),
    //   password: new FormControl()
    // })
  }

}
