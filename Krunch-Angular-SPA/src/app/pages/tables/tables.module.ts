import { WordcloudComponent } from './wordcloud/wordcloud.component';
import { MatRadioModule } from '@angular/material/radio';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTableModule } from '@angular/material/table';
import { TopicWordCloudService } from './services/wordcloud.service ';
import { TopicstickerComponent } from './topicsticker/topicsticker.component';
import { NgxNewstickerAlbeModule } from 'ngx-newsticker-albe';
import { NodeService } from './../../service/nodeservice';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA, Component, OnInit} from '@angular/core';
import { NbCardModule, NbIconModule, NbInputModule, NbTreeGridModule, NbSelectModule, NbTabsetModule ,NbRadioModule} from '@nebular/theme';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ThemeModule } from '../../@theme/theme.module';
import { TablesRoutingModule, routedComponents } from './tables-routing.module';
import {DataViewModule} from 'primeng/dataview';
import {PanelModule} from 'primeng/panel';
import {InputTextModule} from 'primeng/inputtext';
import {RatingModule} from 'primeng/rating';
import {ButtonModule} from 'primeng/button';
import {DropdownModule} from 'primeng/dropdown';
import {TabViewModule} from 'primeng/tabview';
import { TreeTableModule } from 'primeng/treetable';
import { ToastModule } from 'primeng/toast';
import { DialogModule } from 'primeng/dialog';
import {TableModule, TableService} from 'primeng/table';

import { YouTubePlayerModule } from '@angular/youtube-player';
import { NgxsModule } from '@ngxs/store';
import { ShareButtonsModule } from 'ngx-sharebuttons/buttons';
import { ShareIconsModule } from 'ngx-sharebuttons/icons';

import { TopicsService } from './services/topicss.service';
import { NgScrollbarModule, NG_SCROLLBAR_OPTIONS } from 'ngx-scrollbar';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { NgTickerModule } from 'ng-ticker';
import { NgMarqueeModule } from 'ng-marquee';
import {AutoCompleteModule} from 'primeng/autocomplete';

import { TagCloudModule } from 'angular-tag-cloud-module';
import { ToptrendsComponent } from './toptrends/toptrends.component';

@NgModule({
  imports: [
    AutoCompleteModule,   
    NbCardModule,
    NbTreeGridModule,
    NbIconModule,
    NbInputModule,
    NbSelectModule,
    NbTabsetModule,
    NgSelectModule,
    NbRadioModule,
    FormsModule,
    ThemeModule,
    TableModule,
    TablesRoutingModule,
    Ng2SmartTableModule,
    DataViewModule,
    TreeTableModule,
    PanelModule,
    YouTubePlayerModule,
    DropdownModule,
    TabViewModule,
    InputTextModule,
    RatingModule,
    ToastModule,
    MatTableModule,
    MatTabsModule,
    MatRadioModule,
    MatIconModule,
    ReactiveFormsModule,
    DialogModule,
    NgScrollbarModule,
    ScrollingModule,
    NgxNewstickerAlbeModule,
    NgTickerModule,
    TagCloudModule,
    NgMarqueeModule,
    ShareButtonsModule.withConfig({
      debug: true,
    }),
    ShareIconsModule,
    ButtonModule, NgxsModule.forRoot([
    ])  ], providers: [TopicsService, TopicWordCloudService,NodeService,TableService],
  declarations: [
    ...routedComponents,TopicstickerComponent,WordcloudComponent,ToptrendsComponent
  ],
})
export class TablesModule { }
