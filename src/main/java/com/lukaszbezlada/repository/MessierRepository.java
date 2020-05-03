package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.MessierObject;

import java.util.ArrayList;

public interface MessierRepository {

    ArrayList<MessierObject> readFile();

    ArrayList<MessierObject> toObjects(ArrayList<String> read);
}
