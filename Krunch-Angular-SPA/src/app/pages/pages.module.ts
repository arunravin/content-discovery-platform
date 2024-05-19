import { CommonModule } from '@angular/common';

import { TopicWordCloudService } from './tables/services/wordcloud.service ';
import { DropdownModule } from 'primeng/dropdown';
import { NgSelectModule } from '@ng-select/ng-select';
import { WordcloudComponent } from './wordcloud/wordcloud.component';
import { NgModule ,CUSTOM_ELEMENTS_SCHEMA,NO_ERRORS_SCHEMA} from '@angular/core';
import { NbMenuModule, NbTabsetModule } from '@nebular/theme';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { PagesRoutingModule } from './pages-routing.module';

import { TagCloudModule } from 'angular-tag-cloud-module';
import { NgScrollbarModule, NG_SCROLLBAR_OPTIONS } from 'ngx-scrollbar';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { ProfileComponent } from './profile/profile.component';
import {ToggleButtonModule} from 'primeng/togglebutton';


@NgModule({
  imports: [
    PagesRoutingModule,
    NgScrollbarModule,
    ScrollingModule,
     ThemeModule,
    NbMenuModule,
    NgSelectModule,
    NbTabsetModule,
    DropdownModule,
    FormsModule,
    ReactiveFormsModule,
    ToggleButtonModule,
    CommonModule,
    TagCloudModule,
  ],schemas: [ CUSTOM_ELEMENTS_SCHEMA , NO_ERRORS_SCHEMA],
  providers: [TopicWordCloudService],
  declarations: [
    PagesComponent,WordcloudComponent,ProfileComponent
  ],
})
export class PagesModule {
}
