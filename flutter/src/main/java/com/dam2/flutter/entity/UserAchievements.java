package com.dam2.flutter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity //tabla conectada a la bd
@Table(name = "Userachievements") //el nombre de la tabla es: "UserAchievements"
public class UserAchievements {

    //attributos de los objetivos

    @Id //identificador unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //el valor se incrementa automaticamente
    @Column(name = "id")
    private Long id;

    @Column(name = "achievementid") //la columna es achievementid
    private Long achievementid;

    @Column(name = "userid") //la columna es userid
    private Long userid;

    @Column(name = "likes") //la columna es likes
    private int likes;

    @Column(name = "dislikes") //la columna es dislikes
    private int dislikes;

    //constructor1
    public UserAchievements() {
    }

    //constructor 2
    public UserAchievements(Long id, Long achievementid, Long userid, int likes, int dislikes) {
        this.id = id;
        this.achievementid = achievementid;
        this.userid = userid;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    //setters para agregar a la bd
    //getters para retornar los datos de la bd
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getAchievementid() {
        return achievementid;
    }
    
    public void setAchievementid(Long achievementid) {
        this.achievementid = achievementid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public int getlikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    //metodo tostring para imprimir los datos de el objetivo
    @Override
    public String toString() {
        return "UserAchievements [id=" + id + ", idAchievement=" + achievementid +", idUser=" + userid + ", likes=" + likes + ", dislikes=" + dislikes +"]";
    }

    //public boolean isEmpty() {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    //}

    //public UserAchievements get(int i) {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'get'");
    //}

}