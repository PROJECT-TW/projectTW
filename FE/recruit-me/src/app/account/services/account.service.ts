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

  fileUpload(file : File,userId : any){
    console.log(userId)
    const formData = new FormData(); 
    formData.append("file",file,file.name)
    console.log(file)
   // return this.http.post<File>("https://file.io",formData)
   return this.http.post<File>("http://localhost:8090/uploadFile/" + userId,formData)
  }

  downloadFile(userId : any){
    return this.http.get<any>("http://localhost:8090/downloadFile/" + userId);
  }

  getCVName(userId : any){
    return this.http.get<any>("http://localhost:8090/getFileName/" + userId);
  }

  deleteCV(userId : any){
    return this.http.get<any>("http://localhost:8090/deleteFile/" + userId);
  }

}
