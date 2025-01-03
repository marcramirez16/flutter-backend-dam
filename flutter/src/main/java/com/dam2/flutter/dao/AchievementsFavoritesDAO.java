package com.dam2.flutter.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dam2.flutter.entity.AchievementsFavorites;

import java.util.List;

public interface AchievementsFavoritesDAO extends JpaRepository<AchievementsFavorites, Long> {
    // Consulta para obtener los favoritos de un usuario específico
    List<AchievementsFavorites> findByUserId(Long userId);

    //Eliminar un favorito
     void deleteByUserIdAndAchievementId(int userId, int achievementId); 

     //Encontrar un logro favorito de un usuario
     AchievementsFavorites findByUserIdAndAchievementId(int userId, int achievementId);



    

}
