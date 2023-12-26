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


}
