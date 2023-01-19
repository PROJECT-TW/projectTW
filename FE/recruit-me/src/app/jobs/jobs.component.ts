import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JobsService } from './services/jobs.service';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.scss']
})
export class JobsComponent implements OnInit {

  jobLocation = ''
  jobName = ''
  jobs :any[] = [];
  filteredJobs : any[] = [];
  selectedJob = {};
  selectedReq = [];
  filter = {
    type:'All',
    time:'All'
  }
  
  constructor(private jobsService : JobsService, private route: ActivatedRoute ) { }


  ngOnInit(): void {
    this.route.queryParams.subscribe( params =>{
      this.jobLocation = params['jobLocation'];
      this.jobName = params['jobName'];
      this.getRequestedJobs()
    })
  }

  selectJob(job : any){
    this.selectedJob = job;
    this.selectedReq = job.requirements?.split(','); 
  }

  getRequestedJobs(){
    this.jobsService.getJobsByLocationAndName(this.jobName,this.jobLocation).subscribe(
      res =>{
        this.jobs = res;
        this.filteredJobs = [...res];
        this.selectedJob = res.length > 0?res[0] : {};
        this.selectedReq = res.length > 0?res[0].requirements?.split(',') : [];
        console.log(this.jobs)
      },
      err =>{
        console.log(err)
      }
    )
  }
  
  calculateDifDays(jobDate : string) {
    const date1: any = new Date(jobDate);
    const date2: any = new Date();
    const diffTime = Math.abs(date2 - date1);
    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
    return diffDays;
  }

  filterJobs(){
    console.log(this.filter)
    this.filteredJobs = this.jobs.filter(el =>{
      return this.filterByType(el) && this.filterByTime(el);
    })
  }

  filterByType(el : any){
    if(this.filter.type === "All") return true;
    if(el.jobType === this.filter.type) return true;
    return false;
  }

  filterByTime(el : any){
    if(this.filter.time === "All") return true;
    if(this.filter.time === "Last 7 days") {
      if(this.calculateDifDays(el.postDate) <= 7) return true;
    }
    if(this.filter.time === "Last 1 months"){
      if(this.calculateDifDays(el.postDate) < 32) return true;
    }
    return false;
  }


}
