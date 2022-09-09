package modelo;

/**
 * Classe abstrata que define os métodos e atributos comuns aos 
 * tipos de hábitos da aplicação.
 * 
 * @author carla
 * 
 * @see HabitoMensuravel
 * @see HabitoSimNao
 *
 */

public abstract class Habito {
	private String nome;
	private String anotacoes;
	private String[] horarios = new String[10] ;
	private String[] dias = new String[10];
	private int id;
	private boolean feito;

	/**
	 * Método construtor da classe abstrata Hábito
	 * 
	 * @param nome 
	 * @param anotacoes
	 * @param horarios
	 * @param dias
	 * @param id
	 * @param feito
	 */
	
	public Habito(String nome, String anotacoes, String[] horarios, String[] dias, int id, boolean feito) {
		super();
		this.nome = nome;
		this.anotacoes = anotacoes;
		this.horarios = horarios;
		this.dias = dias;
		this.id = id;
		this.feito = feito;
	}

	/**
	 * Retorna o nome do hábito cadastrado
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Define o nome do hábito
	 * 
	 * @param nome
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna as anotações do hábito
	 * 
	 * @return anotacoes
	 */
	
	public String getAnotacoes() {
		return anotacoes;
	}
	
	/**
	 * Define as anotações do hábito
	 * 
	 * @param anotacoes
	 */
	
	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}
	
	/**
	 * Retorna os horários do hábito
	 * 
	 * @return horarios
	 */

	public String[] getHorarios() {
		return horarios;
	}
	
	/**
	 * Define os horários do hábito
	 * 
	 * @param horarios
	 */

	public void setHorarios(String[] horarios) {
		this.horarios = horarios;
	}

	/**
	 * Retorna os dias da semana do hábito
	 * 
	 * @return dias
	 */
	
	public String[] getDias() {
		return dias;
	}
	
	/**
	 * Define os dias da semana do hábito
	 * 
	 * @param dias
	 */

	public void setDias(String[] dias) {
		this.dias = dias;
	}
	
	/**
	 * Retorna o identificador do usuário 
	 * 
	 * @return
	 */

	public int getId() {
		return id;
	}
	
	/**
	 * Define o identificador do usuário que criou o hábito
	 * 
	 * @param id
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Retorna se o hábito foi ou não feito
	 * 
	 * @return feito
	 */

	public boolean isFeito() {
		return feito;
	}
	
	/**
	 * Define se o hábito foi ou não feito
	 * 
	 * @param feito
	 */

	public void setFeito(boolean feito) {
		this.feito = feito;
	}

}
