import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {faTrashAlt} from "@fortawesome/free-solid-svg-icons"
import {faDownload} from "@fortawesome/free-solid-svg-icons"
import { ToastrService } from 'ngx-toastr';
import { Player } from 'src/app/models/player';
import { PlayerService } from 'src/app/services/player.service';
import { SlotService } from 'src/app/services/slot.service';

@Component({
  selector: 'app-view-slot',
  templateUrl: './view-slot.component.html',
  styleUrls: ['./view-slot.component.css']
})
export class ViewSlotComponent implements OnInit {



  todos:any=[7]
  faTrash=faTrashAlt;
  faDownload=faDownload

  playerObj:Player=new Player()
  turfArray:any=[{code:1,display:'Old Trafford'},{code:2,display:'freekick'}]
  timeArray:any=[{code:1,display:'AM'},{code:2,display:'PM'}]

  slotObj:any={}

  constructor(private toastrService:ToastrService,private playerService:PlayerService,private route:ActivatedRoute,
    private slotService:SlotService) {
    let slotId = this.route.snapshot.paramMap.get('slotId')
    if(slotId)
    {
      this.getSlot(window.atob(slotId))
    }
         
    
   }

  ngOnInit(): void {
    
  }

  getSlot(slotId:any)
  {
      this.slotObj={}
      this.slotService.getSlot({'slotId':slotId}).subscribe((item:any)=>{
          if(item)
          {
            this.slotObj=item
          }
      })
  }


  addPlayer2()
  {
    if(!this.playerObj.playerName)
    {
      this.toastrService.error('Please add valid name')
      return
    }

    this.playerService.addPlayer(this.playerObj).subscribe((item:any)=>{
        if(item.status.toLowerCase()=='success')
        {
          this.toastrService.success(item.message)
        }else{
          this.toastrService.error(item.message)
        }
    },
    (error:any)=>{
      this.toastrService.error('something not right')
      console.log(error)
    })
  }

}
