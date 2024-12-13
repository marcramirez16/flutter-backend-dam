package com.dam2.flutter.service;

import com.dam2.flutter.entity.Friendships;

import java.util.List;

public interface FriendshipsService {
    List<Friendships> findAll();
}