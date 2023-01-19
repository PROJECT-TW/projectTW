import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-job-page',
  templateUrl: './job-page.component.html',
  styleUrls: ['./job-page.component.scss']
})
export class JobPageComponent implements OnInit {
  @Input() selectedJob: any = {}
  @Input() selectedReq: any = []
  isFav: boolean = false;

  constructor() { }
  ngOnInit(): void {
  }

  addToFav() {
    this.isFav = !this.isFav
  }

  apply() {

  }

}
