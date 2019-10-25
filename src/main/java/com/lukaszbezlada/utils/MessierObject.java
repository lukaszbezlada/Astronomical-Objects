package com.lukaszbezlada.utils;

import lombok.*;
import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
@Value
@AllArgsConstructor
public class MessierObject  {

    private int id;
    private String messierNumber;
    private String NGCNumber;
    private String name;
    private String type;
    private Long distance;
    private Long brightness;
    private String imgPath;

    public void setId(int id) {
        this.id = id;
    }

    public void setMessierNumber(String messierNumber) {
        this.messierNumber = messierNumber;
    }

    public void setNGCNumber(String NGCNumber) {
        this.NGCNumber = NGCNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public void setBrightness(Long brightness) {
        this.brightness = brightness;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}