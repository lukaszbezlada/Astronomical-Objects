package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.utils.SkyObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SkyObjectController {

    private final SkyObjectService skyObjectService;

    @Autowired
    public SkyObjectController(SkyObjectService skyObjectService) {
        this.skyObjectService = skyObjectService;
    }

    @PostMapping("/addSkyObject")
    public String addSkyObject(SkyObject skyObject) {
        skyObjectService.addSkyObject(skyObject);
        return "account";
    }
}
