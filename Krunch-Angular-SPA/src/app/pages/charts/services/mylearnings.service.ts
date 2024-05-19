import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';
import { environment } from './../../../../environments/environment';

@Injectable()
export class MyLearningsService {

  apiURL: string = environment.apiUrl+'/v1/learningjourney/research'; 
  apiAnalyticsURL: string = environment.apiUrl+'v1/analytics/search/trends'; 
  queryUrl: string = '?userName=';
  recommendationsApiURL: string = environment.apiUrl+'/v1/learningjourney/recommendations';
  recommendationQueryUrl: string = '?topicTitle=';

  constructor(private http: HttpClient) { }
  
  getReseacrhTopics(topic): Observable<any>{
    let topics;
    //console.log("Research Topics Service Invoked ...");
    return this.http.get(this.apiURL + this.queryUrl + topic).
    pipe(map((res: Response) => { 
      topics = res;
        const total = topics.length;
       // console.log("Inside Response ..." +topics );
        //offset and limit will be done by server side but currently we don't have our own server. So this is done here.
        return {topics: topics.slice(0, 5000 ), total: total};
    })); 
  }

  getSearchTrends(userName): Observable<any>{
    let topics;
    //console.log("Research Topics Service Invoked ...");
    return this.http.get(this.apiAnalyticsURL + this.queryUrl + userName).
    pipe(map((res: Response) => { 
      topics = res;
        const total = topics.length;
       // console.log("Inside Response ..." +topics );
        //offset and limit will be done by server side but currently we don't have our own server. So this is done here.
        return {topics: topics.slice(0, 5000 ), total: total};
    })); 
  }

  refreshReseacrhTopics(topic): Observable<any>{
    let topics;
    //console.log("Research Topics Service Invoked ...");
    return this.http.get(this.apiURL + this.queryUrl + '$'+topic).
    pipe(map((res: Response) => { 
      topics = res;
        const total = topics.length;
       // console.log("Inside Response ..." +topics );
        //offset and limit will be done by server side but currently we don't have our own server. So this is done here.
        return {topics: topics.slice(0, 5000 ), total: total};
    })); 
  }

  getChildNodeTopics(topic): Observable<any>{
    let topics;
    //console.log("Child Node Topics Service Invoked ...");
    return this.http.get(this.recommendationsApiURL + this.recommendationQueryUrl + topic).
    pipe(map((res: Response) => { 
      topics = res;
        const total = topics.length;
       // console.log("Inside Response ..." +topics );
        //offset and limit will be done by server side but currently we don't have our own server. So this is done here.
        return {topics: topics.slice(0, 5000 ), total: total};
    })); 
  }

}



