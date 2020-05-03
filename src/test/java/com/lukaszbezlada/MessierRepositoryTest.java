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

    @Autowired
    private MessierRepository messierRepository;

    private final String line1 = "first line";
    private final String line2 = "1;M1;NGC 1952;Mgławica Kraba;pozostałość po supernowej;6,3;9;img/messier/M1m.jpg;img/messier/M1.jpg";
    private final ArrayList<String> line2List = new ArrayList<>();
    private MessierObject messierObject;
    private String filePath;
    private File file;

    @Before
    public void createFileAndObject() throws Exception {
        //given
        line2List.add(line2); // only for first test

        file = File.createTempFile("testFile.txt", null);
        filePath = file.getPath();
        PrintWriter pw = new PrintWriter(file);
        pw.println(line1);
        pw.println(line2);
        pw.close();

        messierObject = new MessierObject();
        messierObject.setId(Integer.parseInt("1"));
        messierObject.setMessierNumber("M1");
        messierObject.setNGCNumber("NGC 1952");
        messierObject.setName("Mgławica Kraba");
        messierObject.setType("pozostałość po supernowej");
        messierObject.setDistance("6,3");
        messierObject.setBrightness("9");
        messierObject.setImgPath("img/messier/M1m.jpg");
        messierObject.setImgBigPath("img/messier/M1.jpg");
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



