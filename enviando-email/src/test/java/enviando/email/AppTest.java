package enviando.email;


public class AppTest {

	@org.junit.Test
	public void  testeEmail() throws Exception { 
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("alissondeives70@gmail.com", "Alisson Projetos", "Testando email", "Descrição do e-mail");
		
		enviaEmail.enviarEmail();
		
	}
}
