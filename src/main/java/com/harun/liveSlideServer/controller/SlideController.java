package com.harun.liveSlideServer.controller;

import com.harun.liveSlideServer.dto.*;
import com.harun.liveSlideServer.dto.slide.CanvasEvent;
import com.harun.liveSlideServer.dto.slide.PageChangedEvent;
import com.harun.liveSlideServer.dto.slide.PointedEvent;
import com.harun.liveSlideServer.dto.slide.UploadPDFResponse;
import com.harun.liveSlideServer.enums.PDFTool;
import com.harun.liveSlideServer.enums.PenColor;
import com.harun.liveSlideServer.enums.PenEraserSize;
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
    public void pageChanged(@DestinationVariable String sessionID , PageChangedEvent event) {
        slideService.setSessionCurrentIndex(sessionID,event.getIndex());
        slideService.setSessionZoomRate(sessionID,event.getZoomRate());
        slideService.setSessionVValue(sessionID,event.getvValue());
        slideService.setSessionHValue(sessionID,event.gethValue());
        messagingTemplate.convertAndSend("/topic/pageChanged/" + sessionID  , event);
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

    @MessageMapping("/activeToolChanged/{sessionID}")
    public void activeToolChanged(@DestinationVariable String sessionID,
                        PDFTool activeTool) {
        slideService.setSessionActiveTool(sessionID,activeTool);
        messagingTemplate.convertAndSend("/topic/activeToolChanged/" + sessionID  , activeTool);
    }

    @MessageMapping("/penSizeChanged/{sessionID}")
    public void penSizeChanged(@DestinationVariable String sessionID,
                                  PenEraserSize size) {
        slideService.setSessionPenSize(sessionID,size);
        messagingTemplate.convertAndSend("/topic/penSizeChanged/" + sessionID  , size);
    }

    @MessageMapping("/penColorChanged/{sessionID}")
    public void penColorChanged(@DestinationVariable String sessionID,
                                  PenColor color) {
        slideService.setSessionPenColor(sessionID,color);
        messagingTemplate.convertAndSend("/topic/penColorChanged/" + sessionID  , color);
    }

    @MessageMapping("/eraserSizeChanged/{sessionID}")
    public void eraserSizeChanged(@DestinationVariable String sessionID,
                                  PenEraserSize size) {
        slideService.setSessionEraserSize(sessionID,size);
        messagingTemplate.convertAndSend("/topic/eraserSizeChanged/" + sessionID  , size);
    }

    @MessageMapping("/pointed/{sessionID}")
    public void pointed(@DestinationVariable String sessionID,
                                  PointedEvent event) {
        messagingTemplate.convertAndSend("/topic/pointed/" + sessionID  , event);
    }

    @MessageMapping("/canvasPressed/{sessionID}")
    public void canvasPressed(@DestinationVariable String sessionID,
                        CanvasEvent event) {
        messagingTemplate.convertAndSend("/topic/canvasPressed/" + sessionID  , event);
    }

    @MessageMapping("/canvasDragged/{sessionID}")
    public void canvasDragged(@DestinationVariable String sessionID,
                        CanvasEvent event) {
        messagingTemplate.convertAndSend("/topic/canvasDragged/" + sessionID  , event);
    }

}
