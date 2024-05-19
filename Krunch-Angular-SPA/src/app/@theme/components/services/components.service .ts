import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';
import { environment } from '../../../../environments/environment.prod';

@Injectable()
export class ComponentsService {

  apiURL: string = environment.apiUrl+'/v1/analytics/search/keywords'; 
  queryUrl: string = '?userName=';
   constructor(private http: HttpClient) { }
  
   
 getSearchKeywords(): Observable<any>{
  
  let topics;
 // console.log("Research Topics Service Invoked ...");
  return this.http.get(this.apiURL).
  pipe(map((res: Response) => { 
    topics = res;
      const total = topics.length;
     // console.log("Inside Response ..." +topics );
      //offset and limit will be done by server side but currently we don't have our own server. So this is done here.
      return {topics: topics.slice(0, 5000 ), total: total};
  })); 
}

}
