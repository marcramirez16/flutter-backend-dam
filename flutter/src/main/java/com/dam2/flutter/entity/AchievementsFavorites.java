package com.dam2.flutter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // tabla conectada a la BD
@Table(name = "achievementsfavorites") // el nombre de la tabla es: "AchievementsFavorites"
public class AchievementsFavorites {

    @Id // identificador único
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el valor se incrementa automáticamente
    @Column(name = "id")
    private Long id;

    @Column(name = "userid") // la columna es user_id
    private Long userId;

    @Column(name = "achievementid") // la columna es achievement_id
    private Long achievementId;



    // Constructor vacío
    public AchievementsFavorites() {
    }

    // Constructor completo
    public AchievementsFavorites(Long id, Long userId, Long achievementId ) {
        this.id = id;
        this.userId = userId;
        this.achievementId = achievementId;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    



    @Override
    public String toString() {
        return "AchievementsFavorite [id=" + id + ", userId=" + userId + ", achievementId=" + achievementId  +"]";
    }
}
