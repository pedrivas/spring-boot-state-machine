package com.drivas.springstatemachine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateMachineController {

    @GetMapping(path = "")
    public String getBook() {
        return "teste get";
    }

}
