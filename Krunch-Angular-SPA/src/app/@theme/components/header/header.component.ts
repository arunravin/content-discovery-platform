import { ComponentsService } from './../services/components.service ';
import { ActivatedRoute, Router } from '@angular/router';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA, Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NbMediaBreakpointsService, NbMenuService, NbSidebarService, NbThemeService, NbMenuItem } from '@nebular/theme';
import {MegaMenuModule} from 'primeng/megamenu';
import { UserData } from '../../../@core/data/users';
import { LayoutService } from '../../../@core/utils';
import { map, takeUntil } from 'rxjs/operators';
import { Subject, Observable,of } from 'rxjs';
import { EventBrokerService } from 'ng-event-broker';
import {Events} from '../../../event-broker/events.model';
import {MegaMenuItem,MenuItem, PrimeIcons} from 'primeng/api';
import { color } from '@carbon/charts/configuration';

@Component({
  selector: 'ngx-header',
  styleUrls: ['./header.component.scss'],
  templateUrl: './header.component.html',
})
export class HeaderComponent implements OnInit, OnDestroy {

  private destroy$: Subject<void> = new Subject<void>();
  userPictureOnly: boolean = false;
  user: any;

  private route = ActivatedRoute;

  menuItems: MenuItem[];
  dashboard: MenuItem[];
 
  currentSelection: string;
  
  searchValue: string;
  menuDomainItems: MenuItem[];
  learningJourneyItems: MenuItem[];
  selectedItemNgModel: any;
  topicMenuitems: MenuItem[];
  topicDomainMenuitems: MenuItem[];
  disruptiveInnovationItems: MenuItem[];
  dashBoardMenuitems: MenuItem[];
  themes = [
    {
      value: 'default',
      name: 'Light',
    },
    {
      value: 'dark',
      name: 'Dark',
    },
    {
      value: 'cosmic',
      name: 'Cosmic',
    },
    {
      value: 'corporate',
      name: 'Corporate',
    },
  ]; 

  currentTheme = 'default';

  
  userMenu = [ 
    { title: 'Profile' },
    { title: 'Log out' } 
   ];

  domainMenu = [ { title: 'My Dashboard' , link:'/explore/mylearning/dashboard' , command: () => this.navigateTopic('design','Dashboard')} ,
  { title: 'My Group' }, ];

  constructor(private sidebarService: NbSidebarService,
              private menuService: NbMenuService,
              private themeService: NbThemeService,
              private userService: UserData,
              private componentsService: ComponentsService,
              private layoutService: LayoutService,
              private breakpointService: NbMediaBreakpointsService,
              private eventService: EventBrokerService,
              private router: Router,
              ) {
                this.filteredOptions$ = of(this.options);
             }

