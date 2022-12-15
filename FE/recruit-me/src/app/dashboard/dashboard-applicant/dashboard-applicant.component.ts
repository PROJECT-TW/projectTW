import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/services/auth.service';

@Component({
  selector: 'app-dashboard-applicant',
  templateUrl: './dashboard-applicant.component.html',
  styleUrls: ['./dashboard-applicant.component.scss']
})
export class DashboardApplicantComponent implements OnInit {

  user : any
  constructor(private authService : AuthService) { }

  ngOnInit(): void {
    this.user = this.authService.getUser();
  }

}
