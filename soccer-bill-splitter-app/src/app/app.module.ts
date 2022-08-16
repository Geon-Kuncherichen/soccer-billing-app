import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgSelectModule } from '@ng-select/ng-select';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './layout/header/header.component';
import { LoginComponent } from './pages/login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { LandingComponent } from './pages/landing/landing.component';
import { ViewSlotComponent } from './pages/view-slot/view-slot.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CreateViewSlotComponent } from './pages/create-view-slot/create-view-slot.component';
import { CustomIntereptor } from './config/CustomInterceptor';
import { RegisterComponent } from './pages/register/register.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    LandingComponent,
    ViewSlotComponent,
    CreateViewSlotComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
    FontAwesomeModule,
    NgSelectModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CustomIntereptor,
      multi: true
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
