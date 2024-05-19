import { Router, ActivatedRoute } from "@angular/router";
import { TopicWordCloudService } from "./../tables/services/wordcloud.service ";
import { SelectItem } from "primeng/api";
import { Component, OnInit } from "@angular/core";
import {
  CloudData,
  CloudOptions,
  ZoomOnHoverOptions,
} from "angular-tag-cloud-module";

@Component({
  selector: "ngx-wordcloud",
  templateUrl: "./wordcloud.component.html",
  styleUrls: ["./wordcloud.component.scss"],
})
export class WordcloudComponent {
  value1: any;
  originalTopic: string ;

  options: CloudOptions = {
    // if width is between 0 and 1 it will be set to the width of the upper element multiplied by the value
    width: 600,
    // if height is between 0 and 1 it will be set to the height of the upper element multiplied by the value
    height: 500,
    overflow: false,
    randomizeAngle: true,
  };

  zoomOnHoverOptions: ZoomOnHoverOptions = {
    scale: 2, // Elements will become 130 % of current zize on hover
    transitionTime: 1.0, // it will take 1.2 seconds until the zoom level defined in scale property has been reached
    delay: 0.5 // Zoom will take affect after 0.8 seconds
  };


  topicOptions: SelectItem[];
  selectedTopic: SelectItem;
  searchTopicName: String;
  param1: String;
  searchValue1: String;

  constructor(
    private topicWordCLoudService: TopicWordCloudService,
    public router: Router,
    private activatedRoute: ActivatedRoute
  ) {}
  wordCloudData: CloudData[];
  wordCloudPersonData: CloudData[];
  onChangeTopic(topicData): void {
    //console.log("onChangeTopic *** .." + topicData);
    //console.log("Selected Topics *** .." + this.selectedTopic);

    // //console.log("URL " + this.route.url.toString);

    this.topicWordCLoudService
      .getWordCloudTopics(this.selectedTopic)
      .subscribe((res) => {
        this.wordCloudData = res["topics"];
        //  //console.log("Load Topics : " + res['topics']);
      });

    this.topicWordCLoudService
      .getPersonCloudTopics(this.selectedTopic)
      .subscribe((res) => {
        this.wordCloudPersonData = res["topics"];
        //  //console.log("Load Topics : " + res['topics']);
      });
  }

  wordCloudSearch(topicData): void {
    //console.log("wordCloudSearch *** .." + this.searchTopicName);

    // //console.log("URL " + this.route.url.toString);

    this.topicWordCLoudService
      .getWordCloudSearchTopics(this.searchTopicName)
      .subscribe((res) => {
        this.wordCloudData = res["topics"];
        //  //console.log("Load Topics : " + res['topics']);
      });

    this.topicWordCLoudService
      .getPersonCloudSearchTopics(this.searchTopicName)
      .subscribe((res) => {
        this.wordCloudPersonData = res["topics"];
        //  //console.log("Load Topics : " + res['topics']);
      });
  }

  logClicked(clicked: CloudData){
    //console.log(clicked);
    //console.log(this.searchValue1 + clicked.text);
    this.router.navigate(['/explore/topics/data'],{ queryParams: { searchValue: this.searchValue1 + ' '+clicked.text  } });
    
  }


  beforeChange($event) {
    // dont do anything if id matches
    
    console.log("Event Emitted for Tab: "+$event.tabId);
    var index = $event.tabId;

    if(index == 0)
       {
        this.router.navigate(['/explore/topics/data'],{ queryParams: { searchValue: this.searchValue1 , sortBy: "relevancy" } });
  
        } else if (index == 1) {

        }else if (index == 2) {

        } 
    } 



  ngOnInit() {
    // Note: Below 'queryParams' can be replaced with 'params' depending on your requirements
    this.activatedRoute.queryParams.subscribe((params) => {
      this.searchValue1 = params["keyWord"];
      //console.log("Query Parameter : " + this.searchValue1);
    });

    if (this.searchValue1 != null) {
      this.topicWordCLoudService
        .getWordCloudSearchTopics(this.searchValue1)
        .subscribe((res) => {
          this.wordCloudData = res["topics"];
          // //console.log("Load Topics : " + res['topics']);
        });

      this.topicWordCLoudService
        .getPersonCloudSearchTopics(this.searchValue1)
        .subscribe((res) => {
          this.wordCloudPersonData = res["topics"];
          //  //console.log("Load Topics : " + res['topics']);
        });
    } 
  }
}
