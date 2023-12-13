package com.harun.liveSlideServer.dto;

public class DisconnectResponse {
    public ResponseStatus status;

    public DisconnectResponse() {

    }

    public DisconnectResponse(ResponseStatus status) {
        this.status = status;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
