package com.lukaszbezlada.api;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.repository.SkyObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SkyObjectRestController {

    private SkyObjectRepository skyObjectRepository;

    @Autowired
    public SkyObjectRestController(SkyObjectRepository skyObjectRepository) {
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

//    @GetMapping("/getSkyObjectById/{id}")
//    public ResponseEntity<Optional<SkyObject>> getSkyObjectById(@PathVariable(value = "id") Long id) {
//        if (id < 0)
//            return ResponseEntity.notFound().build();
//        else {
//            Optional<SkyObject> skyObject = skyObjectRepository.findSkyObjectBySkyobject_id(id);
//            return ResponseEntity.ok(skyObject);
//        }
//    }

    @PostMapping(value = "/skyObject", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewSkyObject(@RequestBody SkyObject skyObject) {
        skyObjectRepository.save(skyObject);
    }

    @DeleteMapping("/skyObject/{name}")
    public void deleteSkyObject(@PathVariable(value = "name") String name) {
        skyObjectRepository.deleteSkyObjectByName(name);
    }

}
