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

  fileUpload(file : File){
    const formData = new FormData(); 
    formData.append("file",file,file.name)
    console.log(file)
   // return this.http.post<File>("https://file.io",formData)
   return this.http.post<File>("http://localhost:8090/uploadCV",formData)
  }
}
