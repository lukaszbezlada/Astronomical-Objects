package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
