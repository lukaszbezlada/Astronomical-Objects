package com.lukaszbezlada;

import com.lukaszbezlada.entity.MessierObject;
import com.lukaszbezlada.repository.MessierService;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MessierServiceImplTest {

    @Autowired
    private @Qualifier("OneMessierServiceImplementation") MessierService messierService;

    private final String line1 = "first line";
    private final String line2 = "1;M1;NGC 1952;Mgławica Kraba;pozostałość po supernowej;6,3;9;img/messier/M1m.jpg;img/messier/M1.jpg";
    private final ArrayList<String> line2List = new ArrayList<>();

    @Before
    public void createFile() throws Exception {
        //given
        TemporaryFolder folder = new TemporaryFolder();
        final File file = folder.newFile("myfile.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println(line1);
        pw.println(line2);
        pw.close();
    }

    @Test
    public void whenToObjectsThenReturnMessierObjects() {
        //when
        ArrayList<MessierObject> messierObjects = messierService.toObjects(line2List);
        MessierObject messierObject = new MessierObject();
        messierObject.setId(Integer.parseInt("1"));
        messierObject.setMessierNumber("M1");
        messierObject.setNGCNumber("NGC 1952");
        messierObject.setName("Mgławica Kraba");
        messierObject.setType("pozostałość po supernowej");
        messierObject.setDistance("6,3");
        messierObject.setBrightness("9");
        messierObject.setImgPath("img/messier/M1m.jp");
        messierObject.setImgBigPath("img/messier/M1.jpg");

        //then
        assertThat(messierObjects.get(0)).isEqualTo(messierObject);

    }
}


//    public ArrayList<MessierObject> readFile() {
//        Path filePath = Paths.get(path);
//        ArrayList<String> read = new ArrayList<>();
//        try {
//            read = (ArrayList<String>) Files.readAllLines(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        read.remove(0);
//        return toObjects(read);
//    }
//
//    public ArrayList<MessierObject> toObjects(ArrayList<String> read) {
//        ArrayList<MessierObject> messierObjects = new ArrayList<>();
//
//        for (String line : read) {
//            String[] l = line.split(";");
////            #TODO zamienić na Builder
//            MessierObject messierObject = new MessierObject();
//            messierObject.setId(Integer.parseInt(l[0]));
//            messierObject.setMessierNumber(l[1]);
//            messierObject.setNGCNumber(l[2]);
//            messierObject.setName(l[3]);
//            messierObject.setType(l[4]);
//            messierObject.setDistance(l[5]);
//            messierObject.setBrightness(l[6]);
//            messierObject.setImgPath(l[7]);
//            messierObject.setImgBigPath(l[8]);
//
//            messierObjects.add(messierObject);
//        }
//        return messierObjects;
//    }




