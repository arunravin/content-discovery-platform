package com.auth.security.helios.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth.security.helios.comm.User;
import com.auth.security.helios.entity.UserLogin;
import com.auth.security.helios.service.AuthService;
import com.fasterxml.jackson.annotation.JsonIgnore;


@RestController
@CrossOrigin(origins = "http://localhost:9080 , http;//localhost:4200")
public class KrunchAuthController {

    @Autowired
    private AuthService authService;

    Log log = LogFactory.getLog(getClass());

    
    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:9080 ,http://localhost:4200")
    public User createToken( String username,String password ) throws AuthenticationException {
    	log.info("UserName : " + username + "PAssword: " + password) ;
        return authService.login( username, password );
    }

    
    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:9080 ,http://localhost:4200")
    @JsonIgnore
    public Long register( @RequestBody UserLogin addedUser ) throws AuthenticationException {
    	log.info("Register : " + addedUser);
    	UserLogin usrLogin =  authService.register(addedUser);
    	
        return usrLogin.getId();
    }
    
    @RequestMapping(value="/authentication/pingService", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:9080 ,http://localhost:4200")
	public String pingService() {

    	log.info("Inside Ping Service  ..");
		return "Ping Success";

	}
    

}
