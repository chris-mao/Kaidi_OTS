package com.jrsoft.email;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {
	
	@Autowired
	private EmailService emailService;

	@Test
	public void testSendSimpleMail() {
		emailService.sendSimpleMail("chris.mao.zb@163.com", "test mail", "这是一封测试邮件");
	}

	// @Test
	public void testSendAttachmentsMail() {
		fail("Not yet implemented"); // TODO
	}

	 @Test
	public void testSendTemplateMail() {
		 emailService.sendTemplateMail("chris.mao.zb@163.com", "test HTML mail", null, "mailTemplate", null);
	}

}
