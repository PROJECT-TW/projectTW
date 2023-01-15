import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private user: any = null;
  constructor(private http: HttpClient,private router : Router) { }

  getLoginStatus(){
    return this.user?true:false
  }
  getUserType(){
    //return 'recruiter';
   // return 'applicant'
    return this.user.type === false?'applicant':'recruiter'
  }

  getUser(){
    return this.user
  }

  signUpUser(signupForm : any) {
    return this.http.post<any>("http://localhost:8091/addUser",signupForm);
  }

  login(loginForm : any) {
    return this.http.post<any>("http://localhost:8091/login",loginForm).subscribe(
      res =>{
        this.user = res;
        this.router.navigate(['']);
      },
      err =>{
        console.log(err)
      }
    );
  }
}
