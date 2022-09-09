package controle;
import modelo.*;

/**
 * A classe ControleDados realiza o gerenciamento dos dados da aplicação
 * 
 * @author carla
 */

public class ControleDados {
	
	private Dados dados = new Dados();
	
	/**
	 * Chama o método construtor da classe Dados
	 * 
	 * @see Dados
	 */
	
	public ControleDados() {
		dados.dados();
	}
	
	/**
	 * Retorna as informações dos usuário cadastrados
	 * 
	 * @return
	 */
	
	public Usuario[] getUsuarios() {
		return dados.getUsuarios();
	}
	
	/**
	 * Retorna a quantidade de usuário cadastrados
	 * 
	 * @return
	 */
	
	public int getQtdUsuarios() {
		return dados.getQtdUsuario();
	}
	
	/**
	 * Define a quantidade de usuários
	 * 
	 * @param valor
	 */
	
	public void setQtdUsuarios(int valor) {
		dados.setQtdUsuario(valor);
	}

	/**
	 * Define um novo usuário
	 * 
	 * @param usuario
	 */
	
	public void setUsuario(Usuario usuario) {
		dados.setUsuarios(usuario);
	}
	
	/**
	 * Retorna a quantidade de hábitos do tipo "mensurável"
	 * 
	 * @return
	 */
	
	public int qtdHabitosMensuraveis() {
		return dados.getQtdHabitoMensuravel();
	}
	
	/**
	 * Define um novo hábito do tipo "mensurável" 
	 * 
	 * @param infos
	 * @param index
	 */
	
	public void setHabitosMensuraveis(HabitoMensuravel infos, int index) {
		 dados.setHabitoMensuravel(infos, index);
	}
	
	/**
	 * Retorna todos os hábitos do tipo "mensurável"
	 * 
	 * @return
	 */
	
	public HabitoMensuravel[] getHabitosMensuraveis() {
		return dados.getHabitoMensuravel();
	}
	
	/**
	 * Define a quantidade de hábitos do tipo "mensurável"
	 * 
	 * @param valor
	 */
	
	public void setQtdHabitosMensuraveis(int valor) {
		dados.setQtdHabitoMensuravel(valor);
	}
	
	/**
	 * Retorna a quantidade de hábitos do tipo "sim não"
	 * 
	 * @return
	 */
	
	public int qtdHabitosSimNao() {
		return dados.getQtdHabitosSimNao();
	}
	
	/**
	 * Retorna todos os hábitos do tipo "sim nao"
	 * 
	 * @return
	 */
	
	public HabitoSimNao[] getHabitosSimNao() {
		return dados.getHabitoSimNao();
	}
	
	/**
	 * Define um novo hábito do tipo "sim não"
	 * 
	 * @param infos
	 * @param index
	 */
	
	public void setHabitosSimNao(HabitoSimNao infos, int index) {
		 dados.setHabitoSimNao(infos, index);
	}
	
	/**
	 * Define a quantidade de hábitos do tipo "sim ou não"
	 * 
	 * @param valor
	 */

	public void setQtdHabitosSimNao(int valor) {
		dados.setQtdHabitoMensuravel(valor);
	}
}
