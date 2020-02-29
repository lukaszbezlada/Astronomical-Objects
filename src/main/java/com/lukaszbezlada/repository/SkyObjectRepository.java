package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface SkyObjectRepository extends CrudRepository<SkyObject, Long> {

    Optional<SkyObject> findSkyObjectByNameContains(String contain);

}
