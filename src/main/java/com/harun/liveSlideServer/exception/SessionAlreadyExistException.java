package com.harun.liveSlideServer.exception;

public class SessionAlreadyExistException extends Exception{
    @Override
    public String getMessage() {
        return "Session is already exist";
    }
}
