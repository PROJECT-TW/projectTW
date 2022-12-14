import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UiService } from '../ui.service';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.scss']
})
export class SignupFormComponent implements OnInit {
  constructor(private uiService : UiService) { }

  ngOnInit(): void {
  }

  onToggle(){
    this.uiService.toggleForm();
  }

  signUp(form : any){
    console.log(form)
  }

}
