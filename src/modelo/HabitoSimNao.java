package modelo;

/**
 * A classe define um hábito que pode ser respondido com sim ou não e
 * herda o métodos e atributos da classe abstrata Habito
 * Exemplo: Estudei hoje?
 * 
 * @author carla
 * @see Habito
 */

public class HabitoSimNao extends Habito {
	
	private String frequenciaPrevista;
	
	/**
	 * Método construtor da classe HabitoSimNao que herda os métotos e atributos 
	 * da classe abstrata Habito
	 * 
	 * @param nome
	 * @param anotacoes
	 * @param horarios
	 * @param dias
	 * @param id
	 * @param feito
	 * @param frequenciaPrevista
	 * 
	 * @see Habito
	 */

	public HabitoSimNao(String nome, String anotacoes, String[] horarios, String[] dias, int id, boolean feito,
			String frequenciaPrevista) {
		super(nome, anotacoes, horarios, dias, id, feito);
		this.frequenciaPrevista = frequenciaPrevista;
	}
	
	/**
	 * Retorna a frequência que o hábito deve ser realizado
	 * 
	 * @return
	 */

	public String getFrequenciaPrevista() {
		return frequenciaPrevista;
	}
	
	/**
	 * Define com que frequência o hábito deve ser realizado
	 * 
	 * @param frequenciaPrevista
	 */
	
	public void setFrequenciaPrevista(String frequenciaPrevista) {
		this.frequenciaPrevista = frequenciaPrevista;
	}

}
