package com.harun.liveSlideServer.service;

import com.harun.liveSlideServer.db.SessionsDatabase;
import com.harun.liveSlideServer.dto.ResponseStatus;
import com.harun.liveSlideServer.dto.UploadPDFRequest;
import com.harun.liveSlideServer.dto.UploadPDFResponse;
import com.harun.liveSlideServer.dto.UploadPartOfPDFResponse;
import com.harun.liveSlideServer.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class SlideService {
    public SessionsDatabase database;

    @Autowired
    public SlideService(SessionsDatabase database) {
        this.database =  database;
    }

    public long uploadPDF(String sessionID, String userID, String fileName, double fileSize,String base64Data) {
        // Decode Base64 data
        byte[] chunk = Base64.getDecoder().decode(base64Data);

        // Get Folder
        String serverFolderPath = "src/userSlides";
        String folderPath = serverFolderPath + File.separator + sessionID;
        File folder = new File(folderPath);

        // Create the parent directories if they don't exist
        if (!folder.exists() && !folder.mkdirs()) {
            throw new RuntimeException("Failed to create directory: " + folderPath);
        }

        // Get File
        String filePath = folderPath + File.separator + fileName;
        File file = new File(filePath);

        // Create the file if it doesn't exist
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    throw new RuntimeException("Failed to create file: " + filePath);
                }
            } catch (IOException e) {
                throw new RuntimeException("Error creating file: " + filePath, e);
            }
        }

        // Append the bytes to the file
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(chunk);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }

        return file.length();

    }

    public void setSessionCurrentFileName(String sessionID,String fileName) {
        Session session = database.sessions.get(sessionID);
        if (session != null) {
            session.setCurrentFileName(fileName);
        }
    }
}
