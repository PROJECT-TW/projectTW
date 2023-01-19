import { Component, Input, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/services/auth.service';
import { JobsService } from 'src/app/jobs/services/jobs.service';

@Component({
  selector: 'app-job-box',
  templateUrl: './job-box.component.html',
  styleUrls: ['./job-box.component.scss']
})
export class JobBoxComponent implements OnInit {
  @Input() job : any = {};
  isFav : boolean = false;
  constructor(private jobService : JobsService, private authService : AuthService) { }

  ngOnInit(): void {
  }

  addToFav(){
    this.isFav = !this.isFav
    if(this.isFav){
     this.jobService.addJobToFavourite(this.authService.getUser().id,this.job.id).subscribe(
      res =>{
        console.log(res)
      },
      err =>{
        console.log(err)
      }
     )
    }
    else{
/*       this.jobService.deleteJobToFavourite(this.authService.getUser().id,this.job.id).subscribe(
        res =>{
          console.log(res)
        },
        err =>{
          console.log(err)
        }
      ) */
    }
  }

}
