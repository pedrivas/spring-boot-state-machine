package com.drivas.springstatemachine.service;

import com.drivas.springstatemachine.model.Events;
import com.drivas.springstatemachine.model.EventsDto;
import com.drivas.springstatemachine.model.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;

@Service
public class StateMachineService {

    private final StateMachine<States, Events> stateMachine;

    @Autowired
    public StateMachineService(StateMachine<States, Events> stateMachine) {
        this.stateMachine = stateMachine;
    }

    public ResponseEntity publishEvent(EventsDto eventsDto) {

        boolean event = stateMachine.sendEvent(MessageBuilder
                .withPayload(eventsDto.getEvent())
                .setHeader("event", eventsDto)
                .build());

        return ResponseEntity.ok(event);

    }

    public StateMachine<States,Events> entryPoint(EventsDto eventsDto) {
        stateMachine.stop();

        stateMachine.getStateMachineAccessor()
                .doWithAllRegions(
                        sma -> {
                            sma.resetStateMachine(
                                    new DefaultStateMachineContext<>(
                                            eventsDto.getState(),
                                            eventsDto.getEvent(),
                                            Map.of("event", eventsDto),
                                            null
                                    )
                            );
                        }
                );

        stateMachine.start();
        return stateMachine;
    }

}
