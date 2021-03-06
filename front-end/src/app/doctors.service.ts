import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorsService {
  endpoint = 'http://localhost:9000/SacchonApp/doctors/';
  endpoint2 = 'http://localhost:9000/SacchonApp/doctors/'+parseInt(sessionStorage.getItem("luId"));

  constructor(private http: HttpClient) {   }

  getDoctors(): Observable<any> {
    return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getDoctorById(): Observable<any> {
    return this.http.get(this.endpoint2,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  addDoctor(values:Doctor):Observable<any> { 
    return this.http.post(this.endpoint,
    values,
    {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  deleteDoctor():Observable<any> {
    return this.http.delete(this.endpoint2,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  
}
