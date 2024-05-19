import { User } from './../@core/data/users';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AccountService, AlertService } from './services';
import { SocialAuthService } from "angularx-social-login";
import { FacebookLoginProvider, GoogleLoginProvider ,AmazonLoginProvider,
    MicrosoftLoginProvider} from "angularx-social-login";
import { SocialUser } from "angularx-social-login";

    @Component({
        selector: 'ngx-login',
        styleUrls: ['./login.component.scss'],
        templateUrl: './login.component.html',
      })
export class LoginComponent implements OnInit {

    form: FormGroup;
    loading = false;
    submitted = false;

    socialUsers: SocialUser;
    loggedIn: boolean;
    

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private accountService: AccountService,
        private alertService: AlertService,
        private authService: SocialAuthService,
    ) { 

       
    }

    ngOnInit() {
       // localStorage.clear;
        this.form = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

             
    }


    signInWithGoogle(): void {
        this.accountService.signInWithGoogle();

    }
    
    

      signInWithFB(): void {
        this.authService.signIn(FacebookLoginProvider.PROVIDER_ID);
      }

      signInWithMS(): void {
        this.authService.signIn(MicrosoftLoginProvider.PROVIDER_ID);
      }
    
      signInWithAmazon(): void {
        this.accountService.signInWithAmazon();
       // this.authService.signIn(AmazonLoginProvider.PROVIDER_ID);
      }
    
      signOut(): void {
        this.authService.signOut();
      }
    
    // convenience getter for easy access to form fields
    get f() { return this.form.controls; }

    onSubmit() {
        this.submitted = true;

        // reset alerts on submit
        this.alertService.clear();

        // stop here if form is invalid
        if (this.form.invalid) {
            return;
        }

        this.loading = true;
        this.accountService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe({
                next: () => {
                    // get return url from query parameters or default to home page
                    const returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
                    //this.router.navigateByUrl(returnUrl);
                  this.router.navigate(['/explore/topics/data/ai'],{ queryParams: { currentSelection: encodeURIComponent("Technology - AI")  } });
                   
                   //this.router.navigateByUrl('explore/mylearning/dashboard');
                   
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });
    }
}