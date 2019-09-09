package com.metacube.get2019.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.get2019.service.MailSender;

/**
 * This class is for checking constructor injection 
 * using @Component annotation
 * and @Primary
 * @author Vertika
 *
 */
@RestController
public class MailController {
	
	 private MailSender mailType;
	 
	@Autowired
	public MailController(MailSender mailType) {
		super();
		this.mailType = mailType;
	}

	public MailSender getMailType() {
		return mailType;
	}

	public void setMailType(MailSender mailType) {
		this.mailType = mailType;
	} 
	
	@RequestMapping("/sendMail")
	public String sendMailController() {
		return mailType.sendMail();
		
	}
	

}
