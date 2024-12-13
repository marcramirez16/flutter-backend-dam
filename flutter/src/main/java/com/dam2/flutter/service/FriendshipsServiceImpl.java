package com.dam2.flutter.service;

import com.dam2.flutter.dao.FriendshipsDAO;
import com.dam2.flutter.entity.Friendships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipsServiceImpl implements FriendshipsService {

    @Autowired
    private FriendshipsDAO friendshipsDAO;

    @Override
    public List<Friendships> findAll() {
        return friendshipsDAO.findAll();
    }
}
