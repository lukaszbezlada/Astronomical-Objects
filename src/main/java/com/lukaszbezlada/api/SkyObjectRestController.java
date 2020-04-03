package com.lukaszbezlada.api;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.repository.SkyObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/oldApi")
public class SkyObjectRestController {

    private SkyObjectRepository skyObjectRepository;

    @Autowired
    public SkyObjectRestController(SkyObjectRepository skyObjectRepository) {
        this.skyObjectRepository = skyObjectRepository;
    }

    @GetMapping(value = "/skyObjects", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SkyObject> getSkyObjects() {
        Iterable<SkyObject> all = skyObjectRepository.findAll();
        return all;
    }

    @GetMapping(value = "/getSkyObject/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<SkyObject>> getSkyObjectByName(@PathVariable(value = "name") String name) {
        Optional<SkyObject> skyObject =  skyObjectRepository.findSkyObjectByNameContains(name);
        if (!skyObject.isPresent())
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(skyObject);
        }
    }

    @GetMapping("/getSkyObjectById/{id}")
    public ResponseEntity<SkyObject> getSkyObjectById(@PathVariable(value = "id") Long id) {
        return skyObjectRepository.findSkyObjectById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/skyObject", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewSkyObject(@RequestBody SkyObject skyObject) {
        skyObjectRepository.save(skyObject);
    }

    @DeleteMapping("/skyObject/{name}")
    public void deleteSkyObject(@PathVariable(value = "name") String name) {
        skyObjectRepository.deleteSkyObjectByName(name);
    }

}
