import { Events } from "./../../../event-broker/events.model";
import { Router, ActivatedRoute } from "@angular/router";
import { routes } from "./../../../app-routing.module";
import { TopicsService } from "../services/topicss.service";
import { Component } from "@angular/core";
import { CommentsService } from "../services/comments.service";
import { SelectItem, SelectItemGroup } from "primeng/api";
import { MegaMenuItem, MenuItem } from "primeng/api";

@Component({
  selector: "ngx-smarttable",
  templateUrl: "./smart-table.component.html",
  styleUrls: ["./smart-table.component.scss"],
})
export class SmartTableComponent {
  topics;
  totalRecords;
  value4;

  selectedItemNgModel: any;
  searchStringNgModel: any;

  selectedTopic: string;

  items: MegaMenuItem[];

  constructor(
    private commentService: TopicsService,
    private activatedRoute: ActivatedRoute,
    router: Router
  ) {

    if (
      activatedRoute.snapshot.url[1] !== undefined &&
      activatedRoute.snapshot.url[1] !== null
    ) {
      //console.log(  "activatedRoute.url.value[1].path " +     activatedRoute.snapshot.url[1].path    );
      this.topics = this.onChangeTopic(activatedRoute.snapshot.url[1].path);
    } else {
   //   console.log("activatedRoute.url.value[0].path " +    activatedRoute.snapshot.url[0].path );

      this.topics = this.loadVideos("cloud");
    }
   // console.log("Route URL ::: " + router.url); // to print only path eg:"/login"
  }

  loadVideos(event) {
  //  console.log("Load Videos : ");
    this.commentService.getVideos(event).subscribe((res) => {
      this.topics = res["topics"];
      //  console.log("Load COmments : " + res['topics']);
      this.totalRecords = res["total"];
    });
  }

  onChangeTopic(topicData): void {
    // console.log('onChangeTopic *** ..'+ topicData);
    // console.log("URL " + this.route.url.toString);

    this.commentService.getVideos(topicData).subscribe((res) => {
      this.topics = res["topics"];
      //  console.log("Load Topics : " + res['topics']);
    });
  }

  entitySearch(topicData): void {
    console.log("Entity Search  *** .." + topicData);

    this.commentService.entitySearch(topicData).subscribe((res) => {
      this.topics = res["topics"];
      // console.log("Load Topics : " + res['topics']);
    });
  }

  searchValue: string;
  ngOnInit() {
    // Note: Below 'queryParams' can be replaced with 'params' depending on your requirements
    this.activatedRoute.queryParams.subscribe((params) => {
      this.searchValue = params["searchValue"];
    //  console.log("Query Parameter : " + this.searchValue);
    });

    if (this.searchValue != null) {
      this.loadVideos(this.searchValue);
    } else {
      this.loadVideos("cloud");
    }
  }
}
