/**
 * 
 */
package com.jrsoft.email;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * com.jrsoft.email.service.impl EmailServiceImpl
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	/**
	 * 邮件发件地址
	 */
	@Value("${spring.mail.username}")
	private String fromAddress;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	protected TemplateEngine thymeleaf;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jrsoft.email.service.EmailServier#sendSimpleMail(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void sendSimpleMail(String sendTo, String titel, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromAddress);
		message.setTo(sendTo);
		message.setSubject(titel);
		message.setText(content);
		mailSender.send(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jrsoft.email.service.EmailServier#sendAttachmentsMail(java.lang.
	 * String, java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public void sendAttachmentsMail(String sendTo, String titel, String content, Map<String, File> attachments) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(fromAddress);
			helper.setTo(sendTo);
			helper.setSubject(titel);
			helper.setText(content);

			for (Entry<String, File> entry : attachments.entrySet()) {
				helper.addAttachment(entry.getKey(), new FileSystemResource(entry.getValue()));
			}
		} catch (Exception e) {
			// throw new RuntimeServiceException(e);
		}

		mailSender.send(mimeMessage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jrsoft.email.service.EmailServier#sendTemplateMail(java.lang.String,
	 * java.lang.String, java.util.Map, java.util.Map)
	 */
	@Override
	public void sendTemplateMail(String sendTo, String titel, Map<String, Object> content, String templateName,
			Map<String, File> attachments) {
		MimeMessage mailMessage = mailSender.createMimeMessage();  
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);  
        Context con = new Context();
        con.setVariable("hehe", "Chris Mao");
        if (StringUtils.isEmpty(templateName)) {
        	templateName = "mailTemplate";
        }
        String emailtext = thymeleaf.process(templateName, con);

        try {
            // 设置收件人，寄件人 用数组发送多个邮件
            messageHelper.setTo(sendTo);
            messageHelper.setFrom(fromAddress);
            messageHelper.setSubject(titel);
            // true 表示启动HTML格式的邮件  
            messageHelper.setText(emailtext, true);  
            // 发送邮件
            mailSender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

}
