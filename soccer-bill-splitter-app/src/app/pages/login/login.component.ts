import { Component, OnInit } from '@angular/core';
import { Login } from 'src/app/models/login';
import { LoginService } from 'src/app/services/login.service';
import { ToastrService } from 'ngx-toastr';
import { Router, ActivatedRoute } from '@angular/router'; 
import { LoginChange } from 'src/app/config/event-emitter';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginObj:Login=new Login()
  constructor(private loginService:LoginService,private toastrService:ToastrService,private route:Router,
    private loginChange:LoginChange) { }

  ngOnInit(): void {
  }

  login()
  {
      this.loginService.login(this.loginObj).subscribe((item:any)=>{
          if(item.status.toLowerCase()==='success')
          {
            localStorage.setItem('soccer-bill-token',item.details['token'])
            this.loginChange.isLoggedIn.next(true)
            this.toastrService.success(item.message)
            this.route.navigate(['landing'])
          }else{
            this.toastrService.error(item.message)
          }
      },(error:any)=>{
        console.log(error)
      })

  }

}
