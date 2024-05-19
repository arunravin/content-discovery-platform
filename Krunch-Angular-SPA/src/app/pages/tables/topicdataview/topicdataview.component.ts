import { filter } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { AccountService } from './../../../account/services/account.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TopicsService } from '../services/topicss.service';
import { Component, ViewChild } from '@angular/core';
import { SelectItem, SelectItemGroup,FilterService, FilterMatchMode } from 'primeng/api';
import {MegaMenuItem,MenuItem} from 'primeng/api';
import { environment } from './../../../../environments/environment';
import {ThemePalette} from '@angular/material/core';
import { NbIconConfig } from '@nebular/theme';
import { DatePipe } from '@angular/common';
import { MatRadioChange } from '@angular/material/radio';

@Component({
  selector: 'ngx-topicdataview',
  templateUrl: './topicdataview.component.html',
  styleUrls: ['./topicdataview.component.scss']
})
export class TopicdataviewComponent {
  
  topics;
  totalRecords;
  value4;
  username;
  resId;
  labelPosition: 'contains' | 'startsWith' = 'contains';
  rangeOperator;
  matchFilter;

  @ViewChild('dv') dataview: DataView;
  showTopicDataView:boolean=true;
  showTopicCloud:boolean=false;

  sortOptions: SelectItem[];
  sortKey: string;
  sortField: string;
  filterField: string;
  sortOrder: number;
  
  placeHolder: string;
 
  displayTop10: boolean =false;
  phraseSearch: boolean = false;
  selectedItemNgModel: any;
  selectedOperator: any;
  searchStringNgModel: any;
  searchValue: string;
  drillDownTextValue: string;
  rangeText: number;
  searchType: string;


  selectedTopic: string; 
  autoPopulate = ["Java" , "Integration","Fintech"];
  items: MegaMenuItem[];
  matchModeOptions: SelectItem[];
  currentSelection: string;
  
popularity: number;

bellIconConfig: NbIconConfig = { icon: 'bell-outline', pack: 'eva' };
youtubeIconConfig: NbIconConfig = { icon: 'fa-globe', pack: 'font-awesome' };

childSearchValue: string;
setActiveRY : boolean = false;
setActiveWC: boolean = false;

  constructor(private commentService: TopicsService ,
     private activatedRoute: ActivatedRoute , 
     public router: Router , 
     private accountService: AccountService , 
     private filterService: FilterService,
     private httpClient: HttpClient ) {
     console.log("Constructor Route URL ::: "  ); 
   

     const user = this.accountService.userValue;
     this.sortField="ogTitle"
     this.filterField="ogTitle,ogDescription";
 
     this.sortOrder=1;
     this.matchFilter="startsWith";
      ////console.log("Logged in User .." + user.id );
 
     this.placeHolder="Popularity";
     this.drillDownTextValue="";
    
     this.showTopicDataView===true;
     this.showTopicCloud=false;
     this.activatedRoute.queryParams.subscribe(params => {
                       this.searchValue = params['searchValue'];
                       this.showTopicDataView=true;
                       this.showTopicCloud=false;
                       this.currentSelection = decodeURIComponent(params['currentSelection']);
                       if(this.currentSelection!=null){
                         console.log("Current Selection : " + this.currentSelection )
                         this.currentSelection= 'Current Selection : '+decodeURIComponent(params['currentSelection'])
                       }
                         console.log("Search Query Parameter 8 : " + this.searchValue);
                         if(this.searchValue!=null)
                         {
                           this.childSearchValue=this.searchValue;
                           this.currentSelection='Search Results for : ' + this.searchValue
                           console.log("Query Parameter Search Value Not Null : " + this.searchValue);
                           this.entitySearch(this.searchValue);
 
                           
                         }  
                       
                       });
      
 

    if( activatedRoute.snapshot.url[1] !== undefined && activatedRoute.snapshot.url[1] !== null) {
      console.log("Constructor activatedRoute.url.value[1].path " + activatedRoute.snapshot.url[1].path);
      this.childSearchValue=activatedRoute.snapshot.url[1].path;
      this.topics = this.onChangeTopic(activatedRoute.snapshot.url[1].path  );
      
      
    } 

     // to print only path eg:"/login"
        
      
   }

   topicClicked2: string

   ngOnInit() {


   }

   
  
