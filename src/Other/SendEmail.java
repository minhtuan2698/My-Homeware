package Other;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Model.UserCode;

public class SendEmail {
	
	public int GetRandom() {
		Random rd = new Random();
		
		int number = ThreadLocalRandom.current().nextInt(100000,999999);
		return number;
	}
	
	public void connectmail() {
		try {
			String fromEmail = "nguyentuan2698@gmail.com";
			String passEmail = "minhtuan1998";
			
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			
			Session session = Session.getInstance(prop, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, passEmail);
				}
				
			});
			System.out.print("Thanh cong");
			
		} catch (Exception e) {
			System.out.print("That bai");
		
		}
		
		
	}
	
	public boolean Email(UserCode usercode) {
		
		String toEmail = usercode.getEmail();
		
		String fromEmail = "nguyentuan2698@gmail.com";
		String passEmail = "minhtuan1998";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, passEmail);
			}
			
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			
			message.setSubject("User Email Verification");
			message.setText("Registered successfully. Please verify your account using this code: " + usercode.getCode() );
			Transport.send(message);
			System.out.print("Done");
			return true;
			
		} catch (Exception e) {
			System.out.print("Fail");
		}
		
		return false;
	}
	
public boolean Sendmail(String ToEmail, String Subject, String Text) {
		
		
		String FromEmail = "nguyentuan2698@gmail.com";
		String PassEmail = "minhtuan1998";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FromEmail, PassEmail);
			}
			
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ToEmail));
			
			message.setSubject(Subject);
			message.setText(Text);
			Transport.send(message);
			System.out.print("Done");
			return true;
			
		} catch (Exception e) {
			System.out.print("Fail");
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		
		SendEmail mail = new SendEmail();
		for(int i=0;i<100;i++) {
			
			System.out.println(mail.GetRandom());
			
		}
			

		
		
		

		
	}
}
