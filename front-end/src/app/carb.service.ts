import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Carb } from './carb';

@Injectable({
  providedIn: 'root'
})
export class CarbService {

  constructor(private http:HttpClient) { }

  endpoint = 'http://localhost:9000/SacchonApp/patients/id/measurements';


  addCarb(values:Carb):Observable<any> { 
    return this.http.post(this.endpoint,
    values,
    {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }
}
