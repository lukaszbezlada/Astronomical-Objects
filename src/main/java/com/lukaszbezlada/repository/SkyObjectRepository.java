package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkyObjectRepository extends CrudRepository<SkyObject, Long> {

    List<SkyObject> findAll();
    SkyObject findByAuthorName();
    SkyObject findById();
}
