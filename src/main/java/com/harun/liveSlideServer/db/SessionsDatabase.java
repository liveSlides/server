package com.harun.liveSlideServer.db;

import com.harun.liveSlideServer.model.Session;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SessionsDatabase {
    public Map<String, Session> sessions = new HashMap<>();
}
