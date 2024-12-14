package com.dam2.flutter.dao;

import com.dam2.flutter.entity.UserAchievements;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

//ESTA CLASSE CONECTA EL OBJETIVO CON LA BD

@Repository //classe que gestiona la interaccion con la bd
//JpaRepository herramientas para buscar, guardar, eliminar y actualizar objetivos en la bd
public interface UserAchievementsDAO extends JpaRepository<UserAchievements, Long> {
    @Query("SELECT u FROM UserAchievements u WHERE u.achievementid = :achievementId AND u.userid = :userId")
    UserAchievements findByBothId(@Param("achievementId") Long achievementId, @Param("userId") Long userId);

    List<UserAchievements> findByAchievementid(Long achievementId);
    
    List<UserAchievements> findByUserid(Long userId);

}

