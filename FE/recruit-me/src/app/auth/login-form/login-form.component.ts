import { Component, OnInit } from '@angular/core';
import { UiService } from '../ui.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {

  constructor(private uiService : UiService) { }

  ngOnInit(): void {
  }

  onToggle(){
    this.uiService.toggleForm();
  }

}
