package controle;
import modelo.*;

public class ControleDados {
	private Dados dados = new Dados();
	
	public Usuario[] getUsuarios() {
		return dados.getUsuarios();
	}
	
	public int getQtdUsuarios() {
		return dados.getQtdUsuario();
	}
	
	public String criarUsuario(String nome, String email, String senha, String senhaRepetida) {
		String mensagem = "";
		int qtdUsuarios = dados.getQtdUsuario();
		
		if(!senha.matches("[0-9a-zA-Z$*&_/@#]{4,}") || !email.matches("^(.+)@(.+)$")
				|| !nome.matches("[0-9a-zA-Z]+")) {
			return mensagem = "Dados preechidos de forma errada. Confira se preencheu todos os campos.";
		}
		if(!senha.equals(senhaRepetida)) {
			return mensagem = "Senhas diferentes";
		}
		for(int i = 0; i < dados.getQtdUsuario(); i++) {
			if(dados.getUsuarios()[i].getEmail().equals(email)) {
				return mensagem = "Conflito. Já existe um usuário com esse email.";
			}
		}
		
		Usuario usuario = new Usuario(nome, email, senha, false, dados.getQtdUsuario() + 1);
		dados.setUsuarios(usuario);
		dados.setQtdUsuario(qtdUsuarios + 1);
		
		return mensagem;
	}
	
	public String logar(String email, String senha) {
		String mensagem = "";
		String senhaCadastrada = "";
		System.out.println(dados.toString());
		
		for(int i = 0; i < dados.getQtdUsuario(); i++) {
			if(dados.getUsuarios()[i].getEmail().equals(email)) {
				senhaCadastrada = dados.getUsuarios()[i].getSenha();
			}
		}
		if(senhaCadastrada.equals("")) {
			return mensagem = "Conta não encontrada";
		}
		if(!senhaCadastrada.equals(senha)) {
			return mensagem = "Não autorizado. Senha incorreta.";
		}
		
		return mensagem;
	}
	
	public String salvarHabitoMensuravel(
		int id,
		String nome,
		String meta,
		String minimo,
		String anotacoes,
		String[] horarios,
		String[] dias
	) {
		String mensagem = "";
		int qtdHabitosMensuraveis = dados.getQtdHabitoMensuravel();
		
		if(nome == null || meta == null || minimo == null || horarios[0] == null) {
			return mensagem = "Preencha todos os campos";
		}
		for(int i = 0; i < qtdHabitosMensuraveis; i++) {
			if(dados.getHabitoMensuravel()[i].getNome().equals(nome)) {
				return mensagem = "Já existe um hábito com esse nome";
			}
		}
		
		HabitoMensuravel habito = new HabitoMensuravel(nome, anotacoes, horarios, dias, id, meta, minimo);
		dados.setHabitoMensuravel(habito);
		dados.setQtdHabitoMensuravel(qtdHabitosMensuraveis + 1);
		
		System.out.println(dados.toString());
		return mensagem;
	}
}
