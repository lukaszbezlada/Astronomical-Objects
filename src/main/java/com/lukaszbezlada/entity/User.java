package com.lukaszbezlada.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -1332751664327050398L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Pattern(regexp = "^[\\p{Alnum}]{3,10}$", message = "{com.lukaszbezlada.entity.User.login.Pattern}")
    private String login;

    @Column
    @Size(min = 5, max = 10, message = "{com.lukaszbezlada.entity.User.password.Size}")
    private String password;

    @Transient
    private String password2;

    @Column
    @Pattern(regexp = "^[\\p{Alnum}]{3,10}$", message = "{com.lukaszbezlada.entity.User.firstName.Pattern}")
    private String firstName;

    @Column
    @Pattern(regexp = "^[\\p{Alnum}]{3,10}$", message = "{com.lukaszbezlada.entity.User.lastName.Pattern}")
    private String lastName;

    @Column
    @Email(message = "{com.lukaszbezlada.entity.User.email.Email}")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "{com.lukaszbezlada.entity.User.email.Pattern}")
    private String email;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<SkyObject> skyObjectList;

    public User() {
        // for JPA
    }

    public User(String login, String password, String firstName, String lastName, String email, UserStatus status) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }


    public Long getUser_id() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public List<SkyObject> getSkyObjectList() {
        return skyObjectList;
    }

    public void setSkyObjectList(List<SkyObject> skyObjectList) {
        this.skyObjectList = skyObjectList;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", skyObjectList=" + skyObjectList +
                '}';
    }
}
