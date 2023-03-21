package com.drivas.springstatemachine.controller;

import com.drivas.springstatemachine.model.EventsDto;
import com.drivas.springstatemachine.service.StateMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class StateMachineController {

    private final StateMachineService stateMachineService;

    @Autowired
    public StateMachineController(StateMachineService stateMachineService) {
        this.stateMachineService = stateMachineService;
    }

    @GetMapping(path = "")
    public String getBook() {
        return "teste get";
    }

    @PostMapping(path = "/events")
    public ResponseEntity postEvent(@RequestBody EventsDto events){
        return stateMachineService.publishEvent(events);
    }

    @PostMapping(path = "/events-entrypoint")
    public ResponseEntity eventEntry(@RequestBody EventsDto events){
        stateMachineService.entryPoint(events);
        return ResponseEntity.ok("ok");
    }

}
