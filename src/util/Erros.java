package util;

public class Erros {
	
	public String trataErros(String res) {
		String mensagem = "";
		
		switch(res) {
		case "422":
			mensagem = "Dados preechidos de forma errada. Confira se preencheu todos os campos."
					+ " \nA senha deve conter no mínimo 4 caracteres.";
			break;
			
		case "404":
			mensagem = "Não encontrado";
			break;
			
		case "409":
			mensagem = "Conflito. Já existe um usuário com esse email.";
			break;
			
		case "401":
			mensagem = "Não autorizado. Senha incorreta.";
			break;
			
		case "Senhas diferentes":
			mensagem = "Senhas diferentes.";
			break;
		default:
		}
		
		return mensagem;
	}
}
