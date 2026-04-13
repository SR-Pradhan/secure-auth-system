package com.sr.authsystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sr.authsystem.model.User;
import com.sr.authsystem.model.VerificationToken;
import com.sr.authsystem.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	// Register user
	User save(UserRegistrationDto registrationDto);

	// Save verification token
	void saveVerificationToken(User user, String token);

	// Get token
	VerificationToken getVerificationToken(String token);

	// Enable user after verification
	void enableUser(User user);
}