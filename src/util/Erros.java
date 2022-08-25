package util;

public class Erros {
	
	public String trataErros(String res) {
		String mensagem = "";
		if(res.equals("422")) {
			mensagem = "Dados preechidos de forma errada. Confira se preencheu todos os campos."
					+ " \nA senha deve conter no mínimo 4 caracteres.";
		}
		
		if(res.equals("409")) {
			mensagem = "Já existe um usuário com esse email.";
		}
		
		if(res.equals("Senhas diferentes")) {
			mensagem = "Senhas diferentes.";
		}
		
		return mensagem;
	}
}
