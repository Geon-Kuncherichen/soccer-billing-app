import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import{AppComponent} from '../app/app.component'
import { LandingComponent } from './pages/landing/landing.component';
import { ViewSlotComponent } from './pages/view-slot/view-slot.component';
import { CreateViewSlotComponent } from './pages/create-view-slot/create-view-slot.component';
import { RegisterComponent } from './pages/register/register.component';
const routes: Routes = [
  // {
  //   path:'',component:AppComponent
  // },
  {
    path:'login',component:LoginComponent
  },
  {
    path:'register',component:RegisterComponent
  },
  {
    path:'landing',component :LandingComponent
  },
  {
    path:'view-slot/:slotId',component :ViewSlotComponent
  },
  {
    path:'create-view-slot',component :CreateViewSlotComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
