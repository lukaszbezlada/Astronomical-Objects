package com.lukaszbezlada.utils;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.repository.SkyObjectRepository;
import com.lukaszbezlada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SkyObjectService {

    private UserRepository userRepository;
    private SkyObjectRepository skyObjectRepository;

    @Autowired
    public SkyObjectService(UserRepository userRepository, SkyObjectRepository skyObjectRepository) {
        this.userRepository = userRepository;
        this.skyObjectRepository = skyObjectRepository;
    }

    public void addSkyObject(SkyObject skyObject) {
        //wyciągnięcie nazwy zalogowanego użytkownika
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByLogin(login);
        skyObject.setUser(user);
        skyObjectRepository.save(skyObject);
    }
}
