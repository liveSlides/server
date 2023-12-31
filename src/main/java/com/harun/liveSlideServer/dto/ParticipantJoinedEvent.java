package com.harun.liveSlideServer.dto;

import java.util.Objects;

public class ParticipantJoinedEvent {
    private String userID;
    private String userName;

    public ParticipantJoinedEvent() {

    }

    public ParticipantJoinedEvent(String userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantJoinedEvent that = (ParticipantJoinedEvent) o;
        return Objects.equals(userID, that.userID) && Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, userName);
    }

    @Override
    public String toString() {
        return "ParticipantJoinedEvent{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
