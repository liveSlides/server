package com.harun.liveSlideServer.dto;

import java.util.Objects;

public class ParticipantDisconnectedEvent {
    private String userID;

    public ParticipantDisconnectedEvent() {

    }

    public ParticipantDisconnectedEvent(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantDisconnectedEvent that = (ParticipantDisconnectedEvent) o;
        return Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }

    @Override
    public String toString() {
        return "ParticipantDisconnectedEvent{" +
                "userID='" + userID + '\'' +
                '}';
    }
}
