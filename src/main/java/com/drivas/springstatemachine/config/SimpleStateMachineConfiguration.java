package com.drivas.springstatemachine.config;

import com.drivas.springstatemachine.model.Events;
import com.drivas.springstatemachine.model.States;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class SimpleStateMachineConfiguration extends StateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config.withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.CREATED)
                .end(States.SETTLED)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions.withExternal()
                .source(States.CREATED).target(States.PENDING_APPROVAL).event(Events.BEGIN_TRANSACTION).and()
                .withExternal()
                .source(States.PENDING_APPROVAL).target(States.APPROVED).event(Events.APPROVE).and()
                .withExternal()
                .source(States.PENDING_APPROVAL).target(States.CANCELED).event(Events.CANCEL).and()
                .withExternal()
                .source(States.APPROVED).target(States.SETTLED).event(Events.SETTLE);
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                System.out.println("State changed from " + from.getId() + " to " + to.getId());
            }
        };
    }

}


