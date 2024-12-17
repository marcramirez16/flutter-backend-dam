package com.dam2.flutter.service;

import com.dam2.flutter.entity.FriendRequests;
import com.dam2.flutter.entity.Friendships;

import java.util.List;

public interface FriendRequestsService {
    List<FriendRequests> findAll();
    void deleteFriendRequest(Long friendrequest);
    FriendRequests findById(Long friendrequest);
    FriendRequests saveFriendRequest(FriendRequests friendrequest); 

}
