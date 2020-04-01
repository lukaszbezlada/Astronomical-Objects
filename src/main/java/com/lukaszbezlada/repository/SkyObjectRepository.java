package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface SkyObjectRepository extends JpaRepository<SkyObject, Long> {

    Optional<SkyObject> findSkyObjectByNameContains(String contain);
    List<SkyObject> findSkyObjectsByUserId(Long id);
    void deleteSkyObjectByName(String name);
    //Optional<SkyObject> findSkyObjectBySkyobject_id(Long id);
}
