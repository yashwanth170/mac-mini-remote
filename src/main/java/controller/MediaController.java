package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MediaController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/play")
    public String play() throws IOException {
        executeCommand("osascript -e 'tell application \"QuickTime Player\" to play'");
        return "redirect:/";
    }

    @GetMapping("/pause")
    public String pause() throws IOException {
        executeCommand("osascript -e 'tell application \"QuickTime Player\" to pause'");
        return "redirect:/";
    }

    @GetMapping("/volume/up")
    public String volumeUp() throws IOException {
        executeCommand("osascript -e 'set volume output volume (output volume of (get volume settings) + 10)'");
        return "redirect:/";
    }

    @GetMapping("/volume/down")
    public String volumeDown() throws IOException {
        executeCommand("osascript -e 'set volume output volume (output volume of (get volume settings) - 10)'");
        return "redirect:/";
    }

    private void executeCommand(String command) throws IOException {
        Runtime.getRuntime().exec(command);
    }
}
