package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    void deleteById(Long id);

    List<User> findAll();

    Optional<User> findById(Long user_id);


}
