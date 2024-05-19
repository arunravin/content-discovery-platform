package com.auth.security.helios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.security.helios.entity.UserLogin;


public interface UserRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByUsername( String username );
   
}
