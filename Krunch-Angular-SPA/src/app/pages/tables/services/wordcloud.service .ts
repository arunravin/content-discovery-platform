import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';
import { environment } from './../../../../environments/environment';

@Injectable()
export class TopicWordCloudService {

  apiURL: string = environment.apiUrl+'/v1/topics/wordcloud'; 
  apiSearchURL: string = environment.apiUrl+'/v1/topics/wordcloud/keyword'; 
  apiPersonSearchURL: string = environment.apiUrl+'/v1/topics/wordcloud/keyword/person'; 
  apiURLPerson: string = environment.apiUrl+'/v1/topics/wordcloud/person'; 
   queryUrl: string = '?topicName=';
  
  constructor(private http: HttpClient) { }
  

getWordCloudTopics(topic): Observable<any>{
  let topics;
  //console.log("Topics WordCloud Service Invoked ...");
  return this.http.get(this.apiURL + this.queryUrl + topic).
  pipe(map((res: Response) => { 
    topics = res;
      const total = topics.length;
      return {topics: topics.slice(0, 5000 ), total: total};
  })); 
}

getWordCloudSearchTopics(topic): Observable<any>{
  let topics;
  //console.log("Topics WordCloud Search Service Invoked ...");
  return this.http.get(this.apiSearchURL + this.queryUrl + topic).
  pipe(map((res: Response) => { 
    topics = res;
      const total = topics.length;
      return {topics: topics.slice(0, 5000 ), total: total};
  })); 
}


getPersonCloudSearchTopics(topic): Observable<any>{
  let topics;
  //console.log("Topics Person WordCloud Search Service Invoked ...");
  return this.http.get(this.apiPersonSearchURL + this.queryUrl + topic).
  pipe(map((res: Response) => { 
    topics = res;
      const total = topics.length;
      return {topics: topics.slice(0, 5000 ), total: total};
  })); 
}

getPersonCloudTopics(topic): Observable<any>{
  let topics;
  //console.log("Topics WordCloud Service Invoked ...");
  return this.http.get(this.apiURLPerson + this.queryUrl + topic).
  pipe(map((res: Response) => { 
    topics = res;
      const total = topics.length;
      return {topics: topics.slice(0, 5000 ), total: total};
  })); 
}

}
