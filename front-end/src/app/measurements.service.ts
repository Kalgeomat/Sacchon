import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Carb } from './carb';
import { Glucose } from './glucose';

@Injectable({
  providedIn: 'root'
})
export class MeasurementsService {

  endpointc = 'http://localhost:9000/SacchonApp/patients/1/carbs';
  endpointg = 'http://localhost:9000/SacchonApp/patients/1/glucose';

  constructor(private http:HttpClient) { }

  getCarbs(): Observable<any> {
    return this.http.get(this.endpointc,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }

  getGlucose(): Observable<any> {
    return this.http.get(this.endpointg,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
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
}
