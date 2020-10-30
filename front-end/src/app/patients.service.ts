import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {

  endpoint = 'http://localhost:9000/SacchonApp/doctors/1/patients';
  endpoint2 = 'http://localhost:9000/SacchonApp/doctors/1/patients/need';

  constructor(private http: HttpClient) { }

  getDocPatients(): Observable<any> {
    return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getDocPatientsInNeed(): Observable<any> {
    return this.http.get(this.endpoint2,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  // getDoctors(): Observable<any> {
  //   return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  // }

  // addDoctor(values:Doctor):Observable<any> { 
  //   return this.http.post(this.endpoint,
  //   values,
  //   {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  // }
}
