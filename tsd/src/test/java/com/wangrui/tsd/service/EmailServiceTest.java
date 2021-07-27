package com.wangrui.tsd.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class EmailServiceTest {
	
	@Autowired
	private EmailService es;

	@Test
	void testSendMail() throws MessagingException {
		es.activeMail("jkwangrui@126.com");
		//es.sendMail(new String[] {"jkwangrui@126.com"}, "testMail", "hi", new String[0]);
	}

}
