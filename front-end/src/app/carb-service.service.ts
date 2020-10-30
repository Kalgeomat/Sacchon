import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarbServiceService {

  constructor(private http:HttpClient) { }

  endpoint = 'http://localhost:9000/SacchonApp/doctors/';

  // getDoctors(): Observable<any> {
  //   return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  // }

  addCarb(values:Carb):Observable<any> { 
    return this.http.post(this.endpoint,
    values,
    {headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("credentials"))})});
  }
}
