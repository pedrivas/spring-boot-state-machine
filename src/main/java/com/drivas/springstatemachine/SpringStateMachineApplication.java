package com.drivas.springstatemachine;

import com.drivas.springstatemachine.model.Events;
import com.drivas.springstatemachine.model.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class SpringStateMachineApplication implements CommandLineRunner {

	@Autowired
	private StateMachine<States, Events> stateMachine;


	public static void main(String[] args) {
		SpringApplication.run(SpringStateMachineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando máquina de estados...");
		stateMachine.sendEvent(Events.BEGIN_TRANSACTION);
		stateMachine.sendEvent(Events.APPROVE);
		stateMachine.sendEvent(Events.SETTLE);
		System.out.println("Máquina de estados finalizada");

	}
}
