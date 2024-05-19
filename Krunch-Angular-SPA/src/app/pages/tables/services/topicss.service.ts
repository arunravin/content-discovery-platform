import { SearchKeyword } from './search';
import { Injectable } from '@angular/core';

import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';
import { environment } from './../../../../environments/environment';

@Injectable()
export class TopicsService {

  apiURL: string =  environment.apiUrl+'/v1/digitaltrends/topicsdata'; 
  trendingTopicsUrl: string = environment.apiUrl+'/v1/digitaltrends//toptrends'
  entitySearchApiURL: string = environment.apiUrl+'/v1/digitaltrends/topicentitysearch'; 
  queryUrl: string = '?topic=';
  postId: string;
  public searchKeyword: SearchKeyword = new SearchKeyword();
  
  apiKeyWordSearchURL: string =  environment.apiUrl+'/v1/analytics/keyword'; 
 
  

  constructor(private http: HttpClient) { }
  getComments(offset, limit): Observable<any>{
    let topics;
  //  console.log("Service Invoked ...");
    return this.http.get(environment.apiUrl+'/v1/digitaltrends/topicsdata?topic=cloud').
    pipe(map((res: Response) => {
      topics = res;
        const total = topics.length;
    //    console.log("Inside Response ..." +topics );
        //offset and limit will be done by server side but currently we don't have our own server. So this is done here.
        return {topics: topics.slice(0, 5000), total: total};
    }));
}

getVideos(topic): Observable<any>{
  let topics;
//  console.log("Service Invoked ...");
  return this.http.get(environment.apiUrl+'/v1/digitaltrends/videos?topic='+topic).
  pipe(map((res: Response) => {
    topics = res;
      const total = topics.length;
       return {topics: topics.slice(0, 1000), total: total};
  }));
}

getTopics(topic): Observable<any>{
  let topics;
  //console.log("Topics Service Invoked ...");
  return this.http.get(this.apiURL + this.queryUrl + topic).
  pipe(map((res: Response) => { 
    topics = res;
      const total = topics.length;
     // console.log("Inside Response ..." +topics );
      //offset and limit will be done by server side but currently we don't have our own server. So this is done here.
      return {topics: topics.slice(0, 5000 ), total: total};
  })); 
}

entitySearch(topic): Observable<any>{
  let topics;
  //console.log("Entity Search Service Invoked ..." +topic );
  return this.http.get(this.entitySearchApiURL + this.queryUrl + topic).
  pipe(map((res: Response) => { 
    topics = res;
      const total = topics.length;
    //  console.log("Inside Response ..." +topics );
      //offset and limit will be done by server side but currently we don't have our own server. So this is done here.
      return {topics: topics.slice(0, 5000 ), total: total};
  })); 
}

topTrendsSearch(topic): Observable<any>{
  let topTrends;
  console.log("topTrends Search Service Invoked ..." +topic );
  return this.http.get(this.trendingTopicsUrl + this.queryUrl + topic).
  pipe(map((res: Response) => { 
    topTrends = res;
      const total = topTrends.length;
    //  console.log("Inside Response ..." +topics );
      //offset and limit will be done by server side but currently we don't have our own server. So this is done here.
      return {topTrends: topTrends.slice(0, 25 ), total: total};
  })); 
}

postSearchKeywords(keyword , username){

//console.log("Post Search Keyword " + keyword);
//console.log("Post Search Username " + username);

  const headers= new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*');

    
    this.searchKeyword.username=username;
    this.searchKeyword.searchType='GS';
    this.searchKeyword.keyWord=keyword;

    const body = JSON.stringify(this.searchKeyword);

  this.http
  .post<any>(environment.apiUrl + "/v1/analytics/keyword", body, { 'headers': headers })
  .subscribe((data) => (this.postId = data));
//console.log("Response ID from Keyword Update : " + this.postId);
}

}
