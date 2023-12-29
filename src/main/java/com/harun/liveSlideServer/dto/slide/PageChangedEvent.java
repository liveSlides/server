package com.harun.liveSlideServer.dto.slide;

import java.util.Objects;

public class PageChangedEvent {
    private int index;
    private int zoomRate;
    private double vValue;
    private double hValue;

    public PageChangedEvent() {

    }

    public PageChangedEvent(int index, int zoomRate, double vValue, double hValue) {
        this.index = index;
        this.zoomRate = zoomRate;
        this.vValue = vValue;
        this.hValue = hValue;
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

    public double gethValue() {
        return hValue;
    }

    public void sethValue(double hValue) {
        this.hValue = hValue;
    }

    public double getvValue() {
        return vValue;
    }

    public void setvValue(double vValue) {
        this.vValue = vValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageChangedEvent that = (PageChangedEvent) o;
        return index == that.index && zoomRate == that.zoomRate && Double.compare(vValue, that.vValue) == 0 && Double.compare(hValue, that.hValue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, zoomRate, vValue, hValue);
    }

    @Override
    public String toString() {
        return "PageChangedEvent{" +
                "index=" + index +
                ", zoomRate=" + zoomRate +
                ", vValue=" + vValue +
                ", hValue=" + hValue +
                '}';
    }
}
