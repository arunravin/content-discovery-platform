import { Router, ActivatedRoute } from "@angular/router";
import { TopicWordCloudService } from "../../tables/services/wordcloud.service ";
import { SelectItem } from "primeng/api";
import { Component, Input, OnInit } from "@angular/core";
import {
  CloudData,
  CloudOptions,
  ZoomOnHoverOptions,
} from "angular-tag-cloud-module";

@Component({
  selector: "ngx-topicwordcloud",
  templateUrl: "./wordcloud.component.html",
  styleUrls: ["./wordcloud.component.scss"],
})
export class WordcloudComponent {
  value1: any;
  originalTopic: string ;

  options: CloudOptions = {
    // if width is between 0 and 1 it will be set to the width of the upper element multiplied by the value
    width: 625,
    // if height is between 0 and 1 it will be set to the height of the upper element multiplied by the value
    height: 550,
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
  @Input() parentSearchValue: string;

  constructor(
    private topicWordCLoudService: TopicWordCloudService,
    public router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    
  }
  wordCloudData: CloudData[];
  wordCloudPersonData: CloudData[];

  logClicked(clicked: CloudData){
    //console.log(clicked);
    console.log(this.searchValue1 + clicked.text);
    this.router.navigate(['/explore/topics/data'],{ queryParams: { searchValue: this.searchValue1 + ' '+clicked.text  ,topicClicked: "Y"} });
  

  }

  ngOnInit() {
    // Note: Below 'queryParams' can be replaced with 'params' depending on your requirements
  /*
    this.activatedRoute.queryParams.subscribe((params) => {
      this.searchValue1 = params["keyWord"];
      //console.log("Query Parameter : " + this.searchValue1);
    });
**/

    this.searchValue1=this.parentSearchValue;

    if (this.searchValue1 != null) {


      this.topicWordCLoudService
      .getPersonCloudSearchTopics(this.searchValue1)
      .subscribe((res) => {
        this.wordCloudPersonData = res["topics"];
        //  //console.log("Load Topics : " + res['topics']);
      });

      this.topicWordCLoudService
        .getWordCloudSearchTopics(this.searchValue1)
        .subscribe((res) => {
          this.wordCloudData = res["topics"];
          // //console.log("Load Topics : " + res['topics']);
        });

   
    } 
  }
}
