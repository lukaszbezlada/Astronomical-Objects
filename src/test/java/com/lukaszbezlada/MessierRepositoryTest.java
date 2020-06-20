package com.lukaszbezlada;

import com.lukaszbezlada.entity.MessierObject;
import com.lukaszbezlada.repository.MessierRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessierRepositoryTest {

    private final ArrayList<String> line2List = new ArrayList<>();
    private MessierObject messierObject;
    private String filePath;
    private File file;

    @Autowired
    private MessierRepository messierRepository;

    @Before
    public void createFileAndObject() throws Exception {
        //given
        final String line1 = "first line";
        final String line2 = "1;M1;NGC 1952;Mgławica Kraba;pozostałość po supernowej;6.3;9;img/messier/M1m.jpg;img/messier/M1.jpg";
        line2List.add(line2); // only for first test

        file = File.createTempFile("testFile", ".csv");
        filePath = file.getPath();
        PrintWriter pw = new PrintWriter(file);
        pw.println(line1);
        pw.println(line2);
        pw.close();

        messierObject = MessierObject.builder()
                .id(Integer.parseInt("1"))
                .messierNumber("M1")
                .NGCNumber("NGC 1952")
                .name("Mgławica Kraba")
                .type("pozostałość po supernowej")
                .distance(Double.parseDouble("6.3"))
                .brightness(Double.parseDouble("9"))
                .imgPath("img/messier/M1m.jpg")
                .imgBigPath("img/messier/M1.jpg")
                .build();
    }

    @After
    public void clearRepository() {
        file.deleteOnExit();
    }

    @Test
    public void whenToObjectsThenReturnMessierObjects() {

        //when
        ArrayList<MessierObject> messierObjects = messierRepository.toObjects(line2List);

        //then
        assertThat(messierObjects.get(0)).isEqualTo(messierObject);
    }

    @Test
    public void whenReadFileThenReturnMessierObjects() {

        //when
        ArrayList<MessierObject> messierObjects = messierRepository.readFile(filePath);

        //then
        assertThat(messierObjects.get(0)).isEqualTo(messierObject);
    }
}



