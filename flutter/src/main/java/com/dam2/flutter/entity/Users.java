package com.dam2.flutter.entity;

import java.time.Year;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //tabla conectada a la bd
@Table(name = "Users") //el nombre de la tabla es: "Users"
public class Users {

    //attributos del usuario

    @Id //identificador unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //el valor se incrementa automaticamente
    @Column(name = "id") //el nombre de la columna es "id"
    private Long id;

    @Column(name = "username") //el nombre de la columna es "username"
    private String username;

    @Column(name = "birthday") //el nombre de la columna es "birthday"
    private Year birthday;

    @Column(name = "mail") //el nombre de la columna es "mail"
    private String mail;

    @Column(name = "password") //el nombre de la columna es "password"
    private String password;

    @Column(name = "profile_photo") //el nombre de la columna es "profile_photo"
    private String profilephoto;

    @Column(name = "biography") //el nombre de la columna es "biography"
    private String biography;
    
    //constructor1
    public Users() {
    }

    //constructor 2
    public Users(Long id, String username, Year birthday, String mail, String password, String profilephoto, String biography) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.mail = mail;
        this.password = password;
        this.profilephoto = profilephoto;
        this.biography = biography;
    }

    //setters para agregar a la bd
    //getters para retornar los datos de la bd
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Year getBirthday() {
        return birthday;
    }

    public void setBirthday(Year birthday) {
        this.birthday = birthday;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilephoto;
    }

    public void setProfilePhoto(String profilephoto) {
        this.profilephoto = profilephoto;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    //metodo tostring para imprimir los datos del usuario
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", mail=" + mail + ", password=" + password + ", profilephoto=" + profilephoto + ", biography=" + biography + "]";
    }
}
