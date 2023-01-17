import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/services/auth.service';
import { cities } from '../../../assets/json/ro';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-account-applicant',
  templateUrl: './account-applicant.component.html',
  styleUrls: ['./account-applicant.component.scss']
})
export class AccountApplicantComponent implements OnInit {
  shortLink = ""
  myCities: any = cities;
  usercopy: any;
  file: any;
  cvName : string = "";
  constructor(private authService: AuthService, private accountService: AccountService) { }

  ngOnInit(): void {
    this.usercopy = JSON.parse(JSON.stringify(this.authService.getUser()))
    this.getCVName();
  }

  saveAccountInfo() {
    this.accountService.saveAccountInformations(this.usercopy).subscribe(
      res => {
        this.authService.setUserData(res);
      },
      err => {
        console.log(err)
      }
    )
  }

  onSelectFile(event: any) {
    this.file = event.target.files[0];
  }

  onUploadFile() {
    this.accountService.fileUpload(this.file,this.authService.getUser().id).subscribe(
      (res: any) => {
        console.log(res)
        this.getCVName()
      },
      err => {
        console.log(err)
      }
    )
  }
  onDownloadFile(){
    window.open('http://localhost:8090/downloadFile/27');
  }

  deleteCV(){
    this.accountService.deleteCV(this.authService.getUser().id).subscribe(
      res =>{
        console.log(res)
        this.getCVName();
      },
      err =>[
        console.log(err)
      ]
    )
  }

  getCVName(){
    this.accountService.getCVName(this.authService.getUser().id).subscribe(
      res =>{
        console.log(res)
        this.cvName = res !== null?res.name:'';
      },
      err =>{
        console.log(err);
      }
    )
  }

}
