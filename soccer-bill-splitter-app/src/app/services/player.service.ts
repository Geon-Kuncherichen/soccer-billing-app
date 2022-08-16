import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiService } from '../config/apis';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http:HttpClient) { }

  addPlayer(playerObj:any)
  {
    return Observable.create((observer:any)=>{
      this.http.post(ApiService.apiList['login'],playerObj).subscribe((item:any)=>{
        observer.next(item)
      },(error:any)=>{
        observer.next(error)
      },()=>{
        console.log('completed')
      })
    })
    
  }


}
