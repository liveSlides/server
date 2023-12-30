package com.harun.liveSlideServer.dto;

import java.util.Objects;

public class RequestControlEvent {
    private String userID;
    private boolean isRequestControl;

    public RequestControlEvent() {}
    public RequestControlEvent(String userID, boolean isRequestControl) {
        this.userID = userID;
        this.isRequestControl = isRequestControl;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isRequestControl() {
        return isRequestControl;
    }

    public void setRequestControl(boolean requestControl) {
        isRequestControl = requestControl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestControlEvent that = (RequestControlEvent) o;
        return isRequestControl == that.isRequestControl && Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, isRequestControl);
    }

    @Override
    public String toString() {
        return "RequestControlEvent{" +
                "userID='" + userID + '\'' +
                ", isRequestControl=" + isRequestControl +
                '}';
    }
}
