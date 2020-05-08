package com.lukaszbezlada.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MessierObject {

    private int id;
    private String messierNumber;
    private String NGCNumber;
    private String name;
    private String type;
    private Double distance;
    private Double brightness;
    private String imgPath;
    private String imgBigPath;

    public MessierObject(int id, String messierNumber, String NGCNumber, String name, String type, Double distance, Double brightness, String imgPath, String imgBigPath) {
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

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setBrightness(Double brightness) {
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

    public Double getDistance() {
        return distance;
    }

    public Double getBrightness() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessierObject that = (MessierObject) o;
        return id == that.id &&
                Objects.equals(messierNumber, that.messierNumber) &&
                Objects.equals(NGCNumber, that.NGCNumber) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(distance, that.distance) &&
                Objects.equals(brightness, that.brightness) &&
                Objects.equals(imgPath, that.imgPath) &&
                Objects.equals(imgBigPath, that.imgBigPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messierNumber, NGCNumber, name, type, distance, brightness, imgPath, imgBigPath);
    }
}