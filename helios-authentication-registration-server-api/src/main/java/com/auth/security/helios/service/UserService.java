package com.auth.security.helios.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.security.helios.entity.UserLogin;
import com.auth.security.helios.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

		UserLogin user = userRepository.findByUsername(s);

		if (user == null) {
			throw new UsernameNotFoundException("User Name Not FOund");
		}
		return user;
	}

}
