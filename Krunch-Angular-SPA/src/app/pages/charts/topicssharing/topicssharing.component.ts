import { TopicsService } from "./../../tables/services/topicss.service";
import { Component } from "@angular/core";

@Component({
  selector: "ngx-topicssharing",
  templateUrl: "./topicssharing.component.html",
  styleUrls: ["./topicssharing.component.scss"],
})
export class TopicssharingComponent {
  
  topics: any;

  constructor(private topicsService: TopicsService) {
    this.topics = this.onChangeTopic("Cloud");
  }

  onChangeTopic(topicData): void {
   // console.log("Load Material Card " + topicData);
     this.topicsService.getTopics(topicData).subscribe((res) => {
      this.topics = res["topics"];
    //  console.log("Load Topics : " + res["topics"]);
    });
  }
}
