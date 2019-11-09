package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkyObjectRepository extends JpaRepository<SkyObject, Long> {

    List<SkyObject> findAll();

//
//    Optional<SkyObject> findById(Long skyobject_id);
//
//    Optional<SkyObject> findByName(String name);

}
