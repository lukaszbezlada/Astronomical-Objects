package com.lukaszbezlada.utils;

import lombok.*;

@Setter
@Builder
@AllArgsConstructor
public class MessierObject  {

    private Long id;
    private String messierNumber;
    private String NGCNumber;
    private String name;
    private String type;
    private Long distance;
    private Long brightness;
    private String imgPath;


}