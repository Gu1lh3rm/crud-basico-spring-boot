package com.guilherme.cadastro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SaudeController {

    @GetMapping
    public String saude() {
        return "Api esta up";
    }

}
