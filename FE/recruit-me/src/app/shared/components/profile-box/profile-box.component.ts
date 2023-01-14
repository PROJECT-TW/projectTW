import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile-box',
  templateUrl: './profile-box.component.html',
  styleUrls: ['./profile-box.component.scss']
})
export class ProfileBoxComponent implements OnInit {

  @Input() user : any = {};
  constructor() { }

  ngOnInit(): void {
  }

}
