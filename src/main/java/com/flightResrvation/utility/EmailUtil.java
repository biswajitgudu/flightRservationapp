package com.flightResrvation.utility;




import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender sender;

	public void sendItinerary(String toAddress, String filepath) {
		
		MimeMessage Message= sender.createMimeMessage();
		try {
			MimeMessageHelper helper=new MimeMessageHelper(Message, true);
			helper.setTo(toAddress);
			helper.setSubject("Itinerary of Flight");
			helper.setText("please find the attached");
			helper.addAttachment("Itinerary" ,new File(filepath));
			sender.send(Message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}

}
