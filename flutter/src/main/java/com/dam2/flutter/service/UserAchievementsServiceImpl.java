package com.dam2.flutter.service;

import com.dam2.flutter.dao.UserAchievementsDAO;
import com.dam2.flutter.entity.UserAchievements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//metodos para retornar y actualizar datos de el objetivo
@Service
public class UserAchievementsServiceImpl implements UserAchievementsService {
    @Autowired
    private UserAchievementsDAO userAchievementsDAO;

    @Override
    public List<UserAchievements> findByAchievementId(Long achievementId) {
        return userAchievementsDAO.findByAchievementid(achievementId);
    }

    @Override
    public List<UserAchievements> findByUserId(Long userId) {
        return userAchievementsDAO.findByUserid(userId);
    }

    @Override
    public UserAchievements findByBothId(Long achievementId, Long userId) {
        return userAchievementsDAO.findByBothId(achievementId, userId);
    }

    @Override
    public UserAchievements save(UserAchievements achievements) {
        return userAchievementsDAO.save(achievements);
    }

    @Override
    public void deleteById(Long id) {
        userAchievementsDAO.deleteById(id);
    }
}