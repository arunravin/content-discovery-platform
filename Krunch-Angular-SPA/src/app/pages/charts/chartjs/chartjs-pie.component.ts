import { Router, NavigationEnd } from '@angular/router';
import { UpdateRecorder } from '@angular-devkit/schematics';
import { HttpClient } from '@angular/common/http';
import { AccountService } from './../../../account/services/account.service';
import { MyLearningsService } from './../services/mylearnings.service';
import { Component, OnDestroy } from '@angular/core';
import { NbThemeService } from '@nebular/theme';

import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';
import { environment } from './../../../../environments/environment';

@Component({
  selector: 'ngx-chartjs-pie',
  styleUrls: ['./chartpiejs.component.scss'],
  template: `
    <chart  type="pie" [data]="data1"  [options]="options"></chart>
    
  `,
})
export class ChartjsPieComponent implements OnDestroy {
  data: any;
  data1: any;
  options: any;
  dataValues: any;
  themeSubscription: any;
  mySubscription: any;
  username;
  apiURL: string = environment.apiUrl+'/v1/learningjourney/engagements1'; 
  queryUrl: string = '?userName=';


  constructor(private theme: NbThemeService ,private myLearningService: MyLearningsService 
    , private userService: AccountService,private http: HttpClient,private router: Router) {
      

      
   //   console.log("Constructor Invoked ....")
    this.themeSubscription = this.theme.getJsTheme().subscribe(config => {

      
      const colors: any = config.variables;
     const chartjs: any = config.variables.chartjs;
    
      this.options = {
        maintainAspectRatio: false,
        responsive: true,
        scales: {
          xAxes: [
            {
              display: false,
            },
          ],
          yAxes: [
            {
              display: false,
            },
          ],
        },
        legend: {
          labels: {
                  fontColor: chartjs.textColor,
          },
        },
      };
    });
/*
    this.data = {
      labels: ['Liked','Read', 'Sharing Intent', 'Not Interested' , 'Further Exploration'],
      datasets: [{
        backgroundColor: [
          'rgba(46, 204, 113,1.0)','rgba(205, 97, 51,1.0)','rgba(44, 44, 84,1.0)','rgba(255, 242, 0,1.0)',
          ,'rgba(61, 61, 61,1.0)',
          ],
      }],
    };
**/
    

    this.username = this.userService.userValue.username;
    this.http.get<any>(this.apiURL + this.queryUrl + this.username).subscribe(datafs => {
      this.data = datafs
      this.data1 = this.data
      
  }) 

  this.data1=this.data;

  //console.log("Data1" + this.data1)
    
  }



  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();

    if (this.mySubscription) {
      this.mySubscription.unsubscribe();
    }
   
  }

  

  ngOnInit(): void {
   //console.log("NGOnInit Invoked ....");

   window.dispatchEvent(new Event('resize'));


  // console.log("Data1 ngoninit  " + this.data1)
}

ngOnChanges() {
  /**********THIS FUNCTION WILL TRIGGER WHEN PARENT COMPONENT UPDATES 'someInput'**************/
  //Write your code here
   //console.log("On Change ");
  }   

}