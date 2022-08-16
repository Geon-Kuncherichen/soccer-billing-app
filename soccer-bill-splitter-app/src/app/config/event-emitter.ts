import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
export class LoginChange{

    public isLoggedIn:BehaviorSubject<Boolean> = new BehaviorSubject<Boolean>(false);

}