import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Consultation } from './consultation';
import { ConsultationU } from './consultationU';

@Injectable({
  providedIn: 'root'
})
export class ConsultationsService {

  //MDR
  endpoint = 'http://localhost:9000/SacchonApp/patients/'+parseInt(sessionStorage.getItem("luId"))+'/consultations/';
  endpoint4 = 'http://localhost:9000/SacchonApp/patients/';//++'/consultations/';
  

  //DA
  endpoint3= 'http://localhost:9000/SacchonApp/patients/'+parseInt(sessionStorage.getItem("luId"))+'/consultations/';
  endpoint2 = 'http://localhost:9000/SacchonApp/consultations/2';


  constructor(private http:HttpClient) { }

  getConsultations(): Observable<any> {
    return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getUserConsultations(id): Observable<any> {
    return this.http.get(this.endpoint3+id+'/consultations/',{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  addConsultation(values:Consultation, id):Observable<any> {
    return this.http.post(this.endpoint4+id+'/consultations/',
      values,
      {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  updateConsultation(values:ConsultationU):Observable<any> {
    return this.http.put(this.endpoint2,
      values,
      {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

}
