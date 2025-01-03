package com.dam2.flutter.service;

import java.util.List;

import com.dam2.flutter.entity.AchievementsFavorites;

public interface AchievementsFavoritesService {
    //Encontrar favoritos de cada usuario
List<AchievementsFavorites> findByUserId(Long userId);
    //Guardar los favoritos de cada usuario
AchievementsFavorites saveFavorite(AchievementsFavorites achievementsFavorites);
    //Eliminar los favoritos de cada usuario
void deleteFavorite( AchievementsFavorites achievementsFavorites);
    //Encontrar un  logro favorito de un determiando usuario
AchievementsFavorites findByUserIdAndAchievementId(int userId, int achievementId);


}
