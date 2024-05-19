import { HttpClient } from '@angular/common/http';
import { AccountService } from './../../../account/services/account.service';
import { Component, OnDestroy } from '@angular/core';
import { NbThemeService, NbColorHelper } from '@nebular/theme';
import { environment } from './../../../../environments/environment';


@Component({
  selector: 'ngx-chartjs-bar',
  template: `
    <chart type="bar" [data]="data" [options]="options"></chart>
  `,
})
export class ChartjsBarComponent implements OnDestroy {
  data: any;
  options: any;
  themeSubscription: any;
  resData: any;
  username;
  apiURL: string = environment.apiUrl+'/v1/learningjourney/useractivity'; 
  queryUrl: string = '?userName=';


  constructor(private theme: NbThemeService,private userService: AccountService,private http: HttpClient) {


    this.themeSubscription = this.theme.getJsTheme().subscribe(config => {

      const colors: any = config.variables;
      const chartjs: any = config.variables.chartjs;


      this.username = this.userService.userValue.username;
      this.http.get<any>(this.apiURL + this.queryUrl + this.username).subscribe(datafs => {
        this.data = datafs
        
    })
    
    //console.log("Color Code " + NbColorHelper.hexToRgbA(colors.primaryLight, 0.8));
  /*
     this.data = {
        labels: ['2020-12-01', '2020-12-02', '2020-12-03', '2020-12-04', '2020-12-04', '2020-12-04', '2020-12-04','2020-12-03','2020-12-04'],
        datasets: [
               {
          data: [8, 4, 8, 1, 10, 12, 14,15,18],
          label: 'Whats Achieved',
          backgroundColor: NbColorHelper.hexToRgbA(colors.primaryLight, 0.8),
        }],
      };
  **/
      this.options = {
        maintainAspectRatio: false,
        responsive: true,
        legend: {
          labels: {
            fontColor: chartjs.textColor,
          },
        },
        scales: {
          xAxes: [
            {
              gridLines: {
                display: false,
                color: chartjs.axisLineColor,
              },
              ticks: {
                fontColor: chartjs.textColor,
              },
            },
          ],
          yAxes: [
            {
              gridLines: {
                display: true,
                color: chartjs.axisLineColor,
              },
              ticks: {
                fontColor: chartjs.textColor,
                beginAtZero: true
              },
            },
          ],
        },
      };
    });
  }

  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();
  }
}
