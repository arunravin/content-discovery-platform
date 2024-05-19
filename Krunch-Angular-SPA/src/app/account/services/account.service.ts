import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { HttpClient, HttpParams } from "@angular/common/http";
import { BehaviorSubject, Observable } from "rxjs";
import { map } from "rxjs/operators";
import { HttpHeaders } from '@angular/common/http';
import { environment } from "./../../../environments/environment.prod";

import { SocialAuthService } from "angularx-social-login";
import { FacebookLoginProvider, GoogleLoginProvider, AmazonLoginProvider} from "angularx-social-login";
import { SocialUser } from "angularx-social-login";
import { User1 } from "./../models/user";
import { User } from "./../models/user";
import { UserLogin } from "./../models/user";

@Injectable({ providedIn: "root" })
export class AccountService {
  private userSubject: BehaviorSubject<User>;
  public user: Observable<User>;

  public user1: User1 = new User1();
  public userLogin: UserLogin = new UserLogin();

  socialUsers: SocialUser;
  loggedIn: boolean;
  postId: string;

 

  constructor(
    private router: Router,
    private http: HttpClient,
    private authService: SocialAuthService
  ) {
    var myObj = {
      user: "Arun",
      username: 31,
      firstname: "New York",
      lastname: "New York",
      token: "token",
    };
    //localStorage.setItem("user", JSON.stringify(myObj));
    this.userSubject = new BehaviorSubject<User>(
      JSON.parse(localStorage.getItem("user"))
    );
    this.user = this.userSubject.asObservable();
  }

  public get userValue(): User {
    return this.userSubject.value;
  }

  login(username, password) {
    //console.log("Account Service Login 12" + username);
    //console.log("Account Service Password" + password);

    return this.http
      .post<User>(
        environment.apiAuthUrl +
          "/authentication/login?username=" +
          username +
          "&password=" +
          password,
        { username: username, password: password }
      )
      .pipe(
        map((user) => {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem("user", JSON.stringify(user));
          //console.log("Local storage created ..");
          //console.log("Local Storage Item : " + localStorage.getItem("user"));
          this.userSubject.next(user);
          return user;
        })
      );
  }

  signInWithGoogle(): void {

    const headers= new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*');

    this.authService
      .signIn(GoogleLoginProvider.PROVIDER_ID)
      .then((socialUsers) => {
        this.user1.firstName = socialUsers.firstName;
        this.user1.lastName = socialUsers.lastName;
        this.user1.id = socialUsers.idToken;
        this.user1.token = socialUsers.authToken;
        this.user1.username = socialUsers.email;

        this.userLogin.username = socialUsers.email;
        this.userLogin.password = socialUsers.email;
        const body = JSON.stringify(this.userLogin);
       // console.log("Put Request Body: " + body);
        this.http
          .post<any>(environment.apiAuthUrl + "/authentication/register", body, { 'headers': headers })
          .subscribe((data) => (this.postId = data));
       // console.log("Response ID from Social Login User Update : " + this.postId );
        localStorage.setItem("user", JSON.stringify(this.user1));
        this.userSubject.next(this.user1);
       // console.log( "Social Login Local Storage Item : " + localStorage.getItem("user")      );
        //   this.accountService.saveGoogleSigninandRoute(this.socialUsers);

        this.router.navigateByUrl("explore/topics/data/ai");
      });
  }

  signInWithAmazon(): void {
    const headers= new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*');

   
    this.authService
      .signIn(AmazonLoginProvider.PROVIDER_ID)
      .then((socialUsers) => {
        this.user1.firstName = socialUsers.name;
        this.user1.id = socialUsers.idToken;
        this.user1.token = socialUsers.authToken;
        this.user1.username = socialUsers.email;

        this.userLogin.username = socialUsers.email;
        this.userLogin.password = socialUsers.email;
        const body = JSON.stringify(this.userLogin);
        console.log("Put Request Body: " + body);
        this.http
          .post<any>(environment.apiAuthUrl + "/authentication/register", body, { 'headers': headers })
          .subscribe((data) => (this.postId = data));
       // console.log(  "Response ID from Social Login User Update : " + this.postId  );
       

        localStorage.setItem("user", JSON.stringify(this.user1));

        //console.log("Amazon Social Login Local Storage Item : " +localStorage.getItem("user")        );
        //   this.accountService.saveGoogleSigninandRoute(this.socialUsers);
        this.userSubject.next(this.user1);
        this.router.navigateByUrl("explore/topics/data/cloud");
      });
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem("user");
    this.userSubject.next(null);
    this.router.navigate(["/account/login"]);
  }
}
