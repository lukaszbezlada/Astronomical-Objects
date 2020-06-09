package com.lukaszbezlada.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    @NotEmpty(message = "{com.lukaszbezlada.entity.User.password.NotEmpty}")
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

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<SkyObject> skyObjectList;

    public User() {
        // for JPA
    }

    public User(String login, String password, String firstName, String lastName, String email, Set<UserRole> roles, List<SkyObject> skyObjectList) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        this.skyObjectList = skyObjectList;
    }

    public Long getId() {
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

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", skyObjectList=" + skyObjectList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(password2, user.password2) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(skyObjectList, user.skyObjectList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, password2, firstName, lastName, email, roles, skyObjectList);
    }
}
