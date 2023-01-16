import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/services/auth.service';
import { JobsService } from 'src/app/jobs/services/jobs.service';

@Component({
  selector: 'app-dashboard-applicant',
  templateUrl: './dashboard-applicant.component.html',
  styleUrls: ['./dashboard-applicant.component.scss']
})
export class DashboardApplicantComponent implements OnInit {

  user : any = {}
  jobs : any[] = []
  constructor(private authService : AuthService, private jobsService : JobsService) { }

  ngOnInit(): void {
    this.user = this.authService.getUser();
    this.jobsService.getRecommandedJobs(this.user.location).subscribe(
      res =>{
        this.jobs = res;
        console.log(res)
      },
      err =>{
        console.log(err);
      }
    )
  }

}
