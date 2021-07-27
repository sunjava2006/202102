package com.wangrui.tsd.configuration;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

	@Bean
	public Queue createQueue() {
		return new ActiveMQQueue("Q2");
	}
}
