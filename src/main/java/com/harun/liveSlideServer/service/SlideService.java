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

}
