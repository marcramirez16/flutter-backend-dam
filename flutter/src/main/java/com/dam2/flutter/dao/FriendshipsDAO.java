package com.dam2.flutter.dao;

import com.dam2.flutter.entity.Friendships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipsDAO extends JpaRepository<Friendships, Long> {
}