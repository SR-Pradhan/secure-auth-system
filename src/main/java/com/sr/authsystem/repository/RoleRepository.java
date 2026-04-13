package com.sr.authsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sr.authsystem.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}