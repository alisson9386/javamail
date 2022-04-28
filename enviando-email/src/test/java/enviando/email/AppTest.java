package enviando.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class AppTest {

	private String userName = "teste.javaprojects@gmail.com";
	
	private String password = "Z0rr0b@tmak";
	
	@org.junit.Test
	public void  testeEmail() { 
		
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true"); //Autorização
			properties.put("mail.smtp.starttls", "true"); //Autenticação
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
			
			System.out.println(password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
