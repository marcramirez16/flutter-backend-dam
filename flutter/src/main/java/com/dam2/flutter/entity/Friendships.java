package com.dam2.flutter.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Friendships")
public class Friendships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendship")
    private Long friendship;

    @Column(name = "friendA")
    private Long friendA;

    @Column(name = "friendB")
    private Long friendB;

    public Friendships() {}

    public Friendships(Long friendship, Long friendA, Long friendB) {
        this.friendship = friendship;
        this.friendA = friendA;
        this.friendB = friendB;
    }

    public Long getFriendship() {
        return friendship;
    }

    public void setFriendship(Long friendship) {
        this.friendship = friendship;
    }

    public Long getFriendA() {
        return friendA;
    }

    public void setFriendA(Long friendA) {
        this.friendA = friendA;
    }

    public Long getFriendB() {
        return friendB;
    }

    public void setFriendB(Long friendB) {
        this.friendB = friendB;
    }
}
