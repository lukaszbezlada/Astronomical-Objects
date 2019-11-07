package com.lukaszbezlada.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "skyObject")
public class SkyObject implements Serializable {

    private static final long serialVersionUID = 6359254733772877789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skyobject_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public SkyObject() {
        // for JPA
    }

    public SkyObject(Long skyobject_id, String name, LocalDateTime dateTime, String image, User user) {
        this.skyobject_id = skyobject_id;
        this.name = name;
        this.dateTime = dateTime;
        this.image = image;
        this.user = user;
    }

    public Long getSkyobject_id() {
        return skyobject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SkyObject{" +
                "skyobject_id=" + skyobject_id +
                ", name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", user=" + user.getLogin() +
                '}';
    }
}
