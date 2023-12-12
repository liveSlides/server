package com.harun.liveSlideServer.controller;

import com.harun.liveSlideServer.dto.*;
import com.harun.liveSlideServer.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SessionController {
    private SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @MessageMapping("/startSession")
    @SendTo("/topic/sessionStatus")
    public SessionInitialResponse startSession(SessionCreationRequest info) {
        System.out.println(info);
        try {
            sessionService.createSession(info);
            System.out.println("Session is created : " + info.getSessionID());
            System.out.println("Host : " + info.getHostName());
            return new SessionInitialResponse(info.getSessionID(), ResponseStatus.SUCCESS , SessionInitializeType.HOST);
        }
        catch (Exception e) {
            return new SessionInitialResponse("", ResponseStatus.ERROR , SessionInitializeType.HOST);
        }
    }

    @MessageMapping("/joinSession")
    @SendTo("/topic/sessionStatus")
    public SessionInitialResponse joinSession(SessionJoinRequest info) {
        System.out.println(info);
        try {
            sessionService.joinSession(info);
            System.out.println("A user joined to session : " + info.getSessionID());
            System.out.println("Participant : " + info.getParticipantName());
            return new SessionInitialResponse(info.getSessionID(), ResponseStatus.SUCCESS, SessionInitializeType.JOIN);
        }
        catch (Exception e) {
            return new SessionInitialResponse(info.getSessionID(), ResponseStatus.ERROR, SessionInitializeType.JOIN);
        }
    }
}
