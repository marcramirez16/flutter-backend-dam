package com.dam2.flutter.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Friendrequests")
public class FriendRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendrequest")
    private Long friendrequest;

    @Column(name = "usersender")
    private Long userSender;

    @Column(name = "userreciever")
    private Long userReciever;

    public FriendRequests() {}

    public FriendRequests(Long friendrequest, Long userSender, Long userReciever) {
        this.friendrequest = friendrequest;
        this.userSender = userSender;
        this.userReciever = userReciever;
    }

    public Long getFriendrequests() {
        return friendrequest;
    }

    public void setFriendrequests(Long friendrequest) {
        this.friendrequest = friendrequest;
    }

    public Long getUserSender() {
        return userSender;
    }

    public void setUserSender(Long userSender) {
        this.userSender = userSender;
    }

    public Long getUserReciever() {
        return userReciever;
    }

    public void setUserReciever(Long userReciever) {
        this.userReciever = userReciever;
    }
}
