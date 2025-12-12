package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoController {

    @GetMapping("/video-chat")
    public String videoChat() {
        return "video-chat";
    }
}