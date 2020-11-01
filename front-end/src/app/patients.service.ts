import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {

  endpoint = 'http://localhost:9000/SacchonApp/doctors/1/patients';
  endpoint2 = 'http://localhost:9000/SacchonApp/doctors/1/patients/need';
  endpoint3 = 'http://localhost:9000/SacchonApp/patients/3';

  constructor(private http: HttpClient) { }

  getDocPatients(): Observable<any> {
    return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getDocPatientsInNeed(): Observable<any> {
    return this.http.get(this.endpoint2,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  deletePatient():Observable<any> {
    return this.http.delete(this.endpoint3,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }
}
