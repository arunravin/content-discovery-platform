import { Component, OnInit } from '@angular/core';
import * as Highcharts from "highcharts";

@Component({
  selector: 'ngx-threedimensionchart',
  templateUrl: './threedimensionchart.component.html',
  styleUrls: ['./threedimensionchart.component.scss']
})
export class ThreedimensionchartComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  highcharts = Highcharts;
   chartOptions = {   
      chart : {
         type:'pie',
         options3d: {
            enabled: true,
            alpha: 45,
            beta: 0
         }
      },
      title : {
         text: 'My Learning Journey'   
      },
      tooltip : {
         pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
      },
      plotOptions : {
         pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            depth: 35,
            dataLabels: {
               enabled: true,
               format: '<b>{point.name}%</b>: {point.percentage:.1f} %',
               style: {
                  color: 
                  'black'
               }
            }
         }
      },
      series : [{
         type: 'pie',
         name: 'Learning Journey',
         data: [
            ['Read',   45.0],
            ['Liked',       26.8],
            {
               name: 'Further Study',
               y: 12.8,
               sliced: true,
               selected: true
            },
            ['Shared',    8.5],
            ['Unlike',     6.2],
            ['Others',      0.7]
         ]
      }]
   };

}
