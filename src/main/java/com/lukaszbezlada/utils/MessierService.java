package com.lukaszbezlada.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class MessierService {
    private static ArrayList<MessierObject> messierList = new ArrayList<>();
    private static String path = "/home/lukasz/Pulpit/Projekty/Astronomical-Objects/src/main/resources/messier.csv";

    public static ArrayList readFile() {
        Path filePath = Paths.get(path);
        ArrayList<String> read = new ArrayList<>();
        try {
            read = (ArrayList<String>) Files.readAllLines(filePath);
        } catch (IOException e) {
           e.printStackTrace();
        }
        read.remove(0);
        messierList = toObjects(read);
        return messierList;
    }

    private static ArrayList toObjects(ArrayList<String> read) {
        ArrayList <MessierObject> messierObjects = new ArrayList<>();

        for (String line : read) {
            String[] l = line.split(",");
//            #TODO zamienić na Builder
            MessierObject messierObject = new MessierObject();
            messierObject.setId(Integer.parseInt(l[0]));
            messierObject.setMessierNumber(l[1]);
            messierObject.setNGCNumber(l[2]);
            messierObject.setType(l[3]);
            messierObject.setDistance(Long.valueOf(l[4]));
            messierObject.setBrightness(Long.valueOf(l[5]));
            messierObject.setImgPath(l[6]);

            messierObjects.add(messierObject);
        }
        return messierObjects;
    }
}
