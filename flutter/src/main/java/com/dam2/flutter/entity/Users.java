package com.dam2.flutter.entity;

import java.time.Year;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //tabla conectada a la bd
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "birthday")
    private Year birthday;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    // se haria algo asi? @Column(columnDefinition = "LONGBLOB")
    //private String profilephoto;
    @Column(name = "profilephoto")
    private String profilephoto;  // Cambiado a byte[] para almacenar la imagen como BLOB

    @Column(name = "biography")
    private String biography;

    @Column(name = "youtube")
    private String youtube;

    @Column(name = "twitterx")
    private String twitterx;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "twitch")
    private String twitch;

    @Column(name = "reddit")
    private String reddit;

    @Column(name = "steam")
    private String steam;

    @Column(name = "epicgames")
    private String epicgames;
    
    @Column(name = "nswitch")
    private String nswitch;

    @Column(name = "psn")
    private String psn;
    
    @Column(name = "xbox")
    private String xbox;
    
    //constructor1
    public Users() {
    }

    //constructor 2
    public Users(Long id, String username, Year birthday, String mail, String password,  String profilephoto, String biography, String youtube, String twitterx, String facebook, String twitch, String reddit, String steam, String epicgames, String nswitch, String psn, String xbox) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.mail = mail;
        this.password = password;
        this.profilephoto = profilephoto;
        this.biography = biography;
        this.youtube = youtube;
        this.twitterx = twitterx;
        this.facebook = facebook;
        this.twitch = twitch;
        this.reddit = reddit;
        this.steam = steam;
        this.epicgames = epicgames;
        this.nswitch = nswitch;
        this.psn = psn;
        this.xbox = xbox;

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

    public String getProfilephoto() {
        return profilephoto;
    }

    public void setProfilephoto(String profilephoto) {
        this.profilephoto = profilephoto;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTwitterx() {
        return twitterx;
    }

    public void setTwitterx(String twitterx) {
        this.twitterx = twitterx;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    
    public String getTwitch() {
        return twitch;
    }

    public void setTwitch(String twitch) {
        this.twitch = twitch;
    }

    public String getReddit() {
        return reddit;
    }

    public void setReddit(String reddit) {
        this.reddit = reddit;
    }
    
    public String getSteam() {
        return steam;
    }

    public void setSteam(String steam) {
        this.steam = steam;
    }

    public String getEpicgames() {
        return epicgames;
    }

    public void setEpicgames(String epicgames) {
        this.epicgames = epicgames;
    }

    public String getNswitch() {
        return nswitch;
    }

    public void setNswitch(String nswitch) {
        this.nswitch = nswitch;
    }
    
    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }
    
    public String getXbox() {
        return xbox;
    }

    public void setXbox(String xbox) {
        this.xbox = xbox;
    }

    //metodo tostring para imprimir los datos del usuario
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", mail=" + mail + ", password=" + password + ", profilephoto=" + profilephoto + ", biography=" + biography + ", youtube=" + youtube + ", twitterx=" + twitterx + ", facebook=" + facebook + ", twitch=" + twitch + ", reddit=" + reddit + ", steam=" + steam + ", epicgames=" + epicgames + ", nswitch=" + nswitch + ", psn=" + psn + ", xbox=" + xbox + "]";
    }
}
