package com.harun.liveSlideServer.dto;

public class SessionParticipantsRequest {
    private String sessionId;
    private String userID;

    public SessionParticipantsRequest() {

    }

    public SessionParticipantsRequest(String sessionId,String userID) {
        this.sessionId = sessionId;
        this.userID = userID;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "SessionParticipantsRequest{" +
                "sessionId='" + sessionId + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
