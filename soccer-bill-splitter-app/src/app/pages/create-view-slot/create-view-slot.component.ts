import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {faTrashAlt} from "@fortawesome/free-solid-svg-icons"
import {faDownload} from "@fortawesome/free-solid-svg-icons"
import { ToastrService } from 'ngx-toastr';
import { Player } from 'src/app/models/player';
import { Slot } from 'src/app/models/slot';
import { PlayerService } from 'src/app/services/player.service';
import { SlotService } from 'src/app/services/slot.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-view-slot',
  templateUrl: './create-view-slot.component.html',
  styleUrls: ['./create-view-slot.component.css']
})
export class CreateViewSlotComponent implements OnInit {

  todos:any=[]
  faTrash=faTrashAlt;
  faDownload=faDownload

  playerObj:Player=new Player()
  turfArray:any=[{code:1,display:'Old Trafford'},{code:2,display:'freekick'}]
  timeArray:any=[{code:1,display:'AM'},{code:2,display:'PM'}]

  startTime:any
  endTime:any
  startTimeIsDay:any
  endTimeIsDay:any
  userNameList:any=[]
  playerList:any=[]

  slotObj:Slot=new Slot()
  constructor(private toastrService:ToastrService,private playerService:PlayerService,private userService:UserService,
    private slotService:SlotService,private route:Router) { }

  ngOnInit(): void {
    this.getUserNameList()
  }

  getUserNameList()
  {
    this.userNameList=[]
    this.userService.getUserNameList().subscribe((item:any)=>{
      if(item)
          this.userNameList=item
    },(error:any)=>{
      console.log('something wrong ',error)
    })
  }

  addSlot()
  {
    if(!this.slotObj.totalAmount)
    {
      this.toastrService.error('Please enter Total amount') 
      return;
    }


    if(!this.startTime)
    {
      this.toastrService.error('Please enter start time') 
      return;
    }
       
    if(!this.endTime)
    {
      this.toastrService.error('Please enter end time') 
      return;
    }
    if(!this.startTimeIsDay)
    {
      this.toastrService.error('Please choose AM/PM for start time') 
      return;
    }
    if(!this.endTimeIsDay)
    {
      this.toastrService.error('Please choose AM/PM for end time') 
      return;
    }

    this.slotObj.time=this.startTime+this.startTimeIsDay+" to "+this.endTime+this.endTimeIsDay

    if(!this.slotObj.turfName)
    {
      this.toastrService.error('Please choose turf from dropdown') 
      return;
    }

    if(!this.slotObj.payeeId)
    {
      this.toastrService.error('Please choose Payee name from dropdown') 
      return;
    }

    if(this.playerList?.length<=0)
    {
      this.toastrService.error('Please add players') 
      return;
    }

    this.slotObj.playerList=this.playerList
    console.log(this.playerList)
    console.log(this.slotObj)
    this.slotObj.totalAmount=Number(this.slotObj.totalAmount)
    this.slotService.addSlot(this.slotObj).subscribe((item:any)=>{
      if(item?.status?.toLowerCase()==='success')
      {
        this.toastrService.success(item?.message) 
        this.route.navigate(['landing'])
      }else{
        this.toastrService.error(item.message) 
      }
    },(error:any)=>{
      this.toastrService.error('something went wrong',error ) 
    })



  }
  addPlayer()
  {
    if(!this.playerObj.playerName)
    {
      this.toastrService.error('Please give a valid name') 
      return;
    }
    //this.playerObj.paidDate='not paid'
    this.playerObj.status=0


    this.playerList.push(this.playerObj)
    this.playerObj=new Player()
    this.calculatePerHead()
  }

  removePlayer(player:any)
  {
    this.playerList=this.playerList.filter((obj:any )=> {return obj !==player})
    this.calculatePerHead()
  }

calculatePerHead()
{
  this.slotObj.perHead=0
  if(this.playerList?.length>0)
      this.slotObj.perHead=this.slotObj.totalAmount/this.playerList.length
  else
      this.slotObj.perHead=this.slotObj.totalAmount


      this.slotObj.perHead=Number((Math.round(this.slotObj.perHead * 100) / 100).toFixed(2))
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

