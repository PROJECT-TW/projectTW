import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/services/auth.service';
import {cities} from '../../../assets/json/ro';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-account-applicant',
  templateUrl: './account-applicant.component.html',
  styleUrls: ['./account-applicant.component.scss']
})
export class AccountApplicantComponent implements OnInit {

  myCities : any = cities;
  usercopy : any; 
  ceva = "hello"
  constructor(private authService : AuthService, private accountService: AccountService) { }

  ngOnInit(): void {
    this.usercopy = JSON.parse(JSON.stringify(this.authService.getUser())) 
    console.log(this.usercopy);
  }

  saveAccountInfo(){
    this.accountService.saveAccountInformations(this.usercopy).subscribe(
      res =>{
      },
      err =>{
        console.log(err)
      }
    )
  }

}
