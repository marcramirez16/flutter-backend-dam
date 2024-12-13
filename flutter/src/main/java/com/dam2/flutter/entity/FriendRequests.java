package com.dam2.flutter.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FriendRequests")
public class FriendRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendrequests")
    private Long friendrequests;

    @Column(name = "userSender")
    private Long userSender;

    @Column(name = "userReciever")
    private Long userReciever;

    public FriendRequests() {}

    public FriendRequests(Long friendrequests, Long userSender, Long userReciever) {
        this.friendrequests = friendrequests;
        this.userSender = userSender;
        this.userReciever = userReciever;
    }

    public Long getFriendrequests() {
        return friendrequests;
    }

    public void setFriendrequests(Long friendrequests) {
        this.friendrequests = friendrequests;
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
