package br.josias.emailsender.service;

import javax.mail.internet.MimeMessage;

public class DevMockEmailService extends AbstractEmailService {

	@Override
	public void sendMail(MimeMessage msg) {
		System.out.println(msg.toString());
	}

}
