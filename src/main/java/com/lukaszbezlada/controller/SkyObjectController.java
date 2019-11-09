package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.repository.SkyObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SkyObjectController {

    private SkyObjectRepository skyObjectRepository;

    @Autowired
    public SkyObjectController(SkyObjectRepository skyObjectRepository) {
        this.skyObjectRepository = skyObjectRepository;
    }

    @GetMapping("/skyObjects")
    public Iterable<SkyObject> getSkyObjects() {
        Iterable<SkyObject> all = skyObjectRepository.findAll();
        return all;
    }

    @GetMapping("/getSkyObject/{name}")
    public Optional<SkyObject> getSkyObjectByName(@PathVariable(value = "name") String name) {
        return skyObjectRepository.findSkyObjectByNameContains(name);
    }

    @PostMapping(value = "/skyObject", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewSkyObject(@RequestBody SkyObject skyObject) {
        skyObjectRepository.save(skyObject);
    }

    @DeleteMapping("/skyObject/{id}")
    public void deleteAccount(@PathVariable(value = "id") Long id) {
        skyObjectRepository.deleteById(id);
    }

}
