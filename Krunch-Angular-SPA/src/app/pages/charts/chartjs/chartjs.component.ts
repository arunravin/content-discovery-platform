import { HttpClient } from '@angular/common/http';
import { AccountService } from './../../../account/services/account.service';
import { Component } from '@angular/core';
import { TrendModule } from 'ngx-trend';
import { DonutChart } from "@carbon/charts";

@Component({
  selector: 'ngx-chartjs',
  styleUrls: ['./chartjs.component.scss'],
  templateUrl: './chartjs.component.html',
})
export class ChartjsComponent {


  constructor( private accountService: AccountService , private httpClient: HttpClient ) {
    }

    

  }