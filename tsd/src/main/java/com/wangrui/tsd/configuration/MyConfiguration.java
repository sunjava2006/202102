package com.wangrui.tsd.configuration;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration implements WebMvcConfigurer{

	@Bean
	public Queue createQueue() {
		return new ActiveMQQueue("Q2");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterreptor()).addPathPatterns("/manage/Knowledge/*/*", "/tempage/manage");
	}
	
	
}
