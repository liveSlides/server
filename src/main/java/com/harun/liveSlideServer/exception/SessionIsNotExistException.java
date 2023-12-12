package com.harun.liveSlideServer.exception;

public class SessionIsNotExistException extends Exception{
    @Override
    public String getMessage() {
        return "Session is not exist";
    }
}