   beforeChange($event) {
    // dont do anything if id matches
    
    console.log("Event Emitted for Tab: "+$event.tabId);
    var index = $event.tabId;

    if(index == 0)
    {
        this.showTopicDataView=true;
        this.showTopicCloud=false;
        this.onSortChange('!relevancy');
       
      } else if (index == 1) {
        this.showTopicDataView=true;
        this.showTopicCloud=false;
        this.onSortChange('!popularity');
       
    }else if (index == 2) {
        this.showTopicDataView=true;
        this.showTopicCloud=false;
        this.onSortChange('$createdAt');
      
    }else if (index == 3) {
      this.showTopicCloud=true;
      this.showTopicDataView=false;
      //this.routeToOrgPersonEntities('cloud');
    } else if (index == 4) { 
    // this.routeToVideos('cloud');
    }
} 

   tabClicked(event){
     //console.log("Tab Clicked");

   }


   matchFilterChange($event: MatRadioChange){

    //console.log( $event.value);
    this.filterField="ogTitle";
    this.labelPosition=$event.value;
    
   }

   rangeFilterChange(event){

    //console.log("Range Filter: "+ event);
    this.filterField=event;
    if(this.filterField=='createdAt') {

    this.searchType='date';
    } else{
      this.searchType='number';
    }
    //this.labelPosition=$event.value;
    
   }

   operatorChange(event){

    //console.log("Selected Operator: "+ this.selectedOperator);
    this.rangeOperator=this.selectedOperator;
    //this.rangeOperator=event.
    //this.labelPosition="ogTitle";
    //this.labelPosition=$event.value;
    
   }
   
   customDateFilter(value,rangeoperator){

   // this.dataview.filter($event.target.value, labelPosition)


   }



  loadComments(event){
    //console.log("Load Comments : " + event);
    this.commentService.getComments(event.first, event.rows).subscribe(res => {
      this.topics = res['topics'];
    //  //console.log("Load COmments : " + res['topics']);
      this.totalRecords = res['total'];
    })
    this.placeHolder="Popularity"
  }


  onChangeTopic(topicData): void {
   // //console.log('onChangeTopic *** ..'+ topicData);
   // //console.log("URL " + this.route.url.toString);
   this.phraseSearch=false;
   
    this.commentService.getTopics(topicData).subscribe(res => {
      this.topics = res['topics'];
    //  //console.log("Load Topics : " + res['topics']);
    
    });

     this.topTrendsSearch(topicData);
    
  }

   addToQueue(topicurl){
    //console.log('Add To Queue *** ..'+ topicurl);
   
    //console.log("User Name  " + this.accountService.userValue.username);
     this.username = this.accountService.userValue.username;


     //console.log("Before Posting the Reuest" );

     this.resId=0;
     this.httpClient.post<any>( environment.apiUrl+ '/v1/digitaltrends/topics/addtoqueue', 
     { username: this.username , topicurl: topicurl}).subscribe(data => {
      this.resId = data;
      //console.log("Response data :  " + data)
  })

  if (this.resId == 1) 
    {
        alert("Topic Added Successfully . ");
    } 
   

     //console.log("After Posting the Request" );
   }

   thumbUp(topicurl){
    //console.log('Add To Queue *** ..'+ topicurl);
   
    //console.log("User Name  " + this.accountService.userValue.username);
     this.username = this.accountService.userValue.username;


     //console.log("Before Posting the Reuest" );

     this.resId=0;
     this.httpClient.post<any>(environment.apiUrl+'/v1/digitaltrends/topics/like', 
     { username: this.username , topicurl: topicurl,isliked: 'Y'}).subscribe(data => {
      this.resId = data;
      //console.log("Response data :  " + data)
  })

  if (this.resId == 1) 
    {
        alert("Topic Added Successfully . ");
    } 
   

     //console.log("After Posting the Request" );
   }

   thumbDown(topicurl){
    //console.log('Add To Queue *** ..'+ topicurl);
   
    //console.log("User Name  " + this.accountService.userValue.username);
     this.username = this.accountService.userValue.username;


     //console.log("Before Posting the Reuest" );

     this.resId=0;
     this.httpClient.post<any>(environment.apiUrl+'/v1/digitaltrends/topics/unlike', 
     { username: this.username , topicurl: topicurl,isliked: 'N'}).subscribe(data => {
      this.resId = data;
      //console.log("Response data :  " + data)
  })

  if (this.resId == 1) 
    {
        alert("Topic Added Successfully . ");
    } 
   

     //console.log("After Posting the Request" );
   }

  
   topicClicked(topicurl){
    //console.log('Add To Queue *** ..'+ topicurl);
   
    //console.log("User Name  " + this.accountService.userValue.username);
     this.username = this.accountService.userValue.username;


     //console.log("Before Posting the Reuest" );

     this.resId=0;
     this.httpClient.post<any>(environment.apiUrl+'/v1/digitaltrends/topics/topicread', 
     { username: this.username , topicurl: topicurl}).subscribe(data => {
      this.resId = data;
      //console.log("Response data :  " + data)
  })

  if (this.resId == 1) 
    {
        alert("Topic Added Successfully . ");
    } 
   

     //console.log("After Posting the Request" );
   }

