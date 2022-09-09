package controle;

import modelo.Usuario;

/**
* ControleUsuario é responsável por disponibilizar as funcionalidades relacionados ao usuário
*/

public class ControleUsuario {
	
    /**
    * Devolve o identificador de um usuario, caso exista, dado seu email e uma fonte de dados.
    *
    * Percorre a lista de usuarios testando o email enviado como parâmetro do método com o email dos objetos "Usuario"
    *
    * @param email: o email do usuário
    * @param dados: a fonte de dados onde o usuário será buscado
    * @return o id do usuário
    *
    * @see Usuario
    * @see ControleDados
    */
	
    public int getIdUsuario(String email, ControleDados dados) {
        int qtdUsuarios = dados.getQtdUsuarios();
        int usuarioId = 0;
        for(int i = 0; i < qtdUsuarios; i++) {
            if(dados.getUsuarios()[i].getEmail().equals(email)) {
                usuarioId = dados.getUsuarios()[i].getId();
            }
        }
        return usuarioId;
    }
    
	public String criarUsuario(ControleDados dados, String nome, String email, String senha, String senhaRepetida) {
		String mensagem = "";
		int qtdUsuarios = dados.getQtdUsuarios();
		
		if(!senha.matches("[0-9a-zA-Z$*&_/@#]{4,}") || !email.matches("^(.+)@(.+)$")
				|| !nome.matches("[0-9a-zA-Z]+")) {
			return mensagem = "Dados preechidos de forma errada. Confira se preencheu todos os campos.";
		}
		if(!senha.equals(senhaRepetida)) {
			return mensagem = "Senhas diferentes";
		}
		for(int i = 0; i < dados.getQtdUsuarios(); i++) {
			if(dados.getUsuarios()[i].getEmail().equals(email)) {
				return mensagem = "Conflito. Já existe um usuário com esse email.";
			}
		}
		
		Usuario usuario = new Usuario(nome, email, senha, dados.getQtdUsuarios() + 1);
		dados.setUsuario(usuario);
		dados.setQtdUsuarios(qtdUsuarios + 1);
		
		return mensagem;
	}
	
	public String logar(ControleDados dados, String email, String senha) {
		String mensagem = "";
		String senhaCadastrada = "";
		boolean emailExiste = false;
		
		for(int i = 0; i < dados.getQtdUsuarios(); i++) {
			if(dados.getUsuarios()[i].getEmail().equals(email)) {
				emailExiste = true;
			}
		}
		if(!emailExiste) {
			return mensagem = "Email não encontrado";
		}
		for(int i = 0; i < dados.getQtdUsuarios(); i++) {
			if(dados.getUsuarios()[i].getEmail().equals(email)) {
				senhaCadastrada = dados.getUsuarios()[i].getSenha();
			}
		}
		if(senha.equals("")) {
			return mensagem = "Preencha todos os campos";
		}
		if(!senhaCadastrada.equals(senha)) {
			return mensagem = "Não autorizado. Senha incorreta.";
		}
		
		return mensagem;
	}
}