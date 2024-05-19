import { Component, OnInit } from '@angular/core';
import * as Highcharts from "highcharts/highstock";

@Component({
  selector: 'ngx-stockchart',
  templateUrl: './stockchart.component.html',
  styleUrls: ['./stockchart.component.scss']
})
export class StockchartComponent implements OnInit {

  Highcharts: typeof Highcharts = Highcharts;

  chartOptions: Highcharts.Options = {
    credits: {
      enabled: false
    },
    series: [
      {
        type: 'line',
        pointInterval: 24 * 3600 * 1000,
        data: [10,30, 25, 20, 40]
      }
    ]
  };

  constructor() { }

  ngOnInit() {
  }

}
