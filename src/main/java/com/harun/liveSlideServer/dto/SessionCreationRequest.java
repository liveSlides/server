package com.harun.liveSlideServer.dto;

public class SessionCreationRequest {
    private String sessionID;
    private String hostName;

    public SessionCreationRequest(String sessionID, String hostName) {
        this.sessionID = sessionID;
        this.hostName = hostName;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getHostName() {
        return hostName;
    }
}
