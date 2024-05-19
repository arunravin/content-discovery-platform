package com.auth.security.helios.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.security.helios.comm.User;
import com.auth.security.helios.entity.UserLogin;
import com.auth.security.helios.repository.UserRepository;
import com.auth.security.helios.service.AuthService;
import com.auth.security.helios.util.JwtTokenUtil;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepository userRepository;

	Log log = LogFactory.getLog(getClass());

	@Override
	public User login(String username, String password) {

		log.info("Entering Login Method : " + username + " Pwd: " + password);

		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// String encoded = passwordEncoder.encode(password);

		UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);

		log.info("After UsernamePasswordAuthenticationToken .... " + upToken.getName());

		final Authentication authentication = authenticationManager.authenticate(upToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		User loggedInUser = new User();

		final String token = jwtTokenUtil.generateToken(userDetails);

		loggedInUser.setUsername(userDetails.getUsername());
		loggedInUser.setToken(token);

		return loggedInUser;
	}

	@Override
	public UserLogin register(UserLogin userToAdd) {

		log.info("Inside Register Method .." + userToAdd.toString());

		final String username = userToAdd.getUsername();
		final Long id = userToAdd.getId();

		if (userRepository.findByUsername(username) != null) {
			userToAdd.setId(0L);
			return userToAdd;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		final String rawPassword = userToAdd.getPassword();
		userToAdd.setPassword(encoder.encode(rawPassword));
		// userToAdd.setId(id);

		log.info("Exit Register Method .." + userToAdd.toString());
		UserLogin usr = userRepository.save(userToAdd);

		log.info(" ******* Registered with ID ******* " + usr.getId());

		return usr;

	}
}
