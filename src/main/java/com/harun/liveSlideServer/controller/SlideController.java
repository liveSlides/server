package com.harun.liveSlideServer.controller;

import com.harun.liveSlideServer.dto.*;
import com.harun.liveSlideServer.dto.meeting.PageChangedRequest;
import com.harun.liveSlideServer.dto.meeting.PageChangedResponse;
import com.harun.liveSlideServer.service.SessionService;
import com.harun.liveSlideServer.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class SlideController {
    private SlideService slideService;
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public SlideController(SlideService slideService,SimpMessagingTemplate messagingTemplate){
        this.slideService = slideService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/pageChanged/{sessionID}")
    public void pageChanged(@DestinationVariable String sessionID , PageChangedRequest request) {
        PageChangedResponse pageChangedResponse = new PageChangedResponse(
                request.getIndex(),
                request.getCanvasBase64(),
                request.getPageBase64());
        messagingTemplate.convertAndSend("/topic/pageChanged/" + sessionID  , pageChangedResponse);
    }

    @MessageMapping("/fileUploaded/{sessionID}")
    public void uploadPDF(@DestinationVariable String sessionID,
                          String fileName) {

        slideService.setSessionCurrentFileName(fileName,sessionID);
        UploadPDFResponse uploadPDFResponse = new UploadPDFResponse(ResponseStatus.SUCCESS,fileName);
        messagingTemplate.convertAndSend("/topic/fileUploaded/" + sessionID  , uploadPDFResponse);
    }

}
