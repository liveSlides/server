package com.harun.liveSlideServer.service;

import com.harun.liveSlideServer.db.SessionsDatabase;
import com.harun.liveSlideServer.dto.slide.CanvasEvent;
import com.harun.liveSlideServer.enums.*;
import com.harun.liveSlideServer.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


@Service
public class SlideService {
    public SessionsDatabase database;

    @Autowired
    public SlideService(SessionsDatabase database) {
        this.database =  database;
    }

    public void setSessionCurrentFileName(String sessionID ,String fileName) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setCurrentFileName(fileName);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionHostScreenWidth(String sessionID, double hostScreenWidth) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setHostScreenWidth(hostScreenWidth);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionCurrentIndex(String sessionID, int index) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setCurrentIndex(index);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionHValue(String sessionID, double hValue) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.sethValue(hValue);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionVValue(String sessionID, double vValue) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setvValue(vValue);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionZoomRate(String sessionID, int zoomRate) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setZoomRate(zoomRate);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionRotateRate(String sessionID, int rotateRate) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setRotateRate(rotateRate);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionActiveTool(String sessionID, PDFTool activeTool) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setActiveTool(activeTool);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionPenSize(String sessionID, PenEraserSize size) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setPenSize(size);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionPenColor(String sessionID, PenColor color) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setPenColor(color);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionEraserSize(String sessionID, PenEraserSize size) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setEraserSize(size);
        else
            System.out.println("Session bulunamadı.");
    }

    public void setSessionPageCount(String sessionID, int pageCount) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setPageCount(pageCount);
        else
            System.out.println("Session bulunamadı.");
    }

    public void initializeCanvasEventLogs(String sessionID) {
        Session session = database.sessions.get(sessionID);
        if (session != null){
            int pageCount = session.getPageCount();

            if (session.getCanvasEvents() != null)
                session.setCanvasEvents(null);

            session.setCanvasEvents(new LinkedList[pageCount]);
            session.initializeCanvasEventsEmpty();
        }

        else
            System.out.println("Session bulunamadı.");
    }

    public void addCanvasEvent(String sessionID, CanvasEvent event, CanvasEventType canvasEventType) {
        Session session = database.sessions.get(sessionID);
        if (session != null){
            if (session.getCanvasEvents() == null)
                return;

            session.getCanvasEvents()[session.getCurrentIndex() - 1].add(
                    new CanvasEventLog(
                            canvasEventType,
                            event,
                            session.getActiveTool(),
                            session.getPenSize(),
                            session.getEraserSize(),
                            session.getPenColor()
                    )
            );
        }
        else
            System.out.println("Session bulunamadı.");
    }
}
