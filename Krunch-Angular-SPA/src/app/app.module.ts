import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { environment } from './../environments/environment';

import { ErrorInterceptor } from './interceptors/error.interceptor';
import { JwtInterceptor } from './interceptors/jwt.interceptor';
import { BrowserModule } from '@angular/platform-browser';
import { NgMarqueeModule } from 'ng-marquee';
import { LoginComponent } from './account/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CoreModule } from './@core/core.module';
import { ThemeModule } from './@theme/theme.module';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { AngularMaterialModule } from './angular-material.module';
import { FormsModule , ReactiveFormsModule } from '@angular/forms';
import { ToasterModule } from 'angular2-toaster';
import {DataViewModule} from 'primeng/dataview';
import { TreeTableModule } from 'primeng/treetable';
import {PanelModule} from 'primeng/panel';
import {InputTextModule} from 'primeng/inputtext';
import {RatingModule} from 'primeng/rating';
import {ButtonModule} from 'primeng/button';
import {DropdownModule} from 'primeng/dropdown';
import {TabViewModule} from 'primeng/tabview';
import { NgxsModule } from '@ngxs/store';
import { YouTubePlayerModule } from '@angular/youtube-player';
import { NgxNewstickerAlbeModule } from 'ngx-newsticker-albe';
import { NgTickerModule } from 'ng-ticker';
import { TrendModule } from 'ngx-trend';
import {TableModule} from 'primeng/table';
import {  GoogleLoginProvider,AmazonLoginProvider,SocialLoginModule, SocialAuthServiceConfig,  FacebookLoginProvider,MicrosoftLoginProvider} from 'angularx-social-login';
import { NgxHotjarRouterModule, NgxHotjarModule } from 'ngx-hotjar';
import {
  NbChatModule,
  NbDatepickerModule,
  NbDialogModule,
  NbMenuModule,
  NbSidebarModule,
  NbToastrModule,
  NbWindowModule,NbThemeModule,NbSelectComponent, NbCardModule,
} from '@nebular/theme';

import { EventBrokerModule } from 'ng-event-broker';
import { TagCloudModule } from 'angular-tag-cloud-module';
import { ScrollPanel } from 'primeng/scrollpanel';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [AppComponent, LoginComponent ],
  imports: [
    FormsModule,
    SocialLoginModule,
    ReactiveFormsModule,
    AngularMaterialModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatToolbarModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    TrendModule,
    AppRoutingModule,
    EventBrokerModule,
    DataViewModule,
    TreeTableModule,
    MatButtonModule,
    TableModule,
    PanelModule,
    DropdownModule,
    TabViewModule,
    InputTextModule,
    RatingModule,
    ButtonModule,
    TagCloudModule,
    YouTubePlayerModule,
    NgxNewstickerAlbeModule,
    NgTickerModule,
    NbCardModule,
    NgxHotjarModule.forRoot(environment.hotjar),
    NgxHotjarRouterModule,
    NgMarqueeModule,
    ToasterModule.forRoot(),
    NgxWebstorageModule.forRoot(),
    NbSidebarModule.forRoot(),
    NbMenuModule.forRoot(),
    NbDatepickerModule.forRoot(),
    NbDialogModule.forRoot(),
    NbWindowModule.forRoot(),
    NbToastrModule.forRoot(),
    NbChatModule.forRoot({
      messageGoogleMapKey: 'AIzaSyA_wNuCzia92MAmdLRzmqitRGvCF7wCZPY',
    }),
    CoreModule.forRoot(),
    ThemeModule.forRoot(),
    NgxsModule.forRoot([
     
    ]),
   
  ],schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  providers: [       { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

  { provide: 'SocialAuthServiceConfig',
    useValue: {
      autoLogin: false,
      providers: [
        {
          id: GoogleLoginProvider.PROVIDER_ID,
          provider: new GoogleLoginProvider(
            '1057299260221-chm180t098k456t95ataksdojimu3ld6.apps.googleusercontent.com'
          )
        },
        {
          id: FacebookLoginProvider.PROVIDER_ID,
          provider: new FacebookLoginProvider('755909052006862')
        },
        {
          id: AmazonLoginProvider.PROVIDER_ID,
          provider: new AmazonLoginProvider('amzn1.application-oa2-client.eb72a9559ad44e3989d3c1ea4f6bee55')
        },
        {
          id: MicrosoftLoginProvider.PROVIDER_ID,
          provider: new MicrosoftLoginProvider('35714b01-67fa-4dca-bfe6-ee6bbeff1c55')
        },
        {
          id: MicrosoftLoginProvider.PROVIDER_ID,
          provider: new MicrosoftLoginProvider('35714b01-67fa-4dca-bfe6-ee6bbeff1c55')
        }
      ]
    } as SocialAuthServiceConfig,
  }


    
],
  bootstrap: [AppComponent],
})
export class AppModule {
}
