package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;;
import com.lukaszbezlada.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface SkyObjectRepository extends JpaRepository<SkyObject, Long> {

    Optional<SkyObject> findSkyObjectByNameContains(String contain);
    ArrayList<SkyObject> findSkyObjectsByUserEquals(String login);

}
