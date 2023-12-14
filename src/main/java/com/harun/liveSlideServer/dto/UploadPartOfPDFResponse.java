package com.harun.liveSlideServer.dto;

public class UploadPartOfPDFResponse {
    public ResponseStatus status;

    public UploadPartOfPDFResponse() {

    }

    public UploadPartOfPDFResponse(ResponseStatus status) {
        this.status = status;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
