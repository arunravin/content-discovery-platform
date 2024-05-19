package com.auth.security.helios.service;

import com.auth.security.helios.comm.User;
import com.auth.security.helios.entity.UserLogin;


public interface AuthService {

    UserLogin register( UserLogin userToAdd );
    User login( String username, String password );
}
