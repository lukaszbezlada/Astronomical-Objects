package com.lukaszbezlada.utils;

import java.util.ArrayList;

public interface MessierService {

    ArrayList readFile();

    ArrayList toObjects(ArrayList<String> read);
}
