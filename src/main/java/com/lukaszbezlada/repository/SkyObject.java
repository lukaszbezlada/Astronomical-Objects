package com.lukaszbezlada.repository;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="object")
public class SkyObject implements Serializable{
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

    public SkyObject(String name, String authorName, String authorSurname, LocalDateTime dateTime) {
        this.name = name;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.dateTime = dateTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
