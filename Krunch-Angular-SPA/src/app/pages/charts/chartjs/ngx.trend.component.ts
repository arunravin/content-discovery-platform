import { HttpClient } from '@angular/common/http';
import { AccountService } from '../../../account/services/account.service';
import { Component, OnDestroy } from '@angular/core';
import { NbThemeService, NbColorHelper } from '@nebular/theme';
import { environment } from '../../../../environments/environment';
import { TrendModule } from 'ngx-trend';

@Component({
  selector: 'ngx-chartjs-trend',
  template: `
    <ngx-trend [height]="341" 
        [smooth]="true" strokeWidth="10" 
        [gradient]="['#0FF', '#F0F', '#FF0']"
        [autoDraw]="true"  [autoDrawDuration]="3000"  autoDrawEasing="ease-in"
        [data]="data"></ngx-trend>
      `,
})
export class NgTrendComponent  {
  data: any;
  username;
  apiURL: string = environment.apiUrl+'/v1/learningjourney/useractivity'; 
  queryUrl: string = '?userName=';
 
  constructor(private userService: AccountService,private http: HttpClient) {

      this.username = this.userService.userValue.username;
      this.http.get<any>(this.apiURL + this.queryUrl + this.username).subscribe(datafs => {
        this.data = datafs
        
    })
   
  
   
  }

  
}
