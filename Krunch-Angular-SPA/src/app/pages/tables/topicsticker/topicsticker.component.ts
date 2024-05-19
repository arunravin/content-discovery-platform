import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ngx-topicsticker',
  templateUrl: './topicsticker.component.html',
  styleUrls: ['./topicsticker.component.scss']
})
export class TopicstickerComponent implements OnInit {

  constructor() { }
  eventList = new Array<string>();
  playState = false;
  ngOnInit() {
    this.eventList.push(`Launch Date : 08-Jan-2021 [Empowered with Text Search algorithms]    `);
    this.eventList.push(`User Groups Collaborations & Intents to create POC   `);
    this.eventList.push(`“My Learning Journey , Topic Similarity and Word Cloud    `);
    this.eventList.push(`Deploy on the Cloud`);
    this.eventList.push(``);
  }

  ngAfterViewInit(){
   
   this.playState = true;
  }

}
