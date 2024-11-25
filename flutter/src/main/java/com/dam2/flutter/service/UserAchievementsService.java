package com.dam2.flutter.service;

import com.dam2.flutter.entity.UserAchievements;

import java.util.List;

public interface UserAchievementsService {
    
    List<UserAchievements> findByAchievementId(Long achievementid);
    List<UserAchievements> findByUserId(Long userid);
    UserAchievements findByBothId(Long achievementid, Long userid);
    UserAchievements save(UserAchievements achievements);
    void deleteById(Long id);
}
