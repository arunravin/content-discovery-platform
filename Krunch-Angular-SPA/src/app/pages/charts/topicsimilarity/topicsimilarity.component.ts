import { MyLearningsService } from './../services/mylearnings.service';
import { delay } from 'rxjs/operators';
import { HttpClient } from "@angular/common/http";
import { ChangeDetectionStrategy, Component, OnInit, ViewChild } from "@angular/core";
import { TreeNode } from "primeng/api";
import { ChangeDetectorRef } from "@angular/core";
import { Subject } from 'rxjs';
import { AccountService } from '../../../account/services';
import { environment } from './../../../../environments/environment';

@Component({
  selector: "ngx-topicsimilarity",
  templateUrl: "./topicsimilarity.component.html",
  styles: [
    `
      :host ::ng-deep .priority-2,
      :host ::ng-deep .priority-3,
      :host ::ng-deep .visibility-sm {
        display: none;
      }

      :host ::ng-deep tr:hover {
        background-color: #dfe4ea;
      }
      a:link {
        color: red;
      }

      /* visited link */
      a:visited {
        color: green;
      }

      /* mouse over link */
      a:hover {
        color: hotpink;
      }

      /* selected link */
      a:active {
        color: blue;
      }
      /*
  :host ::ng-deep tr:nth-child(even) {background-color: #dff9fb;}

 :host ::ng-deep th, td {border: .4px solid #95a5a6;;}**/

      @media screen and (max-width: 39.938em) {
        :host ::ng-deep .visibility-sm {
          display: inline;
        }
      }

      @media screen and (min-width: 40em) {
        :host ::ng-deep .priority-2 {
          display: table-cell;
        }
      }

      @media screen and (min-width: 64em) {
        :host ::ng-deep .priority-3 {
          display: table-cell;
        }
      }
    `,
  ],
})
export class TopicsSimilarityComponent {
  selectedNodes3 = [];
 
  
  apiURL: string = environment.apiUrl+"/v1/learningjourney/recommendations";
  queryUrl: string = "?topicTitle=";

  researchApiURL: string = environment.apiUrl+"/v1/learningjourney/research";
  researchQueryUrl: string = "?userName=";

  userName;
  files: TreeNode[] ;
  //private updateResultsSource: Subject<TreeNode[]> = new Subject();
  //private _updateEvent = this.updateResultsSource.asObservable();

  files1: TreeNode[];
  cols = [
    { field: "name", header: "Research Topic" },
    { field: "type", header: "Topic Description" },
  ]; 

  loadNodes(event) {
   
    this.userName = this.userService.userValue.username;
    this.researchTopic(this.userName);
   
}

refreshNodes(event) {
   
  this.userName = this.userService.userValue.username;
  this.refreshResearchTopics(this.userName);
  
 
}


researchTopic(userName): void {
   //console.log('*** Research Topic *** ..'+ userName);
  // console.log("URL " + this.route.url.toString);
 
   this.learningService.getReseacrhTopics(userName).subscribe(files => {
     this.files = files['topics'];
 //    console.log(this.files);
 //    console.log("Load Topics : " + files['topics']);
   
   });
   
 }

 refreshResearchTopics(topicData): void {
  //console.log('*** Research Topic *** ..'+ topicData);
 // console.log("URL " + this.route.url.toString);

  this.learningService.refreshReseacrhTopics(topicData).subscribe(files => {
    this.files = files['topics'];
//    console.log(this.files);
//    console.log("Load Topics : " + files['topics']);
  
  });
  
}

  ngOnInit() {
   // console.log("Tree Node Data " + this.files);
  }

  constructor(private http: HttpClient , private learningService: MyLearningsService,
    private userService: AccountService) {



  }


  onNodeExpand(event) {
    //console.log("Node Expand Event Row Data Value 1 : " + event.node.data.name);
      
  }


 
}
