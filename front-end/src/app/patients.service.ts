import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {

  endpoint = 'http://localhost:9000/SacchonApp/doctors/1/patients';
  endpoint2 = 'http://localhost:9000/SacchonApp/doctors/1/patients/need';
  endpoint3 = 'http://localhost:9000/SacchonApp/patients/3';
  endpoint4 = 'http://localhost:9000/SacchonApp/patients';
  endpoint5 = 'http://localhost:9000/SacchonApp/patients/new';

  constructor(private http: HttpClient) { }

  getDocPatients(): Observable<any> {
    return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getDocPatientsInNeed(): Observable<any> {
    return this.http.get(this.endpoint2,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  addPatient(values:Patient): Observable<any> { 
    return this.http.post(this.endpoint4,values);
  }

  deletePatient(): Observable<any> {
    return this.http.delete(this.endpoint3,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getNewPatientsInNeed(): Observable<any> {
    return this.http.get(this.endpoint5,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

}
