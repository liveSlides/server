package com.harun.liveSlideServer.dto.meeting;

import java.util.Objects;

public class MeetingInitialInformationResponse {
    private String fileName;
    private int index;
    private int zoomRate;
    private double hScrollValue;
    private double vScrollValue;

    public MeetingInitialInformationResponse() {

    }

    public MeetingInitialInformationResponse(String fileName, int index, int zoomRate, double hScrollValue, double vScrollValue) {
        this.fileName = fileName;
        this.index = index;
        this.zoomRate = zoomRate;
        this.hScrollValue = hScrollValue;
        this.vScrollValue = vScrollValue;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getZoomRate() {
        return zoomRate;
    }

    public void setZoomRate(int zoomRate) {
        this.zoomRate = zoomRate;
    }

    public double gethScrollValue() {
        return hScrollValue;
    }

    public void sethScrollValue(double hScrollValue) {
        this.hScrollValue = hScrollValue;
    }

    public double getvScrollValue() {
        return vScrollValue;
    }

    public void setvScrollValue(double vScrollValue) {
        this.vScrollValue = vScrollValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingInitialInformationResponse response = (MeetingInitialInformationResponse) o;
        return index == response.index && zoomRate == response.zoomRate && Double.compare(hScrollValue, response.hScrollValue) == 0 && Double.compare(vScrollValue, response.vScrollValue) == 0 && Objects.equals(fileName, response.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, index, zoomRate, hScrollValue, vScrollValue);
    }

    @Override
    public String toString() {
        return "MeetingInitialInformationResponse{" +
                "fileName='" + fileName + '\'' +
                ", index=" + index +
                ", zoomRate=" + zoomRate +
                ", hScrollValue=" + hScrollValue +
                ", vScrollValue=" + vScrollValue +
                '}';
    }
}
