import { TimeseriesComponent } from './timeseries/timeseries.component';


import { StockchartComponent } from './stockchart/stockchart.component';
import { ButtonModule } from 'primeng/button';
import { MatChipsModule } from '@angular/material/chips';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { NewsService } from './news.service';

import { TimelineModule } from 'primeng/timeline';

import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { ChartjsComponent } from './chartjs/chartjs.component';
import { NgTrendComponent } from './chartjs/ngx.trend.component';
import { MyLearningsService } from './services/mylearnings.service';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { TopicsSimilarityComponent } from './topicsimilarity/topicsimilarity.component';
import { NgModule } from '@angular/core';
import { NgxEchartsModule } from 'ngx-echarts';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { ChartModule } from 'angular2-chartjs';
import { NbButtonModule, NbCardModule, NbDatepickerModule, NbListModule, NbStepperModule, NbTabsetModule } from '@nebular/theme';

import { ThemeModule } from '../../@theme/theme.module';
import { ShareIconsModule } from 'ngx-sharebuttons/icons';

import { ChartsRoutingModule, routedComponents } from './charts-routing.module';
import { ChartjsBarComponent } from './chartjs/chartjs-bar.component';
import { ChartjsLineComponent } from './chartjs/chartjs-line.component';
import { ChartjsPieComponent } from './chartjs/chartjs-pie.component';
import { ChartjsMultipleXaxisComponent } from './chartjs/chartjs-multiple-xaxis.component';
import { ChartjsBarHorizontalComponent } from './chartjs/chartjs-bar-horizontal.component';
import { ChartjsRadarComponent } from './chartjs/chartjs-radar.component';
import { D3BarComponent } from './d3/d3-bar.component';
import { D3LineComponent } from './d3/d3-line.component';
import { D3PieComponent } from './d3/d3-pie.component';
import { D3AreaStackComponent } from './d3/d3-area-stack.component';
import { D3PolarComponent } from './d3/d3-polar.component';
import { D3AdvancedPieComponent } from './d3/d3-advanced-pie.component';
import { EchartsLineComponent } from './echarts/echarts-line.component';
import { EchartsPieComponent } from './echarts/echarts-pie.component';
import { EchartsBarComponent } from './echarts/echarts-bar.component';
import { EchartsMultipleXaxisComponent } from './echarts/echarts-multiple-xaxis.component';
import { EchartsAreaStackComponent } from './echarts/echarts-area-stack.component';
import { EchartsBarAnimationComponent } from './echarts/echarts-bar-animation.component';
import { EchartsRadarComponent } from './echarts/echarts-radar.component';
import { TreeTableModule } from 'primeng/treetable';
import { NgScrollbarModule, NG_SCROLLBAR_OPTIONS } from 'ngx-scrollbar';
import { TrendModule } from 'ngx-trend';
import { MyfeedsComponent } from './myfeeds/myfeeds.component';
import {CardModule} from 'primeng/card';
import { TimelineComponent } from './timeline/timeline.component';
import { EjbComponent } from './ejb/ejb.component';
import { TopicssharingComponent } from './topicssharing/topicssharing.component';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { MyassignmentComponent } from './myassignment/myassignment.component';
import {CalendarModule} from 'primeng/calendar';
import {PickListModule} from 'primeng/picklist';
import { TopicsService } from '../tables/services/topicss.service';
import { EngineComponent } from './engine/engine.component';

import {  MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import {SplitterModule} from 'primeng/splitter';
import { UserEngagementChartsComponent } from './UserEngagementCharts/UserEngagementCharts.component';
import { HighchartsChartModule } from 'highcharts-angular';
import {ThreedimensionchartComponent} from './threedimensionchart/threedimensionchart.component'

const components = [
  ChartjsBarComponent,
  NgTrendComponent,
  ChartjsLineComponent,
  ChartjsPieComponent,
  ChartjsMultipleXaxisComponent,
  ChartjsBarHorizontalComponent,
  ChartjsRadarComponent,
  D3BarComponent,
  D3LineComponent,
  D3PieComponent,
  D3AreaStackComponent,
  D3PolarComponent,
  D3AdvancedPieComponent,
  EchartsLineComponent,
  EchartsPieComponent,
  EchartsBarComponent,
  EchartsMultipleXaxisComponent,
  EchartsAreaStackComponent,
  EchartsBarAnimationComponent,
  EchartsRadarComponent,
  TopicsSimilarityComponent,
  MyfeedsComponent,
  TimelineComponent,
  TopicssharingComponent,
  UserEngagementChartsComponent,
  StockchartComponent,
  ThreedimensionchartComponent,
  TimeseriesComponent,
  ];

@NgModule({
  imports: [
    ThemeModule,
    NbTabsetModule,
    ChartsRoutingModule,
    NgxEchartsModule,
    NgxChartsModule,
    MatTabsModule,
    TimelineModule,
    NbCardModule,
    NbButtonModule,
    NbListModule,
    NbStepperModule,
    CardModule,
    MatIconModule,
    MatCardModule,
    MatSelectModule,
    NgScrollbarModule,
    ScrollingModule,
    TrendModule,
    ChartModule,
    NbCardModule,
    TreeTableModule,
    CalendarModule,
    ShareIconsModule,
    InfiniteScrollModule,
    NbDatepickerModule,
    PickListModule,
    FormsModule,
    MatListModule,
    MatChipsModule,
    SplitterModule,
    ButtonModule,
    HighchartsChartModule,
      ],
  declarations: [...routedComponents, ...components, EjbComponent,  TopicssharingComponent, MyassignmentComponent, 
    EngineComponent,], providers: [MyLearningsService,NewsService,TopicsService],
})
export class ChartsModule {


}
