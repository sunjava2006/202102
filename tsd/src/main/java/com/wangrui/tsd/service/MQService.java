package com.wangrui.tsd.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MQService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	public void send(String msg) {
		this.jmsTemplate.convertAndSend(this.queue, msg);
	}
	
	@JmsListener(destination = "Q2")
	public String getMsg(Message message) throws JMSException {
		String data = null;
		ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
		data = msg.getText();
		System.out.println(data);
		return data;
	}
}
