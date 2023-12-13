package com.harun.liveSlideServer.dto;

import com.harun.liveSlideServer.model.Participant;

import java.util.Set;

public class SessionParticipantsResponse {
    private String sessionId;
    private Set<Participant> participants;

    public SessionParticipantsResponse() {

    }

    public SessionParticipantsResponse(String sessionId , Set<Participant> participants) {
        this.sessionId = sessionId;
        this.participants = participants;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "SessionParticipantsResponse{" +
                "sessionId='" + sessionId + '\'' +
                ", participants=" + participants +
                '}';
    }
}
