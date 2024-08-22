package com.macremote.macremote.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AudioService {
    public String increaseVolumeService(String[] command, String key) {
        try {
            // Execute the AppleScript command to increase the volume

//            String[] command = { "osascript", "-e", "set volume output volume 100" };
//            String[] command = { "osascript", "-e", "tell application \"Spotify\" to playpause" };
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            return key+" Success";
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return key+" Failed" + e.getMessage();
        }
    }
}
