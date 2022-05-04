package enviando.email;


public class AppTest {

	@org.junit.Test
	public void  testeEmail() throws Exception { 
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		
		stringBuilderTextoEmail.append("Olá, <br/><br/>");
		stringBuilderTextoEmail.append("<h2>Você está recebendo o site da Docier <br/><br/></h2>");
		stringBuilderTextoEmail.append("Para ter acesso, clique no botão abaixo. <br/><br/>");
		
		stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"docierconfeitaria.com.br\" style=\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration: none; display:inline-block; border-radius: 30px; font-size: 20px; font-family:courier; border: 3px solid green; background-color:#99DA39;\"> Acessar site</a>");
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("alissondeives70@gmail.com", "Alisson Projetos", "Testando email", stringBuilderTextoEmail.toString());
		
		enviaEmail.enviarEmail(true);
		
	}
}
