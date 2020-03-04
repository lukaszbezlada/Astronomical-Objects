package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.utils.SkyObjectService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Controller
public class SkyObjectController {

    private final SkyObjectService skyObjectService;

    @Autowired
    public SkyObjectController(SkyObjectService skyObjectService) {
        this.skyObjectService = skyObjectService;
    }

    @PostMapping("/addSkyObject")
    @ResponseBody
    public String addSkyObject(@RequestPart(name = "fileupload") MultipartFile file, SkyObject skyObject) { // 2
        File uploadDirectory = new File("src/main/resources/static/img/users/");
        uploadDirectory.mkdirs();    // upewniam się, że katalog do którego chcę zapisać plik istnieje, a jeśli nie, to go tworzę

        try {
            File oFile = new File("src/main/resources/static/img/users/" + file.getOriginalFilename());
            OutputStream os = new FileOutputStream(oFile);
            InputStream inputStream = file.getInputStream();

            IOUtils.copy(inputStream, os); // 4

            os.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "Wystąpił błąd podczas przesyłania pliku: " + e.getMessage();
        }
        skyObject.setImage("src/main/resources/static/img/users/" + file.getOriginalFilename());
        skyObjectService.addSkyObject(skyObject);
        return "ok!";

    }
}
