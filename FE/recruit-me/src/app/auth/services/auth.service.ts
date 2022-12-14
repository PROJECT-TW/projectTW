import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  getLoginStatus(){
    return true;
  }

  signUp(signupForm : any) {
    return this.http.post<any>("http://localhost:8090/users",signupForm);
  }
  login(loginForm : any) {
    return this.http.post<any>("http://localhost:8090/users",loginForm);
  }
}
