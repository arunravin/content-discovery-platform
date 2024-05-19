import { TimelineComponent } from './timeline/timeline.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ChartsComponent } from './charts.component';
import { EchartsComponent } from './echarts/echarts.component';
import { D3Component } from './d3/d3.component';
import { ChartjsComponent } from './chartjs/chartjs.component';
import { MyfeedsComponent } from './myfeeds/myfeeds.component';

const routes: Routes = [{
  path: '',
  component: ChartsComponent,
  children: [{
    path: 'journey',
    component: ChartjsComponent,
  },{
    path: 'dashboard',
    component: MyfeedsComponent,
  },{
    path: 'timeline',
    component: TimelineComponent,
  }

],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ChartsRoutingModule { }

export const routedComponents = [
  ChartsComponent,
  EchartsComponent,
  D3Component,
  ChartjsComponent,
  MyfeedsComponent
];
