package com.harun.liveSlideServer.dto.slide;

import java.util.Objects;

public class FileUploadedEvent {
    private String fileName;
    private int pageCount;

    public FileUploadedEvent() {

    }

    public FileUploadedEvent(String fileName, int pageCount) {
        this.fileName = fileName;
        this.pageCount = pageCount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileUploadedEvent that = (FileUploadedEvent) o;
        return pageCount == that.pageCount && Objects.equals(fileName, that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, pageCount);
    }

    @Override
    public String toString() {
        return "FileUploadedEvent{" +
                "fileName='" + fileName + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}
