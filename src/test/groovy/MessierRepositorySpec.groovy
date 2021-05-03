import com.lukaszbezlada.entity.MessierObject
import com.lukaszbezlada.repository.MessierRepositoryImpl

import spock.lang.Specification

class MessierRepositorySpec extends Specification {

    def data = new GetData()
    def testedList = data.createListAndFile()
    def messierRepository = new MessierRepositoryImpl()
    def messierObject = MessierObject.builder()
            .id(Integer.parseInt("1"))
            .messierNumber("M1")
            .NGCNumber("NGC 1952")
            .name("Mgławica Kraba")
            .type("pozostałość po supernowej")
            .distance(Double.parseDouble("6.3"))
            .brightness(Double.parseDouble("9"))
            .imgPath("img/messier/M1m.jpg")
            .imgBigPath("img/messier/M1.jpg")
            .build()


    def "When use 'toObjects()' method then return suitable Messier objects"() {

        when: "Use 'toObjects() method on data"
        def result = messierRepository.toObjects(testedList)

        then: "Compare object created by method 'toObjects()' with object in setup"
        result.get(0) == messierObject

    }

    def "Reading file test with creating objects"() {

        when:
        def messierObjects = messierRepository.readFile(data.getFilePath());

        then: "Object from file is the same like object in setup"
        messierObjects.get(0) == messierObject;

    }


    def "Test example"() {
        setup:
        def a = 2
        def b = 3

        when:
        def result = a + b

        then:
        result == 5
    }
}


class GetData {

    def filePath;

    def createListAndFile() throws Exception {
        final ArrayList<String> line2List = new ArrayList<>();
        def file;
        def line1 = "first line";
        def line2 = "1;M1;NGC 1952;Mgławica Kraba;pozostałość po supernowej;6.3;9;img/messier/M1m.jpg;img/messier/M1.jpg";
        line2List.add(line2); // only for first test

        file = File.createTempFile("testFile", ".csv");
        filePath = file.getPath();
        def pw = new PrintWriter(file);
        pw.println(line1);
        pw.println(line2);
        pw.close();
        return line2List;
    }

    String getFilePath() {
        return filePath;
    }
}
