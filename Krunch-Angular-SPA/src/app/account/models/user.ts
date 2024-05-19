import { Observable } from 'rxjs';

export interface User2 {
    id: string;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    token: string;
}


export class User {
    id: string;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    token: string;
    provider: string;

    
}

export class UserLogin {
    username: string;
    password: string;
}

export class User1 {
    id: string;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    token: string;
    provider: string;

    
}