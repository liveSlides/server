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

import java.io.*;
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

            UploadPDFResponse response = new UploadPDFResponse(ResponseStatus.SUCCESS,fileName);
            System.out.println(response);
            messagingTemplate.convertAndSend("/topic/uploadPDF/" + sessionID , response);
        }
        // Request to sequent parts of PDF
        else {
            UploadPartOfPDFResponse partResponse = new UploadPartOfPDFResponse(ResponseStatus.SUCCESS);
            messagingTemplate.convertAndSend("/topic/uploadPartOfPDF/" + sessionID + "/" + userID , partResponse);
        }
    }

    @MessageMapping("/downloadPDF")
    public void downloadPDF(DownloadPDFRequest request) {
        System.out.println(request);

        // Get Folder
        String serverFolderPath = "src/userSlides";
        String folderPath = serverFolderPath + File.separator + request.getSessionID();
        File folder = new File(folderPath);

        // If folder doesn't exist then return with error
        if (!folder.exists()) {
            messagingTemplate.convertAndSend("/topic/downloadPartOfPDF/" +
                    request.getSessionID() + "/" +
                    request.getUserID() , new DownloadPartOfPDFResponse(ResponseStatus.ERROR,"",""));
            return;
        }

        // Get File Name
        String fileName = slideService.getSessionCurrentFileName(request.getSessionID());
        if (fileName == null) {
            messagingTemplate.convertAndSend("/topic/downloadPartOfPDF/" +
                    request.getSessionID() + "/" +
                    request.getUserID() , new DownloadPartOfPDFResponse(ResponseStatus.ERROR,"",""));
            return;
        }

        // Get File
        String filePath = folderPath + File.separator + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            messagingTemplate.convertAndSend("/topic/downloadPartOfPDF/" +
                    request.getSessionID() + "/" +
                    request.getUserID() , new DownloadPartOfPDFResponse(ResponseStatus.ERROR,"",""));
            return;
        }

        // Get File Size
        long fileSize = file.length();

        // Control if complete of file is sent already
        if (fileSize == request.getGatheredSize()) {
            messagingTemplate.convertAndSend("/topic/downloadPDF/" +
                    request.getSessionID() + "/" +
                    request.getUserID() , new DownloadPDFResponse(ResponseStatus.SUCCESS,fileName));
            return;
        }

        // Get File Input Stream
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            messagingTemplate.convertAndSend("/topic/downloadPartOfPDF/" +
                    request.getSessionID() + "/" +
                    request.getUserID() , new DownloadPartOfPDFResponse(ResponseStatus.ERROR,"",""));
            return;
        }

        int chunkSize = 1024 * 1024;
        byte[] buffer = new byte[chunkSize];
        int bytesRead = 0;
        int totalReadBytes = 0;
        byte[] actualBytesRead = null;

        try {
            while (true) {
                if (bytesRead == -1){
                    break;
                }

                if(totalReadBytes > request.gatheredSize) {
                    actualBytesRead = bytesRead < chunkSize ? Arrays.copyOf(buffer, bytesRead) : buffer;
                    break;
                }
                bytesRead = fileInputStream.read(buffer);

                totalReadBytes += bytesRead;
            }

            // Encode the chunk as Base64 before sending
            String base64Chunk = Base64.getEncoder().encodeToString(actualBytesRead);

            //Send the response as part of slide
            DownloadPartOfPDFResponse response = new DownloadPartOfPDFResponse(ResponseStatus.SUCCESS,fileName,base64Chunk);
            messagingTemplate.convertAndSend("/topic/downloadPartOfPDF/" +
                    request.getSessionID() + "/" +
                    request.getUserID() , response);

        }catch (Exception e) {
            messagingTemplate.convertAndSend("/topic/downloadPartOfPDF/" +
                    request.getSessionID() + "/" +
                    request.getUserID() , new DownloadPartOfPDFResponse(ResponseStatus.ERROR,"",""));
        }
    }
}
