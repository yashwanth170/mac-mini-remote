package com.macremote.macremote.controller;

import com.macremote.macremote.service.SystemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    private final SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/sleep")
    public String putToSleep() {
        String[] command = {"osascript", "-e", "tell application \"System Events\" to sleep"};
        return systemService.systemExecuteCommand(command, "Put Mac to Sleep");
    }

    @GetMapping("/shutdown")
    public String shutdownMac() {
        String[] command = {
                "osascript",
                "-e",
                "tell application \"System Events\" to shut down"
        };
        return systemService.systemExecuteCommand(command, "Shutdown Mac");
    }
}
