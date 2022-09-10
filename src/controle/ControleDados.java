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
	 * @return as informações dos usuários cadastrados
	 * 
	 * @see Dados
	 */
	
	public Usuario[] getUsuarios() {
		return dados.getUsuarios();
	}
	
	/**
	 * Retorna a quantidade de usuário cadastrados
	 * 
	 * @return quantidade de usuários
	 * 
	 * @see Dados
	 */
	
	public int getQtdUsuarios() {
		return dados.getQtdUsuario();
	}
	
	/**
	 * Define a quantidade de usuários
	 * 
	 * @param valor quantiade de usuários
	 * 
	 * @see Dados
	 */
	
	public void setQtdUsuarios(int valor) {
		dados.setQtdUsuario(valor);
	}

	/**
	 * Define um novo usuário
	 * 
	 * @param usuario informações do usuário
	 * 
	 * @see Dados
	 */
	
	public void setUsuario(Usuario usuario) {
		dados.setUsuarios(usuario);
	}
	
	/**
	 * Retorna a quantidade de hábitos do tipo "mensurável"
	 * 
	 * @return a qauntidade de hábitos do tipo "mensurável"
	 * 
	 * @see Dados
	 */
	
	public int qtdHabitosMensuraveis() {
		return dados.getQtdHabitoMensuravel();
	}
	
	/**
	 * Define um novo hábito do tipo "mensurável" 
	 * 
	 * @param infos informações do hábito do tipo "mensurável"
	 * @param index posição no array
	 * 
	 * @see Dados
	 */
	
	public void setHabitosMensuraveis(HabitoMensuravel infos, int index) {
		 dados.setHabitoMensuravel(infos, index);
	}
	
	/**
	 * Retorna todos os hábitos do tipo "mensurável"
	 * 
	 * @return as informações dos hábitos do tipo "mensurável"
	 * 
	 * @see Dados
	 */
	
	public HabitoMensuravel[] getHabitosMensuraveis() {
		return dados.getHabitoMensuravel();
	}
	
	/**
	 * Define a quantidade de hábitos do tipo "mensurável"
	 * 
	 * @param valor quantidade de hábitos do tipo "mensurável"
	 * 
	 * @see Dados
	 */
	
	public void setQtdHabitosMensuraveis(int valor) {
		dados.setQtdHabitoMensuravel(valor);
	}
	
	/**
	 * Retorna a quantidade de hábitos do tipo "sim não"
	 * 
	 * @return a quantidade de hábitos do tipo "sim não"
	 * 
	 * @see Dados
	 */
	
	public int qtdHabitosSimNao() {
		return dados.getQtdHabitosSimNao();
	}
	
	/**
	 * Retorna todos os hábitos do tipo "sim nao"
	 * 
	 * @return a quantidade de hábitos do tipo "sim não"
	 * 
	 * @see Dados
	 */
	
	public HabitoSimNao[] getHabitosSimNao() {
		return dados.getHabitoSimNao();
	}
	
	/**
	 * Define um novo hábito do tipo "sim não"
	 * 
	 * @param infos informações do hábito do tipo "sim não"
	 * @param index posição no array
	 * 
	 * @see Dados
	 */
	
	public void setHabitosSimNao(HabitoSimNao infos, int index) {
		 dados.setHabitoSimNao(infos, index);
	}
	
	/**
	 * Define a quantidade de hábitos do tipo "sim ou não"
	 * 
	 * @param valor quantidade de hábitos do tipo "mensurável"
	 * 
	 * @see Dados
	 */

	public void setQtdHabitosSimNao(int valor) {
		dados.setQtdHabitoMensuravel(valor);
	}
}
