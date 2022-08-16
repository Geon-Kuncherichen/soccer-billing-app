import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiService } from '../config/apis';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }


  register(loginObj:any)
  {
    return Observable.create((observer:any)=>{

      this.http.post(ApiService.apiList['register'],loginObj).subscribe((item)=>{
        observer.next(item)
      },(error)=>{
        observer.next(error)
      },()=>{
        observer.complete()
      })

    })
  }

  login(loginObj:any)
  {
    return Observable.create((observer:any)=>{

      this.http.post(ApiService.apiList['login'],loginObj).subscribe((item)=>{
        observer.next(item)
      },(error)=>{
        observer.next(error)
      },()=>{
        observer.complete()
      })

    })
  }

  logout(loginObj:any)
  {
    return Observable.create((observer:any)=>{

      this.http.post(ApiService.apiList['login'],loginObj).subscribe((item)=>{
        observer.next(item)
      },(error)=>{
        observer.next(error)
      },()=>{
        observer.complete()
      })

    })
  }



}
