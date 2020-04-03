package com.lukaszbezlada.utils;

import java.util.ArrayList;

public interface MessierService {

    ArrayList<MessierObject> readFile();

    ArrayList<MessierObject> toObjects(ArrayList<String> read);
}
