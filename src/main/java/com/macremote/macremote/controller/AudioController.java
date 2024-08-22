package com.macremote.macremote.controller;

import com.macremote.macremote.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AudioController {

    private final AudioService audioService;

    @Autowired
    public AudioController(AudioService audioService) {
        this.audioService = audioService;
    }

    @GetMapping ("/volume")
    public String increaseVolume(@RequestParam int level) {
        String[] command = { "osascript", "-e", "set volume output volume " + level };
        return audioService.increaseVolumeService(command,"volume");
    }

    @GetMapping("/space")
    public  String space() {
        String[] command = {
                "osascript",
                "-e",
                "tell application \"System Events\" to key code 49"
        };
        return audioService.increaseVolumeService(command,"space bar");
    }

    @GetMapping("/spotify/playpause")
    public String spotifyPlayPause() {
        String[] command = { "osascript", "-e", "tell application \"Spotify\" to playpause" };
        return audioService.increaseVolumeService(command,"spotify play/pause");
    }

    @GetMapping("/arrow")
    public String chromeFastForward(@RequestParam int type) {
        String[] command = {
                "osascript",
                "-e",
                "tell application \"System Events\" to key code " + type
        };
        return audioService.increaseVolumeService(command,type+" Arrow");
    }

    @GetMapping("/skipad")
    public String skipYouTubeAd() {
        String[] command = {
                "osascript",
                "-e",
                "tell application \"Google Chrome\" to tell active tab of front window to execute javascript \"document.querySelector('.ytp-ad-skip-button').click();\""
        };
        return audioService.increaseVolumeService(command,"Skip Ad on YouTube");
    }
}
