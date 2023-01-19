import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JobsService {

  constructor(private http: HttpClient) { }

  getRecommandedJobs(applicantLocation : any) {
    return this.http.get<any>(`http://localhost:8090/getRandomJobs/${applicantLocation?applicantLocation:'zzzz'}`);
  }

  getJobsByLocationAndName(jobName :any,jobLocation:any){
    return this.http.get<any[]>(`http://localhost:8090/getFilteredJobs/${jobName}/${jobLocation}`);
  }

  addJobToFavourite(idUser : any,idJob : any){
    return this.http.post<any[]>(`http://localhost:8090/addFavorite/`,{idUser:idUser,idJob:idJob});
  }

  deleteJobToFavourite(idUser : any,idJob : any){
    return this.http.post<any[]>(`http://localhost:8090/deleteFavorite/`,{idUser:idUser,idJob:idJob});
  }

  getAllFavouriteJobs(idUser : any){
    return this.http.get<any>(`http://localhost:8090/getFavoriteJobs/${idUser}`);
  }
}
