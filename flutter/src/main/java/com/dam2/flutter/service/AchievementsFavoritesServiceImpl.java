package com.dam2.flutter.service;

import com.dam2.flutter.dao.AchievementsFavoritesDAO;
import com.dam2.flutter.entity.AchievementsFavorites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//metodos para retornar y actualizar datos de el objetivo
@Service
public class AchievementsFavoritesServiceImpl implements AchievementsFavoritesService {
    @Autowired
    private AchievementsFavoritesDAO achievementsFavoritesDAO;


    //RETORNA una lista de todos los objetivos favoritos de un determinado usuario



    @Override
    public List<AchievementsFavorites> findByUserId(Long userId) {
        return achievementsFavoritesDAO.findByUserId(userId); 

    }

    @Override
    public AchievementsFavorites saveFavorite(AchievementsFavorites achievemetFavorites) {
        // Guarda la entidad en la base de datos
        return achievementsFavoritesDAO.save(achievemetFavorites);
    }

    @Override
    public void deleteFavorite(AchievementsFavorites achievementsFavorites) {
        achievementsFavoritesDAO.delete(achievementsFavorites);
    }

    @Override
    public AchievementsFavorites findByUserIdAndAchievementId(int userId, int achievementId) {
        return achievementsFavoritesDAO.findByUserIdAndAchievementId(userId, achievementId);
    }
}