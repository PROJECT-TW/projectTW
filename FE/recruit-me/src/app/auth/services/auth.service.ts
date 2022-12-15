import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private user: any = null;
  constructor(private http: HttpClient) { }

  getLoginStatus(){
    return this.user?true:false
  }

  signUpSearcher(signupForm : any) {
    return this.http.post<any>("http://localhost:8090/addSearcher",signupForm);
  }

  signUpRecruiter(signupForm : any) {
    return this.http.post<any>("http://localhost:8090/addRecruiter",signupForm);
  }

  login(loginForm : any) {
    return this.http.post<any>("http://localhost:8090/login",loginForm).subscribe(
      res =>{
        console.log(res);
        this.user = res;
      },
      err =>{
        console.log(err)
      }
    );
  }
}
