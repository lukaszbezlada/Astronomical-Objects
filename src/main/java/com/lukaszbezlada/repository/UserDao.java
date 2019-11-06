package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.User;

public interface UserDao {

    void addUser(User user);

    User getUser(Long id);

    void updateUser(User user);

    void deleteUser(User user);

}
