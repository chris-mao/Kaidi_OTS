/**
 * 
 */
package com.jrsoft.email;

import java.io.File;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	public void sendAttachmentsMail(String sendTo, String titel, String content, String[] attachments) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setFrom(fromAddress);
			messageHelper.setTo(sendTo);
			messageHelper.setSubject(titel);
			messageHelper.setText(content);

			// 存在附件
			if (attachments != null && attachments.length > 0) {
				for (String attachment : attachments) {
					File file = new File(attachment);
					if (file.exists()) {// 附件存在磁盘中
						messageHelper.addAttachment(attachment, file);
					}
				}
			}
			
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			// throw new RuntimeServiceException(e);
		}

		
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
			String[] attachments) {
		Context con = new Context();
		con.setVariable("hehe", "Chris Mao");
		if (StringUtils.isEmpty(templateName)) {
			templateName = "mails/mailTemplate";
		}
		String emailContent = thymeleaf.process(templateName, con);

		MimeMessage mailMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);
			// 设置收件人，寄件人 用数组发送多个邮件
			messageHelper.setTo(sendTo);
			messageHelper.setFrom(fromAddress);
			messageHelper.setSubject(titel);
			// true 表示启动HTML格式的邮件
			messageHelper.setText(emailContent, true);

			// 存在附件
			if (attachments != null && attachments.length > 0) {
				for (String attachment : attachments) {
					File file = new File(attachment);
					if (file.exists()) {// 附件存在磁盘中
						messageHelper.addAttachment(attachment, file);
					}
				}
			}

			// 发送邮件
			mailSender.send(mailMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
