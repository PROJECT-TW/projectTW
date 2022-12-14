import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { UiService } from '../services/ui.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {

  constructor(private uiService : UiService, private authService : AuthService) { }

  ngOnInit(): void {
  }

  onToggle(){
    this.uiService.toggleForm();
  }

  login(form : any){
    const loginForm = {
      email : form.controls.email.value,
      password : form.controls.password.value,
    }
    console.log(loginForm)
    //
    this.authService.login(loginForm)
  }

}
