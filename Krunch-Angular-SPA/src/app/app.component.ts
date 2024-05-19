/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
import { Component, OnInit } from '@angular/core';
import { AnalyticsService } from './@core/utils/analytics.service';
import { SeoService } from './@core/utils/seo.service';
import {Events} from './event-broker/events.model';
import { EventBrokerService } from 'ng-event-broker';
import {NgxNewstickerAlbeModule} from 'ngx-newsticker-albe';
import { NbIconLibraries } from '@nebular/theme';
import { HostListener, ChangeDetectorRef } from '@angular/core';
import { NgxHotjarService } from 'ngx-hotjar';
@Component({
  selector: 'ngx-app',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {

  
  log: Array<Array<any>>;

  constructor(private analytics: AnalyticsService, private seoService: SeoService,
    private eventService: EventBrokerService,public hjService: NgxHotjarService,
    private cdr: ChangeDetectorRef ,private iconLibraries: NbIconLibraries) {

      this.iconLibraries.registerFontPack('font-awesome', { iconClassPrefix: 'fa' });
    
  }

  ngOnInit(): void {
    this.analytics.trackPageViews();
    this.seoService.trackCanonicalChanges();
    this.registerAppEvents();
  }

  private registerAppEvents() {
    this.eventService.registerEvent(Events.topicChanged);
    this.eventService.registerEvent(Events.loginSuccessful);
    this.eventService.registerEvent(Events.logout);
  }

  /*
 @HostListener('click')
  onClick() {
    try {
      console.log((window as any).hj.q);
      this.log = (window as any).hj.q;
      this.cdr.detectChanges();
    } catch (err) {
      console.error(err);
    }
  }
**/
}
