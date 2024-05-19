import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TablesComponent } from './tables.component';
import { SmartTableComponent } from './smart-table/smart-table.component';
import {TopicdataviewComponent} from '../tables/topicdataview/topicdataview.component';
import { ToptrendsComponent } from './toptrends/toptrends.component';

const routes: Routes = [{
  path: '',
  component: TablesComponent,
  children: [
    {
      path: 'videos',
      component: SmartTableComponent,
    },
    {
      path: 'data',
      component: TopicdataviewComponent,
    },
      {
      path: 'data/businesstech',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/digital',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/insurtech',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/digitalleaders',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/gamechangers',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/ai',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/devops',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/banking',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/saas',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/lcnc',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/cloud',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/leaders',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/techinvest',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/cybersecurity',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/ai',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/bigdata',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/agritech',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/design',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/healthcare',
      component: TopicdataviewComponent,
    },
       {
      path: 'data/analytics',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/regtech',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/platform',
      component: TopicdataviewComponent,
    },
   {
      path: 'data/api',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/cloud',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/microservices',
      component: TopicdataviewComponent,
    },  
    {
      path: 'data/container platform',
      component: TopicdataviewComponent,
    },    
    {
      path: 'data/cryptocurrency',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/education',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/datascience',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/nlp',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/machinelearning',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/computervision',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/nosql',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/fullstack',
      component: TopicdataviewComponent,
    },

    {
      path: 'data/docker',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/startup',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/entrepreneur',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/covid',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/worldeconomicforum',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/docker',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/deep learning',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/data center',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/bitcoin fundamentals',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/bitcoin company',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/automation',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/autonomous ride',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/delivery drones',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/orbital aerospace',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/3dprinting',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/longread sequencing',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/cancer screening',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/gene therapy',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/electric vehicles',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/virtual worlds',
      component: TopicdataviewComponent,
    },
    {
      path: 'data/toptrends',
      component: ToptrendsComponent,
    },
   
    
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TablesRoutingModule { }

export const routedComponents = [
  TablesComponent,
  SmartTableComponent,
  TopicdataviewComponent,
  ToptrendsComponent, 
 ];
