package com.harun.liveSlideServer.dto;

public class DownloadPDFResponse {
    public ResponseStatus status;
    public String fileName;

    public DownloadPDFResponse() {

    }

    public DownloadPDFResponse(ResponseStatus status, String fileName) {
        this.status = status;
        this.fileName = fileName;
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
