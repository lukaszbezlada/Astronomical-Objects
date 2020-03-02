package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.UserRole;;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(String role);
}
