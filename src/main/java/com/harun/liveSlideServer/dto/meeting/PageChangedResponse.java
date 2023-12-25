package com.harun.liveSlideServer.dto.meeting;

import java.util.Objects;

public class PageChangedResponse {
    private int index;
    private String canvasBase64;
    private String imageBase64;

    public PageChangedResponse() {

    }

    public PageChangedResponse(int index, String canvasBase64, String imageBase64) {
        this.index = index;
        this.canvasBase64 = canvasBase64;
        this.imageBase64 = imageBase64;
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

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageChangedResponse that = (PageChangedResponse) o;
        return index == that.index && Objects.equals(canvasBase64, that.canvasBase64) && Objects.equals(imageBase64, that.imageBase64);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, canvasBase64, imageBase64);
    }

    @Override
    public String toString() {
        return "PageChangedResponse{" +
                "index=" + index +
                ", canvasBase64='" + canvasBase64 + '\'' +
                ", imageBase64='" + imageBase64 + '\'' +
                '}';
    }
}
