package com.dam2.flutter.service;

import com.dam2.flutter.entity.FriendRequests;

import java.util.List;

public interface FriendRequestsService {
    List<FriendRequests> findAll();
}
