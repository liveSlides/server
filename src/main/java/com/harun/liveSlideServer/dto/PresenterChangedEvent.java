package com.harun.liveSlideServer.dto;

import java.util.Objects;

public class PresenterChangedEvent {
    private String userName;
    private String userID;

    public PresenterChangedEvent() {

    }

    public PresenterChangedEvent(String userID, String userName) {
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
        PresenterChangedEvent that = (PresenterChangedEvent) o;
        return Objects.equals(userName, that.userName) && Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userID);
    }

    @Override
    public String toString() {
        return "PresenterChangedEvent{" +
                "userName='" + userName + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
