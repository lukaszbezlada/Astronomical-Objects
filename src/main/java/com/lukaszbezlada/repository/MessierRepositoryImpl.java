package com.lukaszbezlada.repository;

import com.lukaszbezlada.entity.MessierObject;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Repository
public class MessierRepositoryImpl implements MessierRepository {

    public ArrayList<MessierObject> readFile(String path) {
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
            String[] l = line.split(";");
            MessierObject messierObject = MessierObject.builder()
                    .id(Integer.parseInt(l[0]))
                    .messierNumber(l[1])
                    .NGCNumber(l[2])
                    .name(l[3])
                    .type(l[4])
                    .distance(Double.parseDouble(l[5]))
                    .brightness(Double.parseDouble(l[6]))
                    .imgPath(l[7])
                    .imgBigPath(l[8])
                    .build();

            messierObjects.add(messierObject);
        }
        return messierObjects;
    }
}
