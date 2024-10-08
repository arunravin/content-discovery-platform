import { Component } from '@angular/core';

@Component({
  selector: 'ngx-one-column-layout',
  styleUrls: ['./one-column.layout.scss'],
  template: `
    <nb-layout >
      <nb-layout-header fixed>
        <ngx-header ></ngx-header>
      </nb-layout-header>

      
<!--
      <nb-sidebar class="menu-sidebar" tag="menu-sidebar" responsive>
        <ng-content select="nb-menu"></ng-content>
      </nb-sidebar>

       <nb-layout-column class="mini">
     
      </nb-layout-column>
-->    
     


      <nb-layout-column class="medium" window-mode='false' >
        <ng-content select="router-outlet"></ng-content>
      </nb-layout-column>

      <!--
      <nb-layout-column class="small">

       
   
      </nb-layout-column>
-->
     

      <nb-layout-footer fixed>
        <ngx-footer></ngx-footer>
      </nb-layout-footer>
    </nb-layout>
  `,
})
export class OneColumnLayoutComponent {}
