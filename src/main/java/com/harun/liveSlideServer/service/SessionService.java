package com.harun.liveSlideServer.service;

import com.harun.liveSlideServer.db.SessionsDatabase;
import com.harun.liveSlideServer.dto.*;
import com.harun.liveSlideServer.dto.meeting.MeetingInitialInformationResponse;
import com.harun.liveSlideServer.enums.UserType;
import com.harun.liveSlideServer.model.Participant;
import com.harun.liveSlideServer.model.Session;
import com.harun.liveSlideServer.util.FolderDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Service
public class SessionService {
    public SessionsDatabase database;

    @Autowired
    public SessionService(SessionsDatabase database) {
        this.database =  database;
    }

    public SessionInitialResponse createSession(SessionCreationRequest request) {
        if (database.sessions.containsKey(request.getSessionID()))
            return new SessionInitialResponse("", ResponseStatus.ERROR, SessionInitializeType.HOST, LocalDateTime.now());

        LocalDateTime creationTime = LocalDateTime.now();
        Session newSession = new Session(request.getSessionID(), creationTime);
        newSession.getParticipants().put(request.getUserID(),
                new Participant(request.getUserID(), request.getHostName(), UserType.HOST_PRESENTER));
        database.sessions.put(request.getSessionID(), newSession);

        return new SessionInitialResponse(request.getSessionID(), ResponseStatus.SUCCESS, SessionInitializeType.HOST, creationTime);
    }

    public SessionInitialResponse joinSession (SessionJoinRequest request){
        if (!database.sessions.containsKey(request.getSessionID()))
            return new SessionInitialResponse("", ResponseStatus.ERROR, SessionInitializeType.JOIN, LocalDateTime.now());

        Session session = database.sessions.get(request.getSessionID());
        session.getParticipants().put(request.getUserID(),
                new Participant(request.getUserID(), request.getParticipantName(), UserType.PARTICIPANT_SPECTATOR));

        return new SessionInitialResponse(request.getSessionID(), ResponseStatus.SUCCESS, SessionInitializeType.JOIN, session.getCreationTime());
    }

    public SessionParticipantsResponse getParticipants(SessionParticipantsRequest request) {
        Set<Participant> participants = getParticipantObjects(request.getSessionId());
        return new SessionParticipantsResponse(request.getSessionId(), participants);
    }

    private Set<Participant> getParticipantObjects(String sessionId) {
        Session session = database.sessions.get(sessionId);
        return session != null ? new HashSet<>(session.getParticipants().values()) : Set.of();
    }

    public Session getSession (String sessionId){
        return database.sessions.get(sessionId);
    }

    public DisconnectResponse disconnect(DisconnectRequest request) {
        Session session = database.sessions.get(request.getSessionID());
        if (session != null && session.getParticipants().containsKey(request.getUserID())) {
            session.getParticipants().remove(request.getUserID());

            if (session.getParticipants().isEmpty()){
                closeSession(session.getSessionID());
            }

            return new DisconnectResponse(ResponseStatus.SUCCESS);
        } else {
            return new DisconnectResponse(ResponseStatus.ERROR);
        }
    }

    private void closeSession(String sessionID) {
        database.sessions.remove(sessionID);
    }

    public MeetingInitialInformationResponse getMeetingInitialInformation(String sessionID) {
        MeetingInitialInformationResponse response = new MeetingInitialInformationResponse();
        Session session = database.sessions.get(sessionID);

        if (session == null)
            return new MeetingInitialInformationResponse();

        response.setFileName(session.getCurrentFileName());
        //TODO index , hValue , vValue etc.

        return response;
    }
}
