package com.lukaszbezlada.utils;

import lombok.*;

public class MessierObject  {

    private int id;
    private String messierNumber;
    private String NGCNumber;
    private String name;
    private String type;
    private Long distance;
    private Long brightness;
    private String imgPath;
    private String imgBigPath;

    public MessierObject(int id, String messierNumber, String NGCNumber, String name, String type, Long distance, Long brightness, String imgPath, String imgBigPath) {
        this.id = id;
        this.messierNumber = messierNumber;
        this.NGCNumber = NGCNumber;
        this.name = name;
        this.type = type;
        this.distance = distance;
        this.brightness = brightness;
        this.imgPath = imgPath;
        this.imgBigPath = imgBigPath;
    }

    public MessierObject() {

    }

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

    public int getId() {
        return id;
    }

    public String getMessierNumber() {
        return messierNumber;
    }

    public String getNGCNumber() {
        return NGCNumber;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Long getDistance() {
        return distance;
    }

    public Long getBrightness() {
        return brightness;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getImgBigPath() {
        return imgBigPath;
    }

    public void setImgBigPath(String imgBigPath) {
        this.imgBigPath = imgBigPath;
    }

    @Override
    public String toString() {
        return "MessierObject{" +
                "id=" + id +
                ", messierNumber='" + messierNumber + '\'' +
                ", NGCNumber='" + NGCNumber + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", distance=" + distance +
                ", brightness=" + brightness +
                ", imgPath='" + imgPath + '\'' +
                ", imgBigPath='" + imgBigPath + '\'' +
                '}';
    }
}