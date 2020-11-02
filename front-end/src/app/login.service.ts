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

  // let user = User;

  // authorization(values): string {
  //   //This is a dummy authentication
  //   if (true) {
  //     this.responseOfAuth.next(true);
  //     return "OK";
  //   }
  //   //Here you make the call to the API to authenticate the user
  //   //change the signature of method to Observable<any>
  //   /*
  //     this.params.append('username', values.get('login').value);
  //     this.params.append('password', values.get('password').value);
  //     return this.http.get<any>(this.baseUrl+'/auth',{ params:this.params});
  //   */
  // }

  authorization(values): Observable<any> {        

    this.params.append('username', values.get('username').value);
    this.params.append('password', values.get('password').value);
   
    this.responseOfAuth.next(true);
    return this.http.get(this.endpoint,{headers:new HttpHeaders({'Authorization': 'Basic ' + btoa(sessionStorage.getItem("checkcredentials"))})});


    // if (true) {
    //   this.responseOfAuth.next(true);
    //   return "OK";
    // }
    
      
    
  }

}
