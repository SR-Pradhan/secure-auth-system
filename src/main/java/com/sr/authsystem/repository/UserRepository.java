package com.sr.authsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sr.authsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// Find user by email (used in login)
	User findByEmail(String email);

	// Check if email already exists (used in registration validation)
	boolean existsByEmail(String email);
}