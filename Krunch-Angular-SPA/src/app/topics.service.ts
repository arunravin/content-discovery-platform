import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from './../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class TopicsService {

  
  
  apiURL: string = environment.apiUrl+'/v1/digitaltrends/topicsdata'; 
  reportApiURL: string = environment.apiUrl+'/v1/digitaltrends/topicsearch'; 
  queryUrl: string = '?topic=';

  fullSearchReportApiURL: string = environment.apiUrl+'/v1/digitaltrends/freetextsearch'; 
  fullSearchqueryUrl: string = '?freetext=';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private httpClient: HttpClient) { }
  
  public getData(topic: string){
    return this.httpClient.get<any[]>(this.apiURL + this.queryUrl + topic);
}

public getDatabyReportType(topic: string){
  return this.httpClient.get<any[]>(this.reportApiURL + this.queryUrl + topic);
}

public getDatabyFreeText(topic: string){
  return this.httpClient.get<any[]>(this.fullSearchReportApiURL + this.fullSearchqueryUrl + topic);
}

/**
  public getData(topic: string){
    t
    return this.httpClient.get<any[]>(`${this.apiURL}`);
}
 */

  
}
