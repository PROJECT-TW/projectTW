import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JobsService {

  constructor(private http: HttpClient) { }

  getRecommandedJobs(applicantLocation : any) {
    return this.http.get<any>(`http://localhost:8090/getRandomJobs/${applicantLocation}`);
  }
}
