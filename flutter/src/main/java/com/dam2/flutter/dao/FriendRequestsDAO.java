package com.dam2.flutter.dao;

import com.dam2.flutter.entity.FriendRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestsDAO extends JpaRepository<FriendRequests, Long> {
}