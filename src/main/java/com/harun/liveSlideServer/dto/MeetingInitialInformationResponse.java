package com.harun.liveSlideServer.dto;

import com.harun.liveSlideServer.enums.CanvasEventLog;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class MeetingInitialInformationResponse {
    private String fileName;
    private LinkedList<CanvasEventLog>[] canvasEvents;
    private double hostScreenWidth;


    public MeetingInitialInformationResponse() {

    }

    public MeetingInitialInformationResponse(String fileName , LinkedList<CanvasEventLog>[] canvasEvents, double hostScreenWidth) {
        this.fileName = fileName;
        this.canvasEvents = canvasEvents;
        this.hostScreenWidth = hostScreenWidth;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LinkedList<CanvasEventLog>[] getCanvasEvents() {
        return canvasEvents;
    }

    public void setCanvasEvents(LinkedList<CanvasEventLog>[] canvasEvents) {
        this.canvasEvents = canvasEvents;
    }

    public double getHostScreenWidth() {
        return hostScreenWidth;
    }

    public void setHostScreenWidth(double hostScreenWidth) {
        this.hostScreenWidth = hostScreenWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingInitialInformationResponse that = (MeetingInitialInformationResponse) o;
        return Double.compare(hostScreenWidth, that.hostScreenWidth) == 0 && Objects.equals(fileName, that.fileName) && Arrays.equals(canvasEvents, that.canvasEvents);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fileName, hostScreenWidth);
        result = 31 * result + Arrays.hashCode(canvasEvents);
        return result;
    }

    @Override
    public String toString() {
        return "MeetingInitialInformationResponse{" +
                "fileName='" + fileName + '\'' +
                ", canvasEvents=" + Arrays.toString(canvasEvents) +
                ", hostScreenWidth=" + hostScreenWidth +
                '}';
    }
}

