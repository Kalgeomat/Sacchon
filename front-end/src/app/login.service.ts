import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  params = new HttpParams();

  responseOfAuth = new Subject<boolean>();

  readonly baseUrl = 'http://localhost:9000/SacchonApp';
  endpoint = 'http://localhost:9000/SacchonApp/login';

 
  authorization(values): Observable<any> {        

    this.params.append('username', values.get('username').value);
    this.params.append('password', values.get('password').value);
   
    this.responseOfAuth.next(true);
    return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("checkcredentials"))})});
    
  }

}
