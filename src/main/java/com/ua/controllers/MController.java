package com.ua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MController {
    @GetMapping("/")
    public String main(){
        return "main";
    }
}
