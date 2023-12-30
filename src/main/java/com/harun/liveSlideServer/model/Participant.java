package com.harun.liveSlideServer.model;

import com.harun.liveSlideServer.enums.UserType;

public class Participant {
    private String userID;
    private String name;
    private UserType userType;
    private boolean isRequestingControl;

    public Participant() {

    }

    public Participant(String userID, String name, UserType userType, boolean isRequestingControl) {
        this.userID = userID;
        this.name = name;
        this.userType = userType;
    }

    // Getter and Setter methods
    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public boolean isRequestingControl() {
        return isRequestingControl;
    }

    public void setRequestingControl(boolean requestingControl) {
        isRequestingControl = requestingControl;
    }
}
