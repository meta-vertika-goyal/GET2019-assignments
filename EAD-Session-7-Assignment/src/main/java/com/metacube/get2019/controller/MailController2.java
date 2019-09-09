package com.metacube.get2019.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.get2019.service.MailSender;


	/**
	 * This class is for checking setter injection using @configuration annotation
	 * @author Vertika
	 *
	 */
	@RestController
	public class MailController2 {
		
		private MailSender mailType;
		
		public  MailController2(MailSender mailType) {
			super();
			this.mailType = mailType;
		}

		public MailSender getMailType() {
			return mailType;
		}
		@Autowired
		public void setMailType(MailSender mailType) {
			this.mailType = mailType;
		} 
		
		@RequestMapping("/sendMail2")
		public String sendMailController() {
			return mailType.sendMail();
			
		}
		

	}



