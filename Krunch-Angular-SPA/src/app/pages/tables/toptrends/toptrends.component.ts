import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { AccountService } from '../../../account/services';
import { TopicsService } from '../services/topicss.service';
import { environment } from './../../../../environments/environment';

@Component({
  selector: 'ngx-toptrends',
  templateUrl: './toptrends.component.html',
  styleUrls: ['./toptrends.component.scss']
})
export class ToptrendsComponent implements OnInit {


  topTrends;
  userName;
  resId;
  searchValue;

  @Input() parentSearchValue: string;



  constructor(private commentService: TopicsService ,  private accountService: AccountService
    ,private httpClient: HttpClient , private activatedRoute: ActivatedRoute) { 

   // this.parentSearchValue="Microservice"
  
    console.log("Top Trends Constructor Invoked");

  }

  ngOnInit() {
    console.log("Top Trends NgOnInit Invoked");
    this.topTrendsSearch(this.parentSearchValue);



  }

 

  topTrendsSearch(topicData): void {
    
    console.log('Entity Search  *** ..'+ topicData);
  
    this.commentService.topTrendsSearch(encodeURIComponent(topicData)).subscribe(res => {
      this.topTrends = res['topTrends'];
          console.log("Top Trends Topics : " + res['topTrends']);
      });

         
  
  }

  
  topicClicked(topicurl){
    //console.log('Add To Queue *** ..'+ topicurl);
   
    //console.log("User Name  " + this.accountService.userValue.username);
     this.userName = this.accountService.userValue.username;


     //console.log("Before Posting the Reuest" );

     this.resId=0;
     this.httpClient.post<any>(environment.apiUrl+'/v1/digitaltrends/topics/topicread', 
     { username: this.userName , topicurl: topicurl}).subscribe(data => {
      this.resId = data;
      //console.log("Response data :  " + data)
  })

  if (this.resId == 1) 
    {
        alert("Topic Added Successfully . ");
    } 
   

     //console.log("After Posting the Request" );
   }

  

}
