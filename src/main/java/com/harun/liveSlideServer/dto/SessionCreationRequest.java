package com.harun.liveSlideServer.dto;

public class SessionCreationRequest {
    private String userID;
    private String sessionID;
    private String hostName;

    public SessionCreationRequest() {

    }

    public SessionCreationRequest(String userID , String sessionID, String hostName) {
        this.userID = userID;
        this.sessionID = sessionID;
        this.hostName = hostName;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getHostName() {
        return hostName;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "SessionCreationRequest{" +
                "userID='" + userID + '\'' +
                ", sessionID='" + sessionID + '\'' +
                ", hostName='" + hostName + '\'' +
                '}';
    }
}

