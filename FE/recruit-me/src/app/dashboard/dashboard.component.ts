import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  userType : any
  constructor(private authService : AuthService) { }

  ngOnInit(): void {
    this.userType = this.authService.getUserType();
    console.log(this.userType)
  }
}
