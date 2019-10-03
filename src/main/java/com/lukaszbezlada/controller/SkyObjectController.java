package com.lukaszbezlada.controller;

import com.lukaszbezlada.repository.SkyObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SkyObjectController {

    @Autowired
    private SkyObjectRepository skyObject;


}
