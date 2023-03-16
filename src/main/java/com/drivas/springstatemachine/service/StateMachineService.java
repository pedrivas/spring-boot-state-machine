package com.drivas.springstatemachine.service;

import com.drivas.springstatemachine.model.Events;
import com.drivas.springstatemachine.model.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public class StateMachineService {

    private final StateMachine<States, Events> stateMachine;

    @Autowired
    public StateMachineService(StateMachine<States, Events> stateMachine) {
        this.stateMachine = stateMachine;
    }
}
