package modelo;

/**
 * A classe Dados guarda as informações dos objetos criados 
 * 
 * @author carla
 * 
 * @see Usuario
 * @see HabitoMensuravel
 * @see HabitoSimNao
 *
 */

public class Dados {
	private Usuario[] usuarios = new Usuario[50];
	private int qtdUsuario = 1;
	private HabitoSimNao[] habitoSimNao = new HabitoSimNao[50];
	private int qtdHabitosSimNao = 4;
	private HabitoMensuravel[] habitoMensuravel = new HabitoMensuravel[50];
	private int qtdHabitoMensuravel = 4;
	
	/**
	 * Método construtor da classe Dados que visa preencher o "banco" com 
	 * as informações de um usuário de testes.
	 */
	
	public void dados() {
		String[] dias = {"segunda-feira", "terça-feira", "quarta-feira","quinta-feira", "sexta-feira"};
		String[] horarios = {"12:30", "06:45", "21:45", "09:00", "16:05"};
		usuarios[0] = new Usuario("teste", "teste@gmail.com", "1234", 0);
		for(int i = 0; i < 5; i++) {
			habitoMensuravel[i] = new HabitoMensuravel("correr" + i, "levar água", horarios, dias, 0, false, "8km", "10km");
		}
		for(int i = 0; i < 5; i++) {
			habitoSimNao[i] = new HabitoSimNao("beber agua" + i, "levar água", horarios, dias, 0, false, "2 vezes por dia");
		}
	}
	
	/**
	 * Retorna as informações dos usuários cadastrados
	 * 
	 * @return informações de todos os usuários
	 */
	
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	
	/**
	 * Salva os dados de um usuário cadastrado
	 * 
	 * @param usuarios informações do usuário
	 */
	
	public void setUsuarios(Usuario usuarios) {
		this.usuarios[getQtdUsuario()] = usuarios;
	}
	
	/**
	 * Retorna a quantidade de usuários cadastrados
	 * 
	 * @return qauntiade de usuários
	 */
	
	public int getQtdUsuario() {
		return qtdUsuario;
	}
	
	/**
	 * Define a quantidade de usuários cadastrados
	 * 
	 * @param qtdUsuario quantidade de usuários
	 */
	
	public void setQtdUsuario(int qtdUsuario) {
		this.qtdUsuario = qtdUsuario;
	}
	
	/**
	 * Retorna os hábitos do tipo "Sim Nao" cadastrados
	 * 
	 * @return HabitosSimNao[]
	 */
	
	public HabitoSimNao[] getHabitoSimNao() {
		return habitoSimNao;
	}
	
	/**
	 * Salva um hábito do tipo "Sim Nao" cadastrado
	 * 
	 * @param habitoSimNao informações do hábito do tipo "sim não"
	 * @param index posição no array
	 */
	
	public void setHabitoSimNao(HabitoSimNao habitoSimNao, int index) {
		this.habitoSimNao[index] = habitoSimNao;
	}
	
	/**
	 * Retorna a quantidade de hábitos do tipo "Sim Nao" cadastrados
	 * 
	 * @return quantidade de hábitos do tipo "sim não"
	 */
	
	public int getQtdHabitosSimNao() {
		return qtdHabitosSimNao;
	}
	
	/**
	 * Define a quantidade de hábitos do tipo "Sim Não" cadastrados
	 * 
	 * @param qtdHabitosSimNao qauntidade de hábitos do tipo "sim não"
	 */
	
	public void setQtdHabitosSimNao(int qtdHabitosSimNao) {
		this.qtdHabitosSimNao = qtdHabitosSimNao;
	}
	
	/**
	 * Retorna os hábitos do tipo "Mensurável" cadastrados
	 * 
	 * @return todos os hábitos do tipo "mensurável"
	 */
	
	public HabitoMensuravel[] getHabitoMensuravel() {
		return habitoMensuravel;
	}
	
	/**
	 * Salva um hábito do tipo "Mensurável" cadastrado
	 * 
	 * @param habitoMensuravel informações do hábito do tipo "mensurável"
	 * @param index posição no array
	 */
	
	public void setHabitoMensuravel(HabitoMensuravel habitoMensuravel, int index) {
		this.habitoMensuravel[index] = habitoMensuravel;
	}
	
	/**
	 * Retorna a quantidade de hábitos do tipo "Mensurável" cadastrados
	 * 
	 * @return quantidade de hábitos do tipo "mensurável"
	 */
	
	public int getQtdHabitoMensuravel() {
		return qtdHabitoMensuravel;
	}
	
	/**
	 * Define a quantiade de hábitos do tipo "Mensurável" cadastrados
	 * 
	 * @param qtdHabitoMensuravel quantidade de hábitos do tipo "mensurável"
	 */
	
	public void setQtdHabitoMensuravel(int qtdHabitoMensuravel) {
		this.qtdHabitoMensuravel = qtdHabitoMensuravel;
	}
	
}
