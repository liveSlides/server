package com.harun.liveSlideServer.dto;

public class SessionJoinRequest {
    private String userID;
    private String sessionID;
    private String participantName;

    public SessionJoinRequest() {

    }

    public SessionJoinRequest(String userID , String sessionID, String participantName) {
        this.userID = userID;
        this.sessionID = sessionID;
        this.participantName = participantName;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
