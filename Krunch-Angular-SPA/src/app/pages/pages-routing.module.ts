import { WordcloudComponent } from './wordcloud/wordcloud.component';
//import { ProfileComponent } from './profile/profile.component';

import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { SmartTableComponent } from './tables/smart-table/smart-table.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [

    {
      path: 'home',
      component: SmartTableComponent,
    },
    {
      path: 'profile',
      component: ProfileComponent,
    },
    {
      path: 'wordcloud',
      component: WordcloudComponent,
    },
    {
      path: 'topics',
      loadChildren: () => import('./tables/tables.module')
        .then(m => m.TablesModule),
    },
    {
      path: 'mylearning',
      loadChildren: () => import('./charts/charts.module')
        .then(m => m.ChartsModule),
    },
    {
      path: '',
      redirectTo: 'explore/mylearning',
      pathMatch: 'full',
    },
    {
      path: '**',
      component: SmartTableComponent,
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
