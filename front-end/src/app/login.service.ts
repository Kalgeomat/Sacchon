import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  params = new HttpParams();

  responseOfAuth = new Subject<boolean>();

  readonly baseUrl = 'http://localhost:9000/SacchonApp';

  authorization(values): string {
    //This is a dummy authentication
    if (true) {
      this.responseOfAuth.next(true);
      return "OK";
    }
    //Here you make the call to the API to authenticate the user
    //change the signature of method to Observable<any>
    /*
      this.params.append('username', values.get('login').value);
      this.params.append('password', values.get('password').value);
      return this.http.get<any>(this.baseUrl+'/auth',{ params:this.params});
    */
  }

}
