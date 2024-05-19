import { HttpClient } from '@angular/common/http';
import { AccountService } from './../../account/services/account.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { environment } from './../../../environments/environment';
import { Customer } from  './customer';



@Component({
  selector: 'ngx-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  
  customer = new Customer();
  emailMessage: string;
  buttonSelectedColor="#0C0C0C";

  checked1: boolean = false;
  checked2: boolean = true;

  isEntrepreneur: boolean = false;
  isConsultant: boolean = false;
  isStrategist_Analyst: boolean = false;
  isSales_Marketing: boolean = false;
  isInvestmentProfessional: boolean = false;
  isOperations: boolean = false;
  isProductManager_UX: boolean = false;
  isOther: boolean = false;

  jobSeeking: boolean = false;
  brandBuilding: boolean = false;
  socialMedia: boolean = false;
  blogWriting: boolean = false;
  searchEngine: boolean = false;
  devOperations: boolean = false;
  prepareForMeeting: boolean = false;
  
  eMail: string;
  toggle = true;
  status = 'Enable'; 

  displayContinueButton: boolean = true;
  
  enableDisableRule(job) {
   //   this.toggle = !this.toggle;
   this.displayContinueButton= false;
      this.status = this.toggle ? 'Enable' : 'Disable';

      if(job === 'epr'){

        this.isEntrepreneur = !this.isEntrepreneur;

      } else if (job === 'cns'){
        this.isConsultant = !this.isConsultant;

      }else if (job === 'sa'){

        this.isStrategist_Analyst = !this.isStrategist_Analyst;
      }else if (job === 'sm'){

        this.isSales_Marketing = !this.isSales_Marketing;
      }else if (job === 'ip'){

        this.isInvestmentProfessional = !this.isInvestmentProfessional;
      }else if (job === 'ops'){
        this.isOperations = !this.isOperations;

      }else if (job === 'pm'){

        this.isProductManager_UX = !this.isProductManager_UX;
      }else if (job === 'ot'){

        this.isOther = !this.isOther;
      }

      console.log("Entrepreneuer : "+this.isEntrepreneur + " Consultant : "+ this.isConsultant + "  isStrategist_Analyst " + this.isStrategist_Analyst
                   + "  isSales_Marketing"+this.isSales_Marketing + " "+ "  isInvestmentProfessional " + this.isInvestmentProfessional
                   + "   isOperations"+this.isOperations + " "+ "  isProductManager_UX " + this.isProductManager_UX
                   +  "  Other"+this.isOther )

  }

  enableDisableforGoal(job) {
   // this.toggle = !this.toggle;
   this.displayContinueButton= false;
    this.status = this.toggle ? 'Enable' : 'Disable';

              if(job === 'brand'){
                this.brandBuilding = !this.brandBuilding;
                  } else if (job === 'social'){

                    this.socialMedia = !this.socialMedia;
                  }else if (job === 'blog'){
                    this.blogWriting = !this.blogWriting;

                  }else if (job === 'search'){
                    this.searchEngine = !this.searchEngine;

                  }else if (job === 'devops'){
                    this.devOperations = !this.devOperations;

                  }else if (job === 'job'){
                    this.jobSeeking = !this.jobSeeking;

                  }else if (job === 'meeting'){
                    this.prepareForMeeting = !this.prepareForMeeting;

                  }

                  console.log("Brand"+this.brandBuilding + " "+ "  Blog " + this.blogWriting  + "  Social"+this.socialMedia 
                  + "  Search"+this.searchEngine + " "+ "  DevOps " + this.devOperations
                   + " "+ "  isProductManager_UX " + this.isProductManager_UX
                  +  "  Job"+this.jobSeeking + "  meeting "+this.prepareForMeeting )
}


  professionButtonClicked(clr) {
     console.log(clr);
    
  }

  
  
 displayName: string;
  constructor( 
    private activatedRoute: ActivatedRoute , public router: Router ,
      private accountService: AccountService , private httpClient: HttpClient) {

        this.eMail = this.accountService.userValue.username;
 
        if(this.eMail != null) {

          this.displayName = this.eMail.match(/^([^@]*)@/)[1];
        }


   }

   userName;
   resId;

   postPreferences(){
    //console.log('Add To Queue *** ..'+ topicurl);
   
    //console.log("User Name  " + this.accountService.userValue.username);
     this.userName = this.accountService.userValue.username;


     /*console.log("Before Posting the Reuest" );

     this.resId=0;
     this.httpClient.post<any>( environment.apiUrl+ '/v1/digitaltrends/topics/addtoqueue', 
     { username: this.userName , }).subscribe(data => {
      this.resId = data;
      //console.log("Response data :  " + data)
  })
**/
this.resId=1
  if (this.resId == 1) 
    {
        alert("Thanks for updating the preferences. ");
        this.router.navigate(['/explore/topics/data/ai']);
    } 
   

     //console.log("After Posting the Request" );
   }

  ngOnInit() {
    
  }

 skipProfile(){

  this.router.navigate(['/explore/topics/data/ai']);
 }
  

}
