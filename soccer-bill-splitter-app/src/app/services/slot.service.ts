import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { observable, Observable } from 'rxjs';
import { ApiService } from '../config/apis';

@Injectable({
  providedIn: 'root'
})
export class SlotService {

  constructor(private http:HttpClient) { }

  addSlot(slotObj:any)
  {
    return Observable.create((observer:any)=>{
        this.http.post(ApiService.apiList['addSlot'],slotObj).subscribe((item:any)=>{
          observer.next(item)
        },(error:any) =>{
            observer.next(error)
        },()=>{
          console.log('add slot completed')
        })
    })
  }

  getSlotList()
  {
    return Observable.create((observer:any)=>{
      this.http.get(ApiService.apiList['getSlotList']).subscribe((item:any)=>{
        observer.next(item)
      },(error:any) =>{
          observer.next(error)
      },()=>{
        console.log(' getSlotList completed')
      })
  })
  }

  getSlot(params:any)
  {
    return Observable.create((observer:any)=>{
      this.http.get(ApiService.apiList['getSlot'],{params}).subscribe((item:any)=>{
        observer.next(item)
      },(error:any) =>{
          observer.next(error)
      },()=>{
        console.log(' getSlotList completed')
      })
  })
  }


}
