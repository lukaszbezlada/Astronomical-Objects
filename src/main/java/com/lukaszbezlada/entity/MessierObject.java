package com.lukaszbezlada.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Builder
@AllArgsConstructor
@Data
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

    public MessierObject() {

    }
}