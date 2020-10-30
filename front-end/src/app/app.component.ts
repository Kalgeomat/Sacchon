import { Component, OnInit } from '@angular/core';
import { HttpDoctorsService } from './http-doctors.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'sacchon-fe';

  username: string
  password: string


  constructor(private httpDoctors: HttpDoctorsService) {}

  ngOnInit(): void {

    this.username = 'john';
    this.password = 'john';
      sessionStorage.setItem("credentials", this.username + ":" + this.password)
      // this.router.navigate(['view'])

    this.httpDoctors.getDoctors().subscribe((data) => {
      console.log(data);      
    });
    
   
  }



}
