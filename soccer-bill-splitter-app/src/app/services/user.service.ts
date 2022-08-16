import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { observable, Observable } from 'rxjs';
import { ApiService } from '../config/apis';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  getUserNameList()
  {
    return Observable.create((observer:any)=>{

      this.http.get(ApiService.apiList['getUserNameList']).subscribe((item:any)=>{
        observer.next(item)
      },(error)=>{
        observer.next(error)
      },()=>{
        console.log('completed user service')
      })

    })
  }
}
