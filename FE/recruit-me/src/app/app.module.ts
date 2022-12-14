import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavbarComponent } from './main/navbar/navbar.component';
import { JobsComponent } from './jobs/jobs.component';
import { DashboardRecruiterComponent } from './dashboard/dashboard-recruiter/dashboard-recruiter.component';
import { DashboardApplicantComponent } from './dashboard/dashboard-applicant/dashboard-applicant.component';
import { JobBoxComponent } from './shared/components/job-box/job-box.component';
import { AuthComponent } from './auth/auth.component';
import { LoginFormComponent } from './auth/login-form/login-form.component';
import { SignupFormComponent } from './auth/signup-form/signup-form.component';

import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    DashboardComponent,
    NavbarComponent,
    JobsComponent,
    DashboardRecruiterComponent,
    DashboardApplicantComponent,
    JobBoxComponent,
    AuthComponent,
    LoginFormComponent,
    SignupFormComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
