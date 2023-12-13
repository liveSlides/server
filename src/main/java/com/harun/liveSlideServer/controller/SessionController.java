package com.harun.liveSlideServer.controller;

import com.harun.liveSlideServer.dto.*;
import com.harun.liveSlideServer.model.Participant;
import com.harun.liveSlideServer.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Set;

@Controller
public class SessionController {
    private SessionService sessionService;
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public SessionController(SessionService sessionService,SimpMessagingTemplate messagingTemplate){
        this.sessionService = sessionService;
        this.messagingTemplate = messagingTemplate;
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

    @MessageMapping("/getParticipants")
    public void getParticipants(SessionParticipantsRequest request) {
        System.out.println("Participant Request geldi :" + request);
        SessionParticipantsResponse response = sessionService.getParticipants(request);
        System.out.println("Response : " + response);
        messagingTemplate.convertAndSend("/topic/getParticipants", response);
    }
}
