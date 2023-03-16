package com.drivas.springstatemachine;

import com.drivas.springstatemachine.model.Events;
import com.drivas.springstatemachine.model.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
//@ComponentScan(basePackages = "com.drivas.springstatemachine.controller")
//@EnableAutoConfiguration(exclude= RabbitAutoConfiguration.class)
public class SpringStateMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStateMachineApplication.class, args);
	}

}
