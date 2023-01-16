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
  constructor(private authService: AuthService, private accountService: AccountService) { }

  ngOnInit(): void {
    this.usercopy = JSON.parse(JSON.stringify(this.authService.getUser()))
    console.log(this.usercopy);
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
    this.accountService.fileUpload(this.file).subscribe(
      (res: any) => {
        console.log(res)
/*         if (typeof (event) === 'object') {
          // Short link via api response
          this.shortLink = event.link;
          console.log(this.shortLink)
        } */
      },
      err => {
        console.log(err)
      }
    )
  }

}
