package controle;

import modelo.Usuario;

/**
* A classe ControleUsuario é responsável pelas funcionalidades relacionados ao usuário
* 
* @author carla
*/

public class ControleUsuario {
	
    /**
    * Retorna o identificador de um usuario dado seu email e uma fonte de dados.
    *
    * Percorre a lista de usuarios testando o email enviado como parâmetro do método com o email dos objetos "Usuario".
    * Se os emails corresponderem o id do usuário é retornado ao front.
    * 
    *
    * @param email o email do usuário
    * @param dados a fonte de dados onde o usuário será buscado
    * 
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
    
    /**
     * O método criarUsuario valida os dados recebidos e retorna uma mensagem contendo as informações da validação
     * caso ocorra erro. Se a validação for bem sucedida os dados do usuário são salvos na classe Dados.
     * 
     * É verificado:
	 * <ol>
	 * 	<li>se a senha contem no mínimo 4 caracteres;</li>
	 *  <li>se as senha e a senha de verificação são iguais;</li>
	 *  <li>se já existe um usuário cadastrado com o email em questão;</li>
	 *  <li>se o email está no formato certo;</li>
	 *  <li>se o nome não está em branco.</li>
	 * </ol>
     * 
	 * @param dados todas as informações salvas
	 * @param email email do usuário
	 * @param senha senha do usuário
     * @param nome nome do usuário
     * @param senhaRepetida senha do usuário
     * 
     * @return mensagem
     * 
     * @see ControleDados
     * @see Usuario
     */
    
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
	
	/**
	 * O método logar faz a validação do email e senha inseridos pelo usuário comparando-os dados de cadastro
	 * e, em casa de falha na validação, retorna uma mensagem com o erro.
	 * 
	 * @param dados todas as informações salvas
	 * @param email email do usuário
	 * @param senha senha do usuário
	 * 
	 * @return mensagem 
	 * 
	 * @see ControleDados
	 * @see Usuario
	 */
	
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