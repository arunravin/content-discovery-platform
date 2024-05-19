import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
@Component({
  selector: 'ngx-UserEngagementCharts',
  templateUrl: './UserEngagementCharts.component.html',
  styleUrls: ['./UserEngagementCharts.component.scss']
})
export class UserEngagementChartsComponent implements OnInit {

  highcharts = Highcharts;
  chartOptions = { 
    
     chart: {
        type: "spline"
     },
     credits: {
      enabled: false
    },
     title: {
        text: "Monthly Reading Trends"
     },
     
     subtitle: {
        text: "Testing High Charts"
     },
     xAxis:{
        categories:["Jan", "Feb", "Mar", "Apr", "May", "Jun",
           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
     },
     yAxis: {          
        title:{
           text:"No of Articles"
        } 
     },
     tooltip: {
        valueSuffix:" "
     },
     
     series: [
        {
           name: 'Mark',
           data: [70, 69, 95, 145, 182, 215, 252,265, 233, 183, 139, 96]
        },
        {
           name: 'Jack',
           data: [2, 8, 7, 113, 170, 22, 248,241, 201, 141, 86, 25]
        },
        {
           name: 'Tom',
           data: [9, 6, 35, 84, 135, 170, 186, 179, 143, 90, 39, 10]
        },
        {
           name: 'Ram',
           data: [39, 42, 57, 85, 119, 152, 170, 166, 142, 103, 66, 48]
        },
     ]
  };

  constructor() { }

  ngOnInit() {
  }

}
