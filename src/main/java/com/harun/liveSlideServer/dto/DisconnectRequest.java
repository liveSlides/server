package com.harun.liveSlideServer.dto;

public class DisconnectRequest {
    private String sessionID;
    private String userID;

    public DisconnectRequest() {

    }

    public DisconnectRequest(String sessionID,String userID) {
        this.sessionID = sessionID;
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}
