package com.metacube.get2019.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.get2019.service.MailSender;


/**
 * This class is for checking dependency injection by name
 * @author Vertika
 *
 */
@RestController
public class MailController3 {
		private MailSender mailType;
		
		public  MailController3(MailSender mailType) {
			super();
			this.mailType = mailType;
		}
		public MailSender getMailType() {
			return mailType;
		}
		@Autowired
		@Qualifier("smtpMailSender")
		public void setMailType(MailSender mailType) {
			this.mailType = mailType;
		} 
		@RequestMapping("/sendMail3")
		public String sendMailController() {
			return mailType.sendMail();
			
		}
		

}
