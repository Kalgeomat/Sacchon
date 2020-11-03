import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Carb } from './carb';
import { CarbU } from './carbU';
import { Glucose } from './glucose';
import { GlucoseU } from './glucoseU';

@Injectable({
  providedIn: 'root'
})
export class MeasurementsService {

  endpointc = 'http://localhost:9000/SacchonApp/patients/'+parseInt(sessionStorage.getItem("luId"))+'/carbs';
  endpointc1 = 'http://localhost:9000/SacchonApp/carbs/';
  endpointg = 'http://localhost:9000/SacchonApp/patients/'+parseInt(sessionStorage.getItem("luId"))+'/glucose';
  endpointg1 = 'http://localhost:9000/SacchonApp/glucose/';
  endpointga = 'http://localhost:9000/SacchonApp/patients/id/glucose/'; //start/end';
  endpointca = 'http://localhost:9000/SacchonApp/patients/id/carb/'; //start/end';
  endpointu = 'http://localhost:9000/SacchonApp/patients/';



  constructor(private http:HttpClient) { }
 

  getCarbs(): Observable<any> {
    return this.http.get(this.endpointc,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getGlucose(): Observable<any> {
    return this.http.get(this.endpointg,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getPatientCarb(id): Observable<any> {
    return this.http.get(this.endpointu+id+'/carbs',{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getPatientGlucose(id): Observable<any> {
    return this.http.get(this.endpointu+id+'/glucose',{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  addCarb(values:Carb):Observable<any> { 
    return this.http.post(this.endpointc,
    values,
    {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  addGlucose(values:Glucose):Observable<any> { 
    return this.http.post(this.endpointg,
    values,
    {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  updateCarb(values:CarbU, id):Observable<any> {
    console.log('this 2 '+id);
    return this.http.put(this.endpointc1+id,
      values,
      {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  updateGlucose(values:GlucoseU, id):Observable<any> {
    return this.http.put(this.endpointg1+id,
      values,
      {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  deleteCarb(id):Observable<any> {
    return this.http.delete(this.endpointc1+id,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  deleteGlucose(id):Observable<any> {
    return this.http.delete(this.endpointg1+id,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getAverageCarbs(s, e): Observable<any> {
    return this.http.get(this.endpointca+s+'/'+e,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getAverageGlucose(s, e): Observable<any> {
    return this.http.get(this.endpointga+s+'/'+e,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});    
  }

}
