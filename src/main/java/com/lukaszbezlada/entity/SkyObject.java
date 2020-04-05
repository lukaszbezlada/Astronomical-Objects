package com.lukaszbezlada.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Builder
@Entity
@Table(name = "skyObject")
public class SkyObject implements Serializable {

    private static final long serialVersionUID = 6359254733772877789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public SkyObject() {
        // for JPA
    }

    public SkyObject(Long id, String name, String date, String image, User user) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.image = image;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String dateTime) {
        this.date = dateTime;
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
                "skyobject_id=" + id +
                ", name='" + name + '\'' +
                ", dateTime=" + date +
                ", user=" + user.getLogin() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkyObject skyObject = (SkyObject) o;
        return Objects.equals(id, skyObject.id) &&
                Objects.equals(name, skyObject.name) &&
                Objects.equals(date, skyObject.date) &&
                Objects.equals(image, skyObject.image) &&
                Objects.equals(user, skyObject.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, image, user);
    }
}
