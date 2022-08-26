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
		
		Usuario usuario = new Usuario(nome, email, senha, false, dados.getQtdUsuario() + 1);
		dados.setUsuarios(usuario);
		dados.setQtdUsuario(qtdUsuarios + 1);
		System.out.println(dados.toString());
		
		return mensagem;
	}
	
	public String logar(String email, String senha) {
		String mensagem = "";
		String senhaCadastrada = "";
		String res = "201";
		System.out.println(dados.toString());
		
		for(int i = 0; i < dados.getQtdUsuario(); i++) {
			if(dados.getUsuarios()[i].getEmail().equals(email)) {
				senhaCadastrada = dados.getUsuarios()[i].getSenha();
			}
		}
		if(senhaCadastrada.equals("")) {
			res = "404";
			return mensagem = erro.trataErros(res);
		}
		if(!senhaCadastrada.equals(senha)) {
			res = "401";
			return mensagem = erro.trataErros(res);
		}
		
		return mensagem;
	}
}
