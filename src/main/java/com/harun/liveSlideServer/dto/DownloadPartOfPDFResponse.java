package com.harun.liveSlideServer.dto;

public class DownloadPartOfPDFResponse {
    public ResponseStatus status;
    public String fileName;
    public String content;

    public DownloadPartOfPDFResponse() {

    }

    public DownloadPartOfPDFResponse(ResponseStatus status, String fileName, String content) {
        this.status = status;
        this.fileName = fileName;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DownloadPartOfPDFResponse{" +
                "status=" + status +
                ", fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
