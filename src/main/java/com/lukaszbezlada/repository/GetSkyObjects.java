package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GetSkyObjects extends CrudRepository<SkyObject, Integer> {

    default Optional<SkyObject> getSkyObject() {
        Optional<SkyObject> skyObject1 = findById(1);
        return skyObject1;
    }

}