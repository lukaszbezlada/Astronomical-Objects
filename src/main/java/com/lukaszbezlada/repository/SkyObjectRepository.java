package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkyObjectRepository extends JpaRepository<SkyObject, Long> {

 //   Optional<SkyObject> findSkyObjectByNameContains(String contain);

}
