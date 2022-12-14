import { Component, OnInit } from '@angular/core';
import { UiService } from './services/ui.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

  toggleForm : boolean = true;
  constructor( private uiService: UiService) { }

  ngOnInit(): void {
    this.uiService.formChanged.subscribe(
      () => {
        this.toggleForm = !this.toggleForm
      }
    )
  }


}
