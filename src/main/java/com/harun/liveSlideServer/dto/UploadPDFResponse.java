package com.harun.liveSlideServer.dto;

public class UploadPDFResponse {
    public ResponseStatus status;
    public String fileName;

    public UploadPDFResponse() {

    }

    public UploadPDFResponse(ResponseStatus status, String filename) {
        this.status = status;
        this.fileName = filename;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
