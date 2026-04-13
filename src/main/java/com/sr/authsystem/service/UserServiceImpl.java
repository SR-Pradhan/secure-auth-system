package com.sr.authsystem.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sr.authsystem.model.Role;
import com.sr.authsystem.model.User;
import com.sr.authsystem.model.VerificationToken;
import com.sr.authsystem.repository.UserRepository;
import com.sr.authsystem.repository.RoleRepository;
import com.sr.authsystem.repository.VerificationTokenRepository;
import com.sr.authsystem.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	public UserServiceImpl(UserRepository userRepository,
	                       RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	// 🔐 REGISTER USER
	@Override
	public User save(UserRegistrationDto registrationDto) {

		// Fetch existing role from DB
		Role role = roleRepository.findByName("ROLE_USER");

		// Create user
		User user = new User(
				registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()),
				Arrays.asList(role)
		);

		// Enable user (for now)
		user.setEnabled(true);

		return userRepository.save(user);
	}

	// 🔐 LOAD USER FOR LOGIN
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				user.isEnabled(),
				true,
				true,
				true,
				mapRolesToAuthorities(user.getRoles())
		);
	}

	// 🔐 SAVE VERIFICATION TOKEN
	@Override
	public void saveVerificationToken(User user, String token) {
		VerificationToken verificationToken = new VerificationToken(token, user);
		verificationTokenRepository.save(verificationToken);
	}

	// 🔐 GET TOKEN
	@Override
	public VerificationToken getVerificationToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}

	// ENABLE USER
	@Override
	public void enableUser(User user) {
		user.setEnabled(true);
		userRepository.save(user);
	}

	// ROLE → AUTHORITIES
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(
			Collection<Role> roles) {

		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}
}