   topTrends;

   
  topTrendsSearch(topicData): void {
    
    console.log('Entity Search  *** ..'+ topicData);
  
   console.log("LCNC : " + topicData.indexOf("lcnc"));

   if (topicData.indexOf('lcnc')===0) {

    topicData="Low Code No Code"
   }

    if (topicData.indexOf('desc')>0) {
      console.log("No Action" );
    } else{
      this.commentService.topTrendsSearch(encodeURIComponent(topicData)).subscribe(res => {
        this.topTrends = res['topTrends'];
            console.log("Top Trends Topics : " + res['topTrends']);
        });

    }

  

         
  
  }

  entitySearch(topicData): void {
    
    console.log('Entity Search  *** ..'+ topicData);
    console.log('Show data View Ng Model Value ' + this.showTopicDataView);
    //this.placeHolder="Relevancy";
    this.phraseSearch=true;
    this.showTopicDataView=true;
    this.showTopicCloud=false;
    
    this.topTrendsSearch(topicData);
    this.commentService.entitySearch(encodeURIComponent(topicData)).subscribe(res => {
    this.topics = res['topics'];
        //console.log("Load Topics : " + res['topics']);
    });
    
      this.postKeywordSearch(this.searchValue);
  //  this.placeHolder="Relevancy"; 
  }


  postKeywordSearch(keyword){
    //console.log('Search Keyword  *** ..'+ keyword);
   
    //console.log("User Name  " + this.accountService.userValue.username);
     this.username = this.accountService.userValue.username;
     this.commentService.postSearchKeywords(keyword,this.username );
   }


  shareButtonClicked(event ,topicurl){
    
    //console.log('Share Button Clicked*** ..'+ topicurl);
    //console.log('Share Button Clicked event . ..'+ event);
    //console.log("User Name  " + this.accountService.userValue.username);

    this.username = this.accountService.userValue.username;

    //console.log("Before Posting the Reuest" );

     this.resId=0;
     this.httpClient.post<any>(environment.apiUrl+ '/v1/digitaltrends/topics/sharetopic', 
     { username: this.username , topicurl: topicurl,socialMediaName: event}).subscribe(data => {
      this.resId = data;
      //console.log("Response data :  " + data)
  })

  if (this.resId == 1) 
    {
        alert("Share Button clicked Successfully . ");
    } 
   

     //console.log("After Posting the Request" );
   }

 
  

routeToVideos(topicName) {
  
  //console.log("ROute To Videos Search : " + this.searchValue);
  if(this.searchValue!=null){
    this.router.navigate(['explore/topics/videos'],{ queryParams: { searchValue: this.searchValue  , isKeyWordSearch: 'Y'} });

  } else {
    //console.log("Menu Value ***" + this.activatedRoute.snapshot.url[1].path)
    this.router.navigate(['explore/topics/videos'],{ queryParams: { searchValue: this.activatedRoute.snapshot.url[1].path , isKeyWordSearch: 'N'  } });
    
  }
}


routeToOrgPersonEntities(topicName) {
  
  console.log("RouteToOrgPersonEntities Search : " + this.searchValue);
        if(this.searchValue!=null){
          this.router.navigate(['explore/wordcloud'],{ queryParams: { keyWord: this.searchValue  } });
         } else {
          //console.log("Menu Value ***" + this.activatedRoute.snapshot.url[1].path)
          this.router.navigate(['explore/wordcloud'],{ queryParams: { keyWord: this.activatedRoute.snapshot.url[1].path  } });
          
        }
        

  }

   popular:string ='!popularity';
   relevant:string ='!relevancy';
   recency:string ='$createdAt';

   onSortChange(event) {
 
   
    if (event.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = event.substring(1, event.length);
      //console.log("sort Field : " + this.sortField);
  } 

  if (event.indexOf('$') === 0) {

    //console.log("Created At Sort Order Change " + event );
    //console.log("Phrase Search " + this.phraseSearch );
         
    if(event === '$createdAt' && !this.phraseSearch ) {
   //   //console.log("Url Path while Sorting: " + this.activatedRoute.snapshot.url[1].path)
      this.onChangeTopic(this.activatedRoute.snapshot.url[1].path+'desc')
   } else if(event === '$createdAt' && this.phraseSearch ) {
     // //console.log(" Phrase Search Sorting: " + this.activatedRoute.snapshot.url[1].path)
      this.entitySearch('$'+this.searchValue);
   }
  }
  
}

 

}