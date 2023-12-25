package com.harun.liveSlideServer.dto.meeting;

import java.util.Objects;

public class PageChangedRequest {
    private int index;
    private String canvasBase64;
    private String pageBase64;

    public PageChangedRequest() {

    }

    public PageChangedRequest(int index, String canvasBase64, String pageBase64) {
        this.index = index;
        this.canvasBase64 = canvasBase64;
        this.pageBase64 = pageBase64;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCanvasBase64() {
        return canvasBase64;
    }

    public void setCanvasBase64(String canvasBase64) {
        this.canvasBase64 = canvasBase64;
    }

    public String getPageBase64() {
        return pageBase64;
    }

    public void setPageBase64(String pageBase64) {
        this.pageBase64 = pageBase64;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageChangedRequest that = (PageChangedRequest) o;
        return index == that.index && Objects.equals(canvasBase64, that.canvasBase64) && Objects.equals(pageBase64, that.pageBase64);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, canvasBase64, pageBase64);
    }

    @Override
    public String toString() {
        return "PageChangedRequest{" +
                "index=" + index +
                ", canvasBase64='" + canvasBase64 + '\'' +
                ", imageBase64='" + pageBase64 + '\'' +
                '}';
    }
}
