package com.dam2.flutter.service;

import com.dam2.flutter.dao.FriendRequestsDAO;
import com.dam2.flutter.entity.FriendRequests;
import com.dam2.flutter.entity.Friendships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRequestsServiceImpl implements FriendRequestsService {

    @Autowired
    private FriendRequestsDAO friendRequestsDAO;

    @Override
    public List<FriendRequests> findAll() {
        return friendRequestsDAO.findAll();
    }


    @Override
    public void deleteFriendRequest(Long friendrequest) {
        friendRequestsDAO.deleteById(friendrequest); 
    }

    @Override
    public FriendRequests findById(Long friendrequestId) {
        return friendRequestsDAO.findById(friendrequestId).orElse(null);  
    }

    
    @Override
    public FriendRequests saveFriendRequest(FriendRequests friendrequest) {
        return friendRequestsDAO.save(friendrequest);
    }



}
