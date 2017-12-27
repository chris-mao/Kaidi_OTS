/**
 * 
 */
package com.jrsoft.email;

import java.io.File;
import java.util.Map;

/**
 * 邮件发送服务接口
 *
 * @author Chris Mao(Zibing) <chris.mao.zb@163.com>
 *
 * @version 1.0
 *
 */
public interface EmailService {

	/**
	 * 发送简单邮件
	 * 
	 * @param sendTo
	 *            收件人
	 * @param titel
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 */
	public void sendSimpleMail(String sendTo, String titel, String content);

	/**
	 * 发送带附件的邮件
	 * 
	 * @param sendTo
	 *            收件人
	 * @param titel
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @param attachments
	 *            附件列表
	 */
	public void sendAttachmentsMail(String sendTo, String titel, String content, Map<String, File> attachments);

	/**
	 * 发送模板邮件
	 * 
	 * @param sendTo
	 *            收件人
	 * @param titel
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @param templateName
	 *            邮件模板名称
	 * @param attachments
	 *            附件列表
	 */
	public void sendTemplateMail(String sendTo, String titel, Map<String, Object> content, String templateName,
			Map<String, File> attachments);

}
