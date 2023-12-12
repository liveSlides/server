package com.harun.liveSlideServer.dto;

public class SessionInitialResponse {
    private String sessionID;
    private ResponseStatus status;
    private SessionInitializeType type;

    public SessionInitialResponse() {
    }

    public SessionInitialResponse(String sessionID, ResponseStatus status, SessionInitializeType type) {
        this.sessionID = sessionID;
        this.status = status;
        this.type = type;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public SessionInitializeType getType() {
        return type;
    }

    public void setType(SessionInitializeType type) {
        this.type = type;
    }
}
