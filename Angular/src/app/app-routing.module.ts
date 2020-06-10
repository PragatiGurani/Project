import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AddTestComponent } from './add-test/add-test.component';
import { GetAllTestComponent } from './get-all-test/get-all-test.component';
import { ModifyTestComponent } from './modify-test/modify-test.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { GetAllCenterComponent } from './get-all-center/get-all-center.component';
import { ModifyCenterComponent } from './modify-center/modify-center.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { GetAllAppointmentComponent } from './get-all-appointment/get-all-appointment.component';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'about', component: AboutComponent },
  {path: 'header', component: HeaderComponent },
  {path: 'footer', component: FooterComponent },
  {path: 'add-test', component: AddTestComponent},
  {path: 'get-all-test', component: GetAllTestComponent},
  {path: 'modify-test/:testId', component: ModifyTestComponent},
  {path: 'add-center', component: AddCenterComponent},
  {path: 'get-all-center', component: GetAllCenterComponent},
  {path: 'modify-center/:centerId', component: ModifyCenterComponent},
  {path: 'get-all-appointment', component: GetAllAppointmentComponent},
  {path: 'approve-appointment/:appointmentId', component: ApproveAppointmentComponent},
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
