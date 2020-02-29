package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.UserRole;;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByRole(String role);
}
