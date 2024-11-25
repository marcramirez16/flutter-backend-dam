package com.dam2.flutter.service;

import com.dam2.flutter.entity.Achievements;

import java.util.List;

public interface AchievementsService {
    
    List<Achievements> findByCategoryId(Long categoryid);
    Achievements findById(Long id);
    Achievements save(Achievements achievements);
    void deleteById(Long id);
    
}
