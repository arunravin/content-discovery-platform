import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AccountService } from './../../../account/services/account.service';
import { Component, OnInit } from '@angular/core';
import { PrimeIcons } from 'primeng/api';
import { environment } from './../../../../environments/environment';

@Component({
  selector: 'ngx-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.scss']
})
export class TimelineComponent implements OnInit {

  username;
  apiURL: string = environment.apiUrl+'/v1/analytics/search/trends'; 
  queryUrl: string = '?userName=';

  constructor(private userService: AccountService,private http: HttpClient,private router: Router) {

   }

 events: any[];
 events1: any[];
    
//         {date: '02/02/2021', mytopics: 'AWS , MicroServices, NLP , Digital , Patterns,Kubernetes, Docker ', icon: PrimeIcons.CHEVRON_CIRCLE_RIGHT, trendingtopics: 'Artificial Intelligence,DeepLearning ,  LowCode, SRE , Multi-cloud',  color: '', image: ''},
   

    ngOnInit() {

      this.username = this.userService.userValue.username;
      //console.log("Search Trends NgOnInit : " + this.username);

      this.http.get<any>(this.apiURL + this.queryUrl + this.username).subscribe(datafs => {
        this.events = datafs

        this.events1 = this.events
       // console.log(this.events1);
    }) 

       /*  
                this.events1 = [
                    {date: '02/02/2021', mytopics: 'AWS , MicroServices, NLP , Digital , PAtterns,Kubernetes, Docker ', icon: PrimeIcons.CHEVRON_CIRCLE_RIGHT, trendingtopics: 'Artificial Intelligence,DeepLearning ,  LowCode, SRE , Multi-cloud',  color: '#ff3f34', image: ''},
                    {date: '01/02/2021', mytopics: 'Cloud Migration,BigData Analytics,Digital Economy,SpringBoot',   icon: PrimeIcons.CHEVRON_CIRCLE_LEFT, trendingtopics: 'Computer Vision,Virtual Reality,Kafka , Analytics, Data Lake ', color: '#0000FF'},
                    {date: '31/01/2021', mytopics: 'Cloud Migration,BigData Analytics,Digital Economy,Design Thinking',  icon: PrimeIcons.CHEVRON_CIRCLE_RIGHT, trendingtopics: 'Cyber Security , OWASP',color: '#EA2027'},
                    {date: '30/01/2021', mytopics: 'Cloud Migration,BigData Analytics',  icon: PrimeIcons.CHEVRON_CIRCLE_LEFT,trendingtopics: 'Excellent', color: '#009432'},
                    {date: '29/01/2021', mytopics: 'Design Patterns, Security Best Practices,Digital Economy,Design Thinking',  icon: PrimeIcons.CHEVRON_CIRCLE_RIGHT,trendingtopics: 'Excellent', color: '#fff200'},
                    {date: '28/01/2021', mytopics: 'Enterprise Architecture' , icon: PrimeIcons.CHEVRON_CIRCLE_LEFT, trendingtopics: 'Ledger', color: '#f368e0'},
                    {date: '27/01/2021', mytopics: '' , icon: PrimeIcons.CHEVRON_CIRCLE_RIGHT, trendingtopics: 'Bitcoin , Wallstreet', color: '#000000'}
                ];
        */    
        
}
}