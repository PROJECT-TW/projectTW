import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-job-box',
  templateUrl: './job-box.component.html',
  styleUrls: ['./job-box.component.scss']
})
export class JobBoxComponent implements OnInit {
  @Input() jobPreview : any = {};
  isFav : boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  addToFav(){
    console.log('http sent');
    this.isFav = !this.isFav
  }

}
