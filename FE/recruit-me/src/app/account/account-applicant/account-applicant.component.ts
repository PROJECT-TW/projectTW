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
  user : any; 
  constructor(private authService : AuthService, private accountService: AccountService) { }

  ngOnInit(): void {
    this.user = this.authService.getUser();
    console.log(this.user);
  }

  saveAccountInfo(form : any){
    const x = form.controls;
    const accountInfoForm = {
      firstName : x.firstName?.value,
      lastName : x.lastName?.value,
      location : x.location?.value,
      phone : x.phone?.value,
      ocupation : x.ocupation.value,
      id: this.user.id
    }
    console.log(accountInfoForm);
    this.accountService.saveAccountInformations(accountInfoForm).subscribe(
      res =>{
        console.log(res)
      },
      err =>{
        console.log(err)
      }
    )
  }

}
