package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@RepositoryRestResource(path = "skyobjects")
public interface SkyObjectRepository extends JpaRepository<SkyObject, Long> {

    Optional<SkyObject> findSkyObjectByNameContains(String contain);
    List<SkyObject> findSkyObjectsByUserId(Long id);
    void deleteSkyObjectByName(String name);
    Optional<SkyObject> findSkyObjectById(Long id);
}
