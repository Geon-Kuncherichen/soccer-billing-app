import { Component, OnInit } from '@angular/core';
import { LoginChange } from 'src/app/config/event-emitter';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLogged:Boolean=false
  constructor(private loginChange:LoginChange,private loginService:LoginService) {
    // this.loginChange.isLoggedIn.subscribe((item)=>{
    //   this.isLogged=false
      
    // })
    if(localStorage.getItem('soccer-bill-token'))
              this.isLogged=true

   }

  ngOnInit(): void {
  }

  logOut()
  {
   // this.loginService.logout()
   localStorage.setItem('soccer-bill-token','')
    this.loginChange.isLoggedIn.next(false)
  }

}
