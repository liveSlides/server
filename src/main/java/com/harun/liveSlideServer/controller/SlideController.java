package com.harun.liveSlideServer.controller;

import com.harun.liveSlideServer.dto.*;
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
    public void pageChanged(@DestinationVariable String sessionID , int index) {
        slideService.setSessionCurrentIndex(sessionID,index);
        messagingTemplate.convertAndSend("/topic/pageChanged/" + sessionID  , index);
    }

    @MessageMapping("/fileUploaded/{sessionID}")
    public void uploadPDF(@DestinationVariable String sessionID,
                          String fileName) {

        slideService.setSessionCurrentFileName(fileName,sessionID);
        UploadPDFResponse uploadPDFResponse = new UploadPDFResponse(ResponseStatus.SUCCESS,fileName);
        messagingTemplate.convertAndSend("/topic/fileUploaded/" + sessionID  , uploadPDFResponse);
    }

    @MessageMapping("/scrolledHorizontally/{sessionID}")
    public void scrolledHorizontally(@DestinationVariable String sessionID,
                          double hValue) {
        slideService.setSessionHValue(sessionID,hValue);
        messagingTemplate.convertAndSend("/topic/scrolledHorizontally/" + sessionID  , hValue);
    }

    @MessageMapping("/scrolledVertically/{sessionID}")
    public void scrolledVertically(@DestinationVariable String sessionID,
                                     double vValue) {
        slideService.setSessionVValue(sessionID,vValue);
        messagingTemplate.convertAndSend("/topic/scrolledVertically/" + sessionID  , vValue);
    }

    @MessageMapping("/zoomed/{sessionID}")
    public void zoomed(@DestinationVariable String sessionID,
                                   int zoomRate) {
        slideService.setSessionZoomRate(sessionID,zoomRate);
        messagingTemplate.convertAndSend("/topic/zoomed/" + sessionID  , zoomRate);
    }

    @MessageMapping("/rotated/{sessionID}")
    public void rotated(@DestinationVariable String sessionID,
                       int rotateRate) {
        slideService.setSessionRotateRate(sessionID,rotateRate);
        messagingTemplate.convertAndSend("/topic/rotated/" + sessionID  , rotateRate);
    }

}
