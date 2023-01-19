import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  jobName : string = ''
  jobLocation : string = 'Cluj'
  constructor(private router : Router) { }

  ngOnInit(): void {

    
  }

  goToJobsPage(){
    this.router.navigate(['/jobs'],{queryParams: {jobName: this.jobName,jobLocation:this.jobLocation}});
  }

}
