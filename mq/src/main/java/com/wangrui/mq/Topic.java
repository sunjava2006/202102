package com.wangrui.mq;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Topic {

	private static final ActiveMQConnectionFactory factory 
	= new ActiveMQConnectionFactory("admin", "admin",
                       			    "tcp://127.0.0.1:61616");
	
	public static void send() throws JMSException {
		QueueConnection conn = null;
		Session session = null;
		MessageProducer producer = null;
		try {
			// 1、建立连接 
			conn = factory.createQueueConnection();
			conn.start();
			
			// 2、建立会话
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			// 3、建立主题
			javax.jms.Topic topic = session.createTopic("publicMSG");
			
			// 4、建立生产者
			producer = session.createProducer(topic);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			
			// 5、建立消息
			TextMessage msg = session.createTextMessage("明天继续上课，完成框架。后面进入基础原理。");
			
			// 6、发送消息
			producer.send(msg);			
			
			// 7、提交事务
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			producer.close();
			session.close();
			conn.close();
		}
	}
	
	public static void receive() {
//		 = null;
		
//		 consumer = null;
		try {
			// 1、建立连接
			final QueueConnection conn = factory.createQueueConnection();
			conn.start();
			
			// 2、建立会话
			final Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			// 3、建立主题
			javax.jms.Topic topic = session.createTopic("publicMSG");
			
			// 4、建立消费者
		    final MessageConsumer consumer = session.createConsumer(topic);
			
			// 5、取消息
			consumer.setMessageListener((msg)->{
				TextMessage txtmsg = (TextMessage) msg;
				try {
					System.out.println(txtmsg.getText());
					session.commit();
				} catch (JMSException e) {
					
					e.printStackTrace();
					try {
						session.rollback();
					} catch (JMSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}finally {
					// 6、释放资源
					try {
						consumer.close();
						session.close();
						conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
							
				}
			});
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) throws JMSException {
		receive();
		send();
	}
}
