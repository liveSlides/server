package com.harun.liveSlideServer.service;

import com.harun.liveSlideServer.db.SessionsDatabase;
import com.harun.liveSlideServer.dto.*;
import com.harun.liveSlideServer.dto.MeetingSynchInformationResponse;
import com.harun.liveSlideServer.enums.CanvasEventLog;
import com.harun.liveSlideServer.enums.UserType;
import com.harun.liveSlideServer.model.Participant;
import com.harun.liveSlideServer.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
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
                new Participant(request.getUserID(), request.getHostName(), UserType.HOST_PRESENTER, false));
        database.sessions.put(request.getSessionID(), newSession);

        return new SessionInitialResponse(request.getSessionID(), ResponseStatus.SUCCESS, SessionInitializeType.HOST, creationTime);
    }

    public SessionInitialResponse joinSession (SessionJoinRequest request){
        if (!database.sessions.containsKey(request.getSessionID()))
            return new SessionInitialResponse("", ResponseStatus.ERROR, SessionInitializeType.JOIN, LocalDateTime.now());

        Session session = database.sessions.get(request.getSessionID());
        session.getParticipants().put(request.getUserID(),
                new Participant(request.getUserID(), request.getParticipantName(), UserType.PARTICIPANT_SPECTATOR, false));

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

    public MeetingSynchInformationResponse getMeetingSynchInformation(String sessionID) {
        MeetingSynchInformationResponse response = new MeetingSynchInformationResponse();
        Session session = database.sessions.get(sessionID);

        if (session == null)
            return new MeetingSynchInformationResponse();

        response.setFileName(session.getCurrentFileName());
        response.setIndex(session.getCurrentIndex());
        response.sethScrollValue(session.gethValue());
        response.setvScrollValue(session.getvValue());
        response.setZoomRate(session.getZoomRate());
        response.setRotateRate(session.getRotateRate());
        response.setActiveTool(session.getActiveTool());
        response.setPenSize(session.getPenSize());
        response.setPenColor(session.getPenColor());
        response.setEraserSize(session.getEraserSize());
        response.setPresenterName(getMeetingPresenterName(sessionID));

        return response;
    }

    public String getMeetingFileName(String sessionID) {
        Session session = database.sessions.get(sessionID);

        if (session == null)
            return null;

        return session.getCurrentFileName();
    }

    public LinkedList<CanvasEventLog>[] getMeetingCanvasEventLog(String sessionID) {
        Session session = database.sessions.get(sessionID);

        if (session == null)
            return null;

        return session.getCanvasEvents();
    }

    public double getMeetingHostScreenWidth(String sessionID) {
        Session session = database.sessions.get(sessionID);

        if (session == null)
            return -1;

        return session.getHostScreenWidth();
    }

    public void changeUserControlRequest(String sessionID, String userID, boolean isRequestControl) {
        Session session = database.sessions.get(sessionID);
        if (session != null && session.getParticipants().containsKey(userID)) {
            Participant participant = session.getParticipants().get(userID);
            participant.setRequestingControl(isRequestControl);
        }
    }

    public String changePresenter(String sessionID, String userID) {
        String userName = "";
        Session session = database.sessions.get(sessionID);
        if (session != null && session.getParticipants().containsKey(userID)) {
            for (Participant p : session.getParticipants().values()) {
                if (p.getUserType() == UserType.HOST_PRESENTER && !p.getUserID().equals(userID)) {
                    p.setUserType(UserType.HOST_SPECTATOR);
                }
                else if (p.getUserType() == UserType.PARTICIPANT_PRESENTER && !p.getUserID().equals(userID)) {
                    p.setUserType(UserType.PARTICIPANT_SPECTATOR);
                }
                else if (p.getUserType() == UserType.HOST_SPECTATOR && p.getUserID().equals(userID)) {
                    p.setUserType(UserType.HOST_PRESENTER);
                    userName = p.getName();
                }
                else if (p.getUserType() == UserType.PARTICIPANT_SPECTATOR && p.getUserID().equals(userID)) {
                    p.setUserType(UserType.PARTICIPANT_PRESENTER);
                    p.setRequestingControl(false);
                    userName = p.getName();
                }
            }
        }

        return userName;
    }

    public String getMeetingPresenterName(String sessionID) {
        Session session = database.sessions.get(sessionID);

        if (session != null) {
            for (Participant p : session.getParticipants().values()) {
                if (p.getUserType() == UserType.HOST_PRESENTER || p.getUserType() == UserType.PARTICIPANT_PRESENTER) {
                    return p.getName();
                }
            }
        }

        return "";
    }
}
