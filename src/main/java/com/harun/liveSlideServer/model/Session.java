package com.harun.liveSlideServer.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Session {
    private String sessionID;
    private Map<String, Participant> participants;
    private LocalDateTime creationTime;
    private String currentFileName;
    private int currentIndex = 1;

    public Session(String sessionID , LocalDateTime creationTime) {
        this.sessionID = sessionID;
        this.participants = new HashMap<>();
        this.creationTime = creationTime;
    }

    // Getter and Setter methods
    public String getSessionID() {
        return sessionID;
    }

    public Map<String, Participant> getParticipants() {
        return participants;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getCurrentFileName() {
        return currentFileName;
    }

    public void setCurrentFileName(String currentFileName) {
        this.currentFileName = currentFileName;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
