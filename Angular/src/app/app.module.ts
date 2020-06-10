import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { AddTestComponent } from './add-test/add-test.component';
import { GetAllCenterComponent } from './get-all-center/get-all-center.component';
import { GetAllTestComponent } from './get-all-test/get-all-test.component';
import { ModifyCenterComponent } from './modify-center/modify-center.component';
import { ModifyTestComponent } from './modify-test/modify-test.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { GetAllAppointmentComponent } from './get-all-appointment/get-all-appointment.component';
import { FilterCentersPipe } from './filter-centers.pipe';
import { FilterTestsPipe } from './filter-tests.pipe';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    AboutComponent,
    AddCenterComponent,
    AddTestComponent,
    GetAllCenterComponent,
    GetAllTestComponent,
    ModifyCenterComponent,
    ModifyTestComponent,
    PageNotFoundComponent,
    GetAllAppointmentComponent,
    FilterCentersPipe,
    FilterTestsPipe,
    ApproveAppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
