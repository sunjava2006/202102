package com.wangrui.tsd.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	public void sendMail(String[] to, String title, String msg, String... cc) {
        // 邮件对象
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		// 设置邮件
		mailMessage.setFrom(from);// 发件人，必须与账号一致
		mailMessage.setTo(to); // 收件人
		if(null != cc) { 
			mailMessage.setCc(cc);  // 抄送
		}
		mailMessage.setSubject(title); // 标题
		mailMessage.setSentDate(new Date()); // 日期
		mailMessage.setText(msg);
		
		this.sender.send(mailMessage);
		
		
	}
	
	public void activeMail(String to) throws MessagingException {
		MimeMessage mimeMessage = this.sender.createMimeMessage();
		MimeMessageHelper h = new MimeMessageHelper(mimeMessage);
		h.setFrom(this.from);
		h.setTo(to);
		h.setSubject("active account");
	    String data = "<html><a href=\"http://www.qq.com\"><h2>激活账号点此<h2></a></html>";
	    h.setText(data, true);
	    
	    this.sender.send(mimeMessage);
	}
}
