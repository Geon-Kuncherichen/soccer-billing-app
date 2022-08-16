import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SlotService } from 'src/app/services/slot.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  slotArray:any=[]
  constructor(private slotService:SlotService,private route:ActivatedRoute,private router:Router) { 
   
  }

  ngOnInit(): void {
    this.getSlotList()
  }

  getSlotList()
  {
    this.slotService.getSlotList().subscribe((item:any)=>{
      if(item)
      {
        this.slotArray=item
      }
    })
  }

  goToViewSlot(slotId:any)
  {
    this.router.navigate(['view-slot',window.btoa(slotId)])
  }

}
