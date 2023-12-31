package com.harun.liveSlideServer.dto;

import com.harun.liveSlideServer.enums.PDFTool;
import com.harun.liveSlideServer.enums.PenColor;
import com.harun.liveSlideServer.enums.PenEraserSize;

import java.util.Objects;

public class MeetingSynchInformationResponse {
    private String fileName;
    private int index;
    private int zoomRate;
    private double hScrollValue;
    private double vScrollValue;
    private int rotateRate;
    private PDFTool activeTool;
    private PenEraserSize penSize;
    private PenColor penColor;
    private PenEraserSize eraserSize;
    private String presenterName;

    public MeetingSynchInformationResponse() {

    }

    public MeetingSynchInformationResponse(String fileName,
                                           int index,
                                           int zoomRate,
                                           double hScrollValue,
                                           double vScrollValue,
                                           int rotateRate,
                                           PDFTool activeTool,
                                           PenEraserSize penSize,
                                           PenColor penColor,
                                           PenEraserSize eraserSize,
                                           String presenterName) {
        this.fileName = fileName;
        this.index = index;
        this.zoomRate = zoomRate;
        this.hScrollValue = hScrollValue;
        this.vScrollValue = vScrollValue;
        this.rotateRate = rotateRate;
        this.activeTool = activeTool;
        this.penSize = penSize;
        this.penColor = penColor;
        this.eraserSize = eraserSize;
        this.presenterName = presenterName;
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

    public int getRotateRate() {
        return rotateRate;
    }

    public void setRotateRate(int rotateRate) {
        this.rotateRate = rotateRate;
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

    public PenColor getPenColor() {
        return penColor;
    }

    public void setPenColor(PenColor penColor) {
        this.penColor = penColor;
    }

    public PenEraserSize getEraserSize() {
        return eraserSize;
    }

    public void setEraserSize(PenEraserSize eraserSize) {
        this.eraserSize = eraserSize;
    }

    public String getPresenterName() {
        return presenterName;
    }

    public void setPresenterName(String presenterName) {
        this.presenterName = presenterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingSynchInformationResponse that = (MeetingSynchInformationResponse) o;
        return index == that.index && zoomRate == that.zoomRate && Double.compare(hScrollValue, that.hScrollValue) == 0 && Double.compare(vScrollValue, that.vScrollValue) == 0 && rotateRate == that.rotateRate && Objects.equals(fileName, that.fileName) && activeTool == that.activeTool && penSize == that.penSize && penColor == that.penColor && eraserSize == that.eraserSize && Objects.equals(presenterName, that.presenterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, index, zoomRate, hScrollValue, vScrollValue, rotateRate, activeTool, penSize, penColor, eraserSize, presenterName);
    }

    @Override
    public String toString() {
        return "MeetingSynchInformationResponse{" +
                "fileName='" + fileName + '\'' +
                ", index=" + index +
                ", zoomRate=" + zoomRate +
                ", hScrollValue=" + hScrollValue +
                ", vScrollValue=" + vScrollValue +
                ", rotateRate=" + rotateRate +
                ", activeTool=" + activeTool +
                ", penSize=" + penSize +
                ", penColor=" + penColor +
                ", eraserSize=" + eraserSize +
                ", presenterName='" + presenterName + '\'' +
                '}';
    }
}
