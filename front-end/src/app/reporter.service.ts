import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReporterService {

  endpointDA = 'http://localhost:9000/SacchonApp/doctors/id/activity/start/end';
  endpointPA = 'http://localhost:9000/SacchonApp/patients/id/activity/start/end';
  endpointID = 'http://localhost:9000/SacchonApp/doctors/noactive/start/end';
  endpointIP = 'http://localhost:9000/SacchonApp/patients/noactive/start/end';


  constructor(private http: HttpClient) { }


  getDoctorActivity(){
    return this.http.get(this.endpointDA,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getPatientActivity(){
    return this.http.get(this.endpointPA,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getInactiveDoctors(){
    return this.http.get(this.endpointID,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getInactivePatients(){
    return this.http.get(this.endpointIP,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }
}
