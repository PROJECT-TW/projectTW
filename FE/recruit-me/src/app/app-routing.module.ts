import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './account/account.component';
import { AuthComponent } from './auth/auth.component';
import { AuthGuardService } from './auth/services/auth-guard.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { JobsComponent } from './jobs/jobs.component';
import { MainComponent } from './main/main.component';

const routes: Routes = [
  { path: 'authentication', component: AuthComponent },
  { path: '',canActivate:[AuthGuardService], component: MainComponent,children:[
      { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
      { path: 'dashboard', component: DashboardComponent },
      { path: 'jobs', component: JobsComponent },
      { path: 'account', component: AccountComponent },
      { path: 'favourite', component: FavouriteComponent },
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
