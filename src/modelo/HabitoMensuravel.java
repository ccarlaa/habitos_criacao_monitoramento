package modelo;

/**
 * A classe define um hábito que pode ser mensurado e herda os atributos e métodos
 * da classe abstrata Habito.
 * Exemplo: Correr 10km.
 * 
 * @author carla
 *
 * @see Habito
 */

public class HabitoMensuravel extends Habito {
	private String meta;
	private String minimo;
	
	/**
	 * Método construtor da classe HabitoMensuravel que herda os métodos e atributos
	 * da classe abstrata Habito
	 * 
	 * @param nome
	 * @param anotacoes
	 * @param horarios
	 * @param dias
	 * @param id
	 * @param feito
	 * @param meta
	 * @param minimo
	 */

	public HabitoMensuravel(String nome, String anotacoes, String[] horarios, String[] dias, int id, boolean feito,
			String meta, String minimo) {
		super(nome, anotacoes, horarios, dias, id, feito);
		this.meta = meta;
		this.minimo = minimo;
	}

	/**
	 * Retorna a meta definida para o hábito
	 * 
	 * @return
	 */
	
	public String getMeta() {
		return meta;
	}
	
	/**
	 * Define a meta do hábito 
	 * 
	 * @param meta
	 */
	
	public void setMeta(String meta) {
		this.meta = meta;
	}
	
	/**
	 * Retorna o mínimo a ser cumprido da meta
	 * 
	 * @return
	 */

	public String getMinimo() {
		return minimo;
	}

	/**
	 * Define o mínimo a ser cumprido da meta
	 * 
	 * @param minimo
	 */
	
	public void setMinimo(String minimo) {
		this.minimo = minimo;
	}
	
	
}
