package com.harun.liveSlideServer.dto;

public class UploadPDFResponse {
    public ResponseStatus status;

    public UploadPDFResponse() {

    }

    public UploadPDFResponse(ResponseStatus status) {
        this.status = status;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
