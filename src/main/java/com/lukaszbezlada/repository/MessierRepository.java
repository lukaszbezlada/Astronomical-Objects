package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.MessierObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MessierRepository {

    ArrayList<MessierObject> readFile();

    ArrayList<MessierObject> toObjects(ArrayList<String> read);
}
