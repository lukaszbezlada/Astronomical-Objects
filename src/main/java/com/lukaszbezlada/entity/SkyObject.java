package com.lukaszbezlada.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "object")
public class SkyObject implements Serializable {
    private static final long serialVersionUID = 6359254733772877789L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String authorName;

    @Column
    private String authorSurname;

    @Column
    private LocalDateTime dateTime;

    public SkyObject() {
        // for JPA
    }
}
