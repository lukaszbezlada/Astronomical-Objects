package com.lukaszbezlada.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Component
public class MessierServiceImpl implements MessierService {
    private static String path = "/home/lukasz/Pulpit/Projekty/Astronomical-Objects/src/main/resources/messier.csv";

    public ArrayList<MessierObject> readFile() {
        Path filePath = Paths.get(path);
        ArrayList<String> read = new ArrayList<>();
        try {
            read = (ArrayList<String>) Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        read.remove(0);
        return toObjects(read);
    }

    public ArrayList<MessierObject> toObjects(ArrayList<String> read) {
        ArrayList<MessierObject> messierObjects = new ArrayList<>();

        for (String line : read) {
            String[] l = line.split(",");
//            #TODO zamienić na Builder
            MessierObject messierObject = new MessierObject();
            messierObject.setId(Integer.parseInt(l[0]));
            messierObject.setMessierNumber(l[1]);
            messierObject.setNGCNumber(l[2]);
            messierObject.setName(l[3]);
            messierObject.setType(l[4]);
            messierObject.setDistance(Long.valueOf(l[5]));
            messierObject.setBrightness(Long.valueOf(l[6]));
            messierObject.setImgPath(l[7]);
            messierObject.setImgBigPath(l[8]);

            messierObjects.add(messierObject);
        }
        return messierObjects;
    }
}
