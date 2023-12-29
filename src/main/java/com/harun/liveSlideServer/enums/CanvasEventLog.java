package com.harun.liveSlideServer.enums;

import com.harun.liveSlideServer.dto.slide.CanvasEvent;

import java.util.Objects;

public class CanvasEventLog {
    private CanvasEventType eventType;
    private CanvasEvent canvasEvent;
    private PDFTool activeTool;
    private PenEraserSize penSize;
    private PenEraserSize eraserSize;
    private PenColor penColor;

    public CanvasEventLog() {

    }

    public CanvasEventLog(CanvasEventType eventType,
                          CanvasEvent canvasEvent,
                          PDFTool activeTool,
                          PenEraserSize penSize,
                          PenEraserSize eraserSize,
                          PenColor penColor) {

        this.eventType = eventType;
        this.canvasEvent = canvasEvent;
        this.activeTool = activeTool;
        this.penSize = penSize;
        this.eraserSize = eraserSize;
        this.penColor = penColor;
    }

    public CanvasEventType getEventType() {
        return eventType;
    }

    public void setEventType(CanvasEventType eventType) {
        this.eventType = eventType;
    }

    public CanvasEvent getCanvasEvent() {
        return canvasEvent;
    }

    public void setCanvasEvent(CanvasEvent canvasEvent) {
        this.canvasEvent = canvasEvent;
    }

    public PDFTool getActiveTool() {
        return activeTool;
    }

    public void setActiveTool(PDFTool activeTool) {
        this.activeTool = activeTool;
    }

    public PenEraserSize getPenSize() {
        return penSize;
    }

    public void setPenSize(PenEraserSize penSize) {
        this.penSize = penSize;
    }

    public PenEraserSize getEraserSize() {
        return eraserSize;
    }

    public void setEraserSize(PenEraserSize eraserSize) {
        this.eraserSize = eraserSize;
    }

    public PenColor getPenColor() {
        return penColor;
    }

    public void setPenColor(PenColor penColor) {
        this.penColor = penColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CanvasEventLog that = (CanvasEventLog) o;
        return eventType == that.eventType && Objects.equals(canvasEvent, that.canvasEvent) && activeTool == that.activeTool && penSize == that.penSize && eraserSize == that.eraserSize && penColor == that.penColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType, canvasEvent, activeTool, penSize, eraserSize, penColor);
    }

    @Override
    public String toString() {
        return "CanvasEventLog{" +
                "eventType=" + eventType +
                ", canvasEvent=" + canvasEvent +
                ", activeTool=" + activeTool +
                ", penSize=" + penSize +
                ", eraserSize=" + eraserSize +
                ", penColor=" + penColor +
                '}';
    }
}
