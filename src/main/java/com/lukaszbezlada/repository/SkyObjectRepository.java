package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.SkyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkyObjectRepository extends JpaRepository<SkyObject, Long> {

}
