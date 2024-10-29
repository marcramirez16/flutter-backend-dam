package com.dam2.flutter.service;

import java.util.List;

import com.dam2.flutter.entity.Achievements;

public interface AchievementsService {
    
    List<Achievements> findByCategoryId(Long categoryid);
    Achievements findById(Long id);
    Achievements save(Achievements achievements);
    void deleteById(Long id);
    
}
