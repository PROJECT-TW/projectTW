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
import { HttpClientModule } from '@angular/common/http';
import { ProfileBoxComponent } from './shared/components/profile-box/profile-box.component';
import { AccountComponent } from './account/account.component';
import { AccountRecruiterComponent } from './account/account-recruiter/account-recruiter.component';
import { AccountApplicantComponent } from './account/account-applicant/account-applicant.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { JobOfferComponent } from './shared/components/job-offer/job-offer.component';

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
    SignupFormComponent,
    ProfileBoxComponent,
    AccountComponent,
    AccountRecruiterComponent,
    AccountApplicantComponent,
    JobOfferComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
