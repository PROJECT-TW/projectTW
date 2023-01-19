import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/services/auth.service';
import { JobsService } from '../jobs/services/jobs.service';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.scss']
})
export class FavouriteComponent implements OnInit {

  favJobs: any[] = [];
  constructor(private jobsService: JobsService,private authService:AuthService) { }

  ngOnInit(): void {
    this.getFavouriteJobs();
  }

  getFavouriteJobs(){
    this.jobsService.getAllFavouriteJobs(this.authService.getUser().id).subscribe(
      res =>{
        this.favJobs = res;
      },
      err =>{
        console.log(err)
      }
    )
  }

}
