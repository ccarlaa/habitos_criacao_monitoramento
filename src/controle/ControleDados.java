package controle;
import modelo.*;
import util.*;

public class ControleDados {
	private Dados dados = new Dados();
	private Erros erro = new Erros();
	
	public String criarUsuario(String nome, String email, String senha, String senhaRepetida) {
		String res = "201";
		String mensagem = "";
		
		int qtdUsuarios = dados.getQtdUsuario();
		int id = qtdUsuarios + 1;
		
		if(!senha.matches("[0-9a-zA-Z$*&_/@#]{4,}") || !email.matches("^(.+)@(.+)$")
				|| !nome.matches("[0-9a-zA-Z]+")) {
			res = "422";
			return mensagem = erro.trataErros(res);
		}
		
		if(!senha.equals(senhaRepetida)) {
			res = "Senhas diferentes";
			return mensagem = erro.trataErros(res);
		}
		
		for(int i = 0; i < dados.getQtdUsuario(); i++) {
			if(dados.getUsuarios()[i].getEmail().equals(email)) {
				res = "409";
				return mensagem = erro.trataErros(res);
			}
		}
		
		Usuario usuario = new Usuario(nome, email, senha, false, dados.getQtdUsuario());
		dados.setUsuarios(usuario);
		dados.setQtdUsuario(qtdUsuarios + 1);
		
		return mensagem;
	}
}
