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
    return 'applicant'
  }

  getUser(){
    return this.user
  }

  signUpApplicant(signupForm : any) {
    return this.http.post<any>("http://localhost:8091/addSearcher",signupForm);
  }

  signUpRecruiter(signupForm : any) {
    return this.http.post<any>("http://localhost:8091/addRecruiter",signupForm);
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
