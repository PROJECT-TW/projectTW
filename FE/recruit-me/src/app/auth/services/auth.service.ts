import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';
import { TemplateBindingParseResult } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private user: any = null;
  constructor(private http: HttpClient,private router : Router) {
    this.tryLoginFromLocalstorge();
   }

  getLoginStatus(){
    return this.user?true:false
  }
  setUserData(data : any){
    this.user = data;
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
    return this.http.post<any>("http://localhost:8090/addUser",signupForm);
  }

  login(loginForm : any) {
    return this.http.post<any>("http://localhost:8090/login",loginForm).subscribe(
      res =>{
        this.user = res;
        if(!localStorage.getItem('user')){
          localStorage.setItem('user',JSON.stringify(this.user));
        }
        this.router.navigate(['']);
      },
      err =>{
        console.log(err)
      }
    );
  }

  tryLoginFromLocalstorge(){
    if(localStorage.getItem('user')){
      const localstorgeUser = JSON.parse(localStorage.getItem('user') || '{}')
      this.login({email:localstorgeUser.email,password:localstorgeUser.password});
    }
  }

  disconnect(){
    localStorage.removeItem('user')
    this.user = null;
    this.router.navigate(['/authentication'])
  }
}
