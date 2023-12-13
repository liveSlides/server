package com.harun.liveSlideServer.controller;

import com.harun.liveSlideServer.dto.*;
import com.harun.liveSlideServer.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class SessionController {
    private SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @MessageMapping("/startSession")
    @SendTo("/topic/sessionStatus")
    public SessionInitialResponse startSession(SessionCreationRequest request) {
        System.out.println(request);
        SessionInitialResponse res = sessionService.createSession(request);
        System.out.println(res);
        return res;
    }

    @MessageMapping("/joinSession")
    @SendTo("/topic/sessionStatus")
    public SessionInitialResponse joinSession(SessionJoinRequest request) {
        System.out.println(request);
        return sessionService.joinSession(request);
    }
}
