package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SkyObjectRepository extends CrudRepository<SkyObject, Long> {

    List<SkyObject> findAll();

    SkyObject findByAuthorName(String authorName);

    SkyObject findById(int id);

    Optional<SkyObject> findByName(String name);

    Optional<SkyObject> findByNameContains(String name);
}
