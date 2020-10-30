import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';

@Injectable({
  providedIn: 'root'
})
export class HttpDoctorsService {
  endpoint = 'http://localhost:9000/SacchonApp/doctors/';
  // endpoint2 = 'http://localhost:9000/SacchonApp/doctors';;

  constructor(private http: HttpClient) {   }

  // getDoctors(): Observable<any> {
  //   return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  // }

  addDoctor(values:Doctor):Observable<any> { 
    return this.http.post(this.endpoint,
    values,
    {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }
}
