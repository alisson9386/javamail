package enviando.email;

import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@org.junit.Test
	public void  testeEmail() {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true"); //Autorização
		properties.put("mail.smtp.starttls", "true"); //Autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com"); //Servidor do gmail
		properties.put("mail.smtp.port", "465"); //Porta do servidor
		properties.put("mail.smtp.socketFactory.port", "465"); //Especifica a porta a ser conectada pelo socket
	}
}
