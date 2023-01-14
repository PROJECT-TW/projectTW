import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { UiService } from '../services/ui.service';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.scss']
})
export class SignupFormComponent implements OnInit {
  constructor(private uiService : UiService,private authService : AuthService) { }

  ngOnInit(): void {
  }

  onToggle(){
    this.uiService.toggleForm();
  }

  signUp(form : any){
    const x = form.controls;
    const signUpForm = {
      firstName : x.firstName.value,
      lastName : x.lastName.value,
      organization : x.organization.value,
      email : x.email.value,
      password : x.password.value,
      password2 : x.password2.value,
      recruiter: x.recruiter.value?true:false
    }
    
    if(x.recruiter === true)
    this.authService.signUpRecruiter(signUpForm).subscribe(
      res =>{
        console.log(res)
      }
    )
    else
    this.authService.signUpApplicant(signUpForm).subscribe(
      res =>{
        console.log(res)
        this.authService.login({email:res.email,password:res.password})
      }
    )
    
  }

}
