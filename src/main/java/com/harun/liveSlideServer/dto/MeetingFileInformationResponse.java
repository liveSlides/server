package com.harun.liveSlideServer.dto;

import java.util.Objects;

public class MeetingFileInformationResponse {
    private String fileName;

    public MeetingFileInformationResponse() {

    }

    public MeetingFileInformationResponse(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingFileInformationResponse that = (MeetingFileInformationResponse) o;
        return Objects.equals(fileName, that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName);
    }

    @Override
    public String toString() {
        return "MeetingFileInformationResponse{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}

