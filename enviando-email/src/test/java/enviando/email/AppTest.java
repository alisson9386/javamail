package enviando.email;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AppTest {

	private String userName = "teste.javaprojects@gmail.com";
	
	private String password = "****";
	
	@org.junit.Test
	public void  testeEmail() { 
		
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.trust", "*"); //Autenticação para não precisar desativar o antivirus
			properties.put("mail.smtp.auth", "true"); //Autorização
			properties.put("mail.smtp.starttls.enable", "true"); //Autenticação
			properties.put("mail.smtp.host", "smtp.gmail.com"); //Servidor do gmail
			properties.put("mail.smtp.port", "465"); //Porta do servidor
			properties.put("mail.smtp.socketFactory.port", "465"); //Especifica a porta a ser conectada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //Classe socket de conexão ao SMTP
			
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, password);
				}
			});
			
			Address [] toUser = InternetAddress.parse("alissondeives70@gmail.com");
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, "Tests Projects")); //Quem esta enviando
			message.setRecipients(Message.RecipientType.TO, toUser); // Quem esta recebendo
			message.setSubject("E-mail enviado pelo código Java"); // Assunto do email
			message.setText("Esta mensagem foi enviada pelo código Java, através do JavaMail"); //Corpo do email
			
			Transport.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
