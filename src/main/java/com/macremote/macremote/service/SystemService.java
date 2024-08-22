package com.macremote.macremote.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SystemService {
    public String systemExecuteCommand(String[] command, String key) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            return key+" Success";
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return key+" Failed" + e.getMessage();
        }
    }
}
