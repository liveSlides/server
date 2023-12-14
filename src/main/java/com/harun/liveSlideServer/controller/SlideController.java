package com.harun.liveSlideServer.controller;

import com.harun.liveSlideServer.dto.*;
import com.harun.liveSlideServer.service.SessionService;
import com.harun.liveSlideServer.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@Controller
public class SlideController {
    private SlideService slideService;
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public SlideController(SlideService slideService,SimpMessagingTemplate messagingTemplate){
        this.slideService = slideService;
        this.messagingTemplate = messagingTemplate;
    }


    @MessageMapping("/uploadPDF/{sessionID}/{userID}/{fileName}/{fileSize}")
    public void uploadPDF(@DestinationVariable String sessionID,
                          @DestinationVariable String userID,
                          @DestinationVariable String fileName,
                          @DestinationVariable double fileSize,
                          String base64Data) {

        long writtenSize = slideService.uploadPDF(sessionID,userID,fileName,fileSize,base64Data);

        // If reached the file length then invoke the file is uploaded all participants
        if (writtenSize >= fileSize) {
            slideService.setSessionCurrentFileName(sessionID,fileName);

            UploadPDFResponse response = new UploadPDFResponse(ResponseStatus.SUCCESS);
            messagingTemplate.convertAndSend("/topic/uploadPDF/" + sessionID , response);
        }
        // Request to sequent parts of PDF
        else {
            UploadPartOfPDFResponse partResponse = new UploadPartOfPDFResponse(ResponseStatus.SUCCESS);
            messagingTemplate.convertAndSend("/topic/uploadPartOfPDF/" + sessionID + "/" + userID , partResponse);
        }
    }
}
