import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/services/auth.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  userType : any
  constructor(private authService : AuthService) { }

  ngOnInit(): void {
    this.userType = this.authService.getUserType();
    console.log(this.userType)
  }

}