  ngOnInit() {


    this.componentsService.getSearchKeywords().subscribe(res => {
      this.options = res['topics'];
     // console.log("Search KeyWords ******************* : " + res['topics']);
    });
    
    this.filteredOptions$ = of(this.options);

    this.dashboard = [
      {
          label: 'Home',
          icon: 'pi pi-fw pi-home',
          items: [{
                  label: 'My Dashboard', 
                  icon: 'fa fa-tasks',
                  routerLink: '/explore/mylearning/dashboard'
              },
              {
                label: 'My Profile', 
                icon: 'fa fa-user',
              },
              {
                label: 'My Group', 
                icon: 'fa fa-users',
              }
          ]
      }  ];
    
      this.topicMenuitems = [
        {
            label: 'Technology Topics',
           // icon: PrimeIcons.BARS ,
            routerLink: '',
            items: [
              {label: '/AIML',command: () => this.navigateTopic('ai' , 'Technology - /AIML')},
              {label: '/API',command: () => this.navigateTopic('api','Technology - /API')},
              {label: '/Cyber Security',command: () => this.navigateTopic('cybersecurity','Technology - /Cyber Security')},
              {label: '/Data Analytics',command: () => this.navigateTopic('analytics','Technology - /Data Analytics')},
              {label: '/Design',command: () => this.navigateTopic('design','Technology - /Design')},
              {label: '/DevOps & SRE',command: () => this.navigateTopic('devops','Technology - /DevOps SRE')},
              {label: '/Digital',command: () => this.navigateTopic('digital','Technology - /Digital')},
              {label: '/Digital Platforms',command: () => this.navigateTopic('platform','Technology - /Digital Platforms')},
              {label: '/Kubernetes & Openshift',command: () => this.navigateTopic('container platform','Technology - /Kubernete & Openshift')},
              {label: '/LCNC',command: () => this.navigateTopic('lcnc','Technology - /LCNC')},
              {label: '/Microservices',command: () => this.navigateTopic('microservices','Technology - /Microservices')},
              {label: '/Public Cloud',command: () => this.navigateTopic('cloud','Technology - Public Cloud')},
              {label: '/SAAS',command: () => this.navigateTopic('saas','Technology - SAAS')},
             
            ]
        }  ];

        this.topicDomainMenuitems = [
          {
              label: 'Industry Topics',
            //  icon: PrimeIcons.BARS ,
              routerLink: '',
              items: [
                {label: '/Agriculture',command: () => this.navigateTopic('agritech','Industry - Agriculture')},
                {label: '/Banking',command: () => this.navigateTopic('banking','Industry - Banking')},  
                {label: '/Crypto Currency',command: () => this.navigateTopic('cryptocurrency','Industry - Crypto Currency')},
                {label: '/Education',command: () => this.navigateTopic('education','Industry - Education')},
                {label: '/HealthCare',command: () => this.navigateTopic('healthcare','Industry - HealthCare')},
                {label: '/Insurance',command: () => this.navigateTopic('insurtech','Industry - Insurance')},
                {label: '/Regulatory',command: () => this.navigateTopic('regtech','Industry - Regulatory')},
               
                ]
          }  ];

          this.disruptiveInnovationItems = [
            {
                label: 'Disruptive Innovation',
              //  icon: PrimeIcons.BARS ,
                routerLink: '',
                items: [
                  {label: '/Deep Learning',command: () => this.navigateTopic('deep learning','/Disruptive Innovation - Deep Learning')},
                  {label: '/Re-Invention of the Data Center',command: () => this.navigateTopic('data center','/Disruptive Innovation - Re-Invention of the Data Center')},
                  {label: '/Virtual Worlds',command: () => this.navigateTopic('virtual worlds','/Disruptive Innovation - Virtual Worlds')},
                  {label: '/BitCoin Fundamentals' ,command: () => this.navigateTopic('bitcoin fundamentals','/Disruptive Innovation - BitCoin Fundamentals')},
                  {label: '/Bitcoin Preparing for Instituitions',command: () => this.navigateTopic('bitcoin company','/Disruptive Innovation - Bitcoin Preparing for Instituitions')},
                  {label: '/Electric Vehicles',command: () => this.navigateTopic('electric vehicles','/Disruptive Innovation - Electric Vehicles')},
                  {label: '/Automation',command: () => this.navigateTopic('automation','/Disruptive Innovation - Automation')},
                  {label: '/Autonomous Ride-Hailing',command: () => this.navigateTopic('autonomous ride','/Disruptive Innovation - Autonomous Ride-Hailing')},
                  {label: '/Delivery Drones',command: () => this.navigateTopic('delivery drones','/Disruptive Innovation - Delivery Drones')},
                  {label: '/Orbital Aerospace',command: () => this.navigateTopic('orbital aerospace','/Disruptive Innovation - Orbital Aerospace')},
                  {label: '/3D Priniting',command: () => this.navigateTopic('3dprinting','/Disruptive Innovation - 3D Priniting')},
                  {label: '/Long Read Sequencing',command: () => this.navigateTopic('longread sequencing','/Disruptive Innovation - Long Read Sequencing')},
                  {label: '/Multi-Cancer Screening',command: () => this.navigateTopic('cancer screening','/Disruptive Innovation - Multi-Cancer Screening')},
                  {label: '/Cell and Gene Therapy: Generation2',command: () => this.navigateTopic('gene therapy','/Disruptive Innovation - Cell and Gene Therapy: Generation2')},
            
                  ]
            }  ];
     
          this.dashBoardMenuitems = [
            {
                label: 'DashBoard', routerLink: '/explore/mylearning/dashboard',
                
            }  ];
       



    //console.log('Header component NG On Init Invoked ..')

    this.currentTheme = this.themeService.currentTheme;
    this.userService.getUsers()
      .pipe(takeUntil(this.destroy$))
      .subscribe((users: any) => this.user = users.nick);

    const { xl } = this.breakpointService.getBreakpointsMap();
    this.themeService.onMediaQueryChange()
      .pipe(
        map(([, currentBreakpoint]) => currentBreakpoint.width < xl),
        takeUntil(this.destroy$),
      )
      .subscribe((isLessThanXl: boolean) => this.userPictureOnly = isLessThanXl);

    this.themeService.onThemeChange()
      .pipe(
        map(({ name }) => name),
        takeUntil(this.destroy$),
      )
      .subscribe(themeName => this.currentTheme = themeName);

      this.menuService.onItemClick().subscribe((event) => {
        if (event.item.title === 'Log out') {
        //  console.log('logout clicked ....' );
          this.router.navigate(['']);
        }
      });

      this.menuService.onItemClick().subscribe((event) => {
        if (event.item.title === 'Profile') {
          console.log('Profile clicked ....' );
          this.router.navigate(['explore/profile']);
        }
      });

 }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }

  
  navigateHome() {
   // this.router.navigate(['/explore/mylearning/dashboard']);
   this.router.navigate(['/explore/topics/data/ai']);

    return false;
  }

  profileClicked() {
    this.router.navigate(['explore/topics/videos']);
    return false;
  }

  logOut() {
    localStorage.setItem('user', '');
    localStorage.clear();
    this.router.navigate(['login']);
    return false;
  }


  
  clicked(event) {
    //console.log("Mega Menu Clicked")
    this.router.navigate(['/explore/mylearning/journey']);
    return false;
  }
 
  globalSearch(searchValue){

   // this.options=null;
     console.log("Search " + searchValue);
    if(this.searchValue!=null){
    
      this.router.navigate(['/explore/topics/data'],{ queryParams: { searchValue: this.searchValue  } });
  
    }
    console.log("Routed to " + this.searchValue  );
    this.options = null;
  }

 
  

  options: string[];
  filteredOptions$: Observable<string[]>;

  @ViewChild('autoInput') input;

  onChange() {
    
    if(this.searchValue!=null){

       this.filteredOptions$ = this.getFilteredOptions(this.searchValue);
    } else{
      this.filteredOptions$ = this.getFilteredOptions(this.searchValue);
    }
  }

  private filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    return this.options.filter(optionValue => optionValue.toLowerCase().includes(filterValue));
  }

  getFilteredOptions(value: string): Observable<string[]> {
    return of(value).pipe(
      map(filterString => this.filter(filterString)),
    );
  }


  onSelectionChange($event) {
     // this.filteredOptions$ = this.getFilteredOptions($event);
    //  this.filteredOptions$ = of(this.filter(this.searchValue));
    console.log($event);
    this.globalSearch(this.searchValue);
    this.options = null;
     // console.log("On Selection Change :"+this.searchValue);
  }

  menuClicked(event){
    //console.log("Menu Clicked : " )

    this.searchValue=null;
  }

  navigateTopic(path: string , currentSelection: string){

   // console.log("Menu Clicked ................"+path)
   // console.log("Current Selection ................"+currentSelection)
   // this.searchValue=null;
    this.currentSelection=encodeURIComponent(currentSelection);
    this.router.navigate(['/explore/topics/data/'+path],{ queryParams: { currentSelection: this.currentSelection  } });
   

  }
  
}
