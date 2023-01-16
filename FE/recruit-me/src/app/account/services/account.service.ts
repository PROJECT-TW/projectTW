import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  constructor(private http: HttpClient) { }

  saveAccountInformations(accountInfoForm : any) {
    return this.http.put<any>("http://localhost:8090/updateProfile",accountInfoForm);
  }
}
