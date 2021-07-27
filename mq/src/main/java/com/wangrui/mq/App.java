package com.wangrui.mq;

import java.util.HashMap;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class App {
	
	// 1、连接到MQ服务器
	private static final ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin",
						"admin", "tcp://localhost:61616");
	
	
	
	// 发送消息到队列中
	public static void send() throws JMSException {
		
		QueueConnection conn = null;
		Session session = null;
		MessageProducer producer = null;
		try {
			
			conn = factory.createQueueConnection();
			conn.start();
			
			// 2、创建会话
			session = conn.createSession(true, QueueSession.AUTO_ACKNOWLEDGE);
			// 3、建立一个队列
			
			Queue queue= session.createQueue("Q1");
			
			
			// 4、建立一个生产者
			producer = session.createProducer(queue);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			// 5、建立消息
//			Message msg = session.createTextMessage("大家都有二次检测没？");
			HashMap map = new HashMap();
			map.put("msg", "昨天我去二次检测了。 ");
			map.put("mobileNO", "18012330987");
			ObjectMessage msg = session.createObjectMessage(map);
			
			// 6、发送消息
			System.out.println("----------send------------");
			producer.send(msg);
			session.commit(); // 提交事务
			
		} catch (JMSException e) {
			e.printStackTrace();
			session.rollback(); // 回滚事务
		} finally {

			producer.close();
			session.close();
			conn.close();
			
		}

	}
	
	public static void receive() throws JMSException {
		QueueConnection conn = null;
		Session session = null; 
		Queue queue = null;
		MessageConsumer consumer = null;
		Message msg = null;
		try {
			// 1、连接到服务器
			conn = factory.createQueueConnection();
			conn.start();
			
            // 2、建立会话
			session = conn.createSession(true, QueueSession.AUTO_ACKNOWLEDGE);
			
			// 3、建立队列
			queue = session.createQueue("Q1");
			
			// 4、建立消费者
			consumer = session.createConsumer(queue);
			
			// 5、接收消息
			System.out.println("will receive");
			
			// 有参的会按指定时间等待消息到达。无参会一直等下去，直到接收到消息
			msg = consumer.receive();     
			System.out.println("received");
			
			// 6、处理消息 
			if(null != msg) {
//				TextMessage txtmsg = (TextMessage)msg;
//				String data = txtmsg.getText();
				ObjectMessage objmsg = (ObjectMessage)msg;
				HashMap data = (HashMap)objmsg.getObject();
				System.out.println(data);
			}
			session.commit();
			  
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			 consumer.close();
			 session.close();
			 conn.close();
		}
		
		
	}
	
	
    public static void main( String[] args ) throws JMSException, InterruptedException
    {
    	Thread t = new Thread(()->{try{
    		App.receive();
    		}catch(Exception ex) {
    			ex.printStackTrace();}
    	});
    	
    	t.start();
    	Thread.sleep(2000);
    	send();
    }
}
