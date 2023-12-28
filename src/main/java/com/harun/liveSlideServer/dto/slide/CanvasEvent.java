package com.harun.liveSlideServer.dto.slide;

import com.harun.liveSlideServer.enums.CanvasEventType;

import java.util.Objects;

public class CanvasEvent {
    private double x;
    private double y;

    public CanvasEvent() {

    }

    public CanvasEvent(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CanvasEvent that = (CanvasEvent) o;
        return Double.compare(x, that.x) == 0 && Double.compare(y, that.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "CanvasEvent{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
