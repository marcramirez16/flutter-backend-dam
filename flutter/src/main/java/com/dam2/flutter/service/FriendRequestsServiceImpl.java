package com.dam2.flutter.service;

import com.dam2.flutter.dao.FriendRequestsDAO;
import com.dam2.flutter.entity.FriendRequests;

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
}
