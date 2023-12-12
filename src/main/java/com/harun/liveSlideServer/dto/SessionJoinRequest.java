package com.harun.liveSlideServer.dto;

public class SessionJoinRequest {
    private String sessionID;
    private String participantName;

    public SessionJoinRequest(String sessionID, String participantName) {
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
}
