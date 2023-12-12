package com.harun.liveSlideServer.service;

import com.harun.liveSlideServer.dto.SessionCreationRequest;
import com.harun.liveSlideServer.dto.SessionJoinRequest;
import com.harun.liveSlideServer.exception.SessionAlreadyExistException;
import com.harun.liveSlideServer.exception.SessionIsNotExistException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class SessionService {
    private final Map<String, Set<String>> sessions = new HashMap<>();

    public void createSession(SessionCreationRequest info) throws SessionAlreadyExistException {
        if (sessions.containsKey(info.getSessionID()))
            throw new SessionAlreadyExistException();

        sessions.putIfAbsent(info.getSessionID(), new HashSet<>());
        sessions.getOrDefault(info.getSessionID(), new HashSet<>()).add(info.getHostName());
    }

    public void joinSession(SessionJoinRequest info) throws SessionIsNotExistException {
        if (!sessions.containsKey(info.getSessionID()))
            throw new SessionIsNotExistException();

        sessions.getOrDefault(info.getSessionID(), new HashSet<>()).add(info.getParticipantName());
    }

    public Set<String> getParticipants(String sessionId) {
        return sessions.getOrDefault(sessionId, new HashSet<>());
    }
}
