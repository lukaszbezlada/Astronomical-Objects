package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkyObjectRepository extends JpaRepository<SkyObject, Long> {

    SkyObject save(SkyObject skyObject);

    void deleteById(Long id);

    List<SkyObject> findAll();

    Optional<SkyObject> findById(Long skyobject_id);

    Optional<SkyObject> findSkyObjectByNameContains(String contain);

}
