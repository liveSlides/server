package com.harun.liveSlideServer.service;

import com.harun.liveSlideServer.db.SessionsDatabase;
import com.harun.liveSlideServer.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SlideService {
    public SessionsDatabase database;

    @Autowired
    public SlideService(SessionsDatabase database) {
        this.database =  database;
    }

    public void setSessionCurrentFileName(String fileName, String sessionID) {
        Session session = database.sessions.get(sessionID);
        if (session != null)
            session.setCurrentFileName(fileName);
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
}
