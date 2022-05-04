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

public class ObjetoEnviaEmail {
	
	private String userName = "teste.javaprojects@gmail.com";
	
	private String password = "****";
	
	private String listaDestinatarios = "";
	
	private String nomeRemetente = "";
	
	private String assuntoEmail = "";
	
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}
	
	public void enviarEmail(boolean envioHtml) throws Exception{
		
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
		
		Address [] toUser = InternetAddress.parse(listaDestinatarios);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente)); //Quem esta enviando
		message.setRecipients(Message.RecipientType.TO, toUser); // Quem esta recebendo
		message.setSubject(assuntoEmail); // Assunto do email
		
		if(envioHtml) {
			message.setContent(textoEmail, "text/html; charset=utf-8");
		}else {
			message.setText(textoEmail); //Corpo do email
		}
		
		
		Transport.send(message);
	}

}
