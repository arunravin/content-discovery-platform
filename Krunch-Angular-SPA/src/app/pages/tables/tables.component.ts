import { NbIconLibraries } from '@nebular/theme';
import { Component } from '@angular/core';

@Component({
  selector: 'ngx-tables',
  template: `<router-outlet></router-outlet>`,
})
export class TablesComponent {

  constructor(private iconLibraries: NbIconLibraries){

    this.iconLibraries.registerFontPack('font-awesome', { iconClassPrefix: 'fa' });
  }
}
