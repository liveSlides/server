package com.harun.liveSlideServer.util;

import java.io.File;

public class FolderDeleter {
    public static void deleteFolder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteFolder(file);
                }
            }
        }
        if (!folder.delete()) {
            System.err.println("Failed to delete folder: " + folder.getAbsolutePath());
        }
    }
}
