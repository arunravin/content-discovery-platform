import { Component } from '@angular/core';

@Component({
  selector: 'ngx-footer',
  styleUrls: ['./footer.component.scss'],
  template: `
  
  <div class="ui-g-12">
   


    <div class="ui-g-6">Copyright 2021 - All rights reserved Krunch
     
     <span style="padding-left:800px;">
     Privacy Policy | Terms of Service
    </span>
    
  </div>

    
    <div class="ui-g-6"></div>

    </div>
<!--
    <div class="socials">

      
      
      <a href="#" target="_blank" class="ion ion-social-github"></a>
      <a href="#" target="_blank" class="ion ion-social-facebook"></a>
      <a href="#" target="_blank" class="ion ion-social-twitter"></a>
      <a href="#" target="_blank" class="ion ion-social-linkedin"></a>

    </div>
    -->
  `,
})
export class FooterComponent {
}
