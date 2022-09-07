package modelo;

public class HabitoMensuravel extends Habito {
	private String meta;
	private String minimo;

	public HabitoMensuravel(String nome, String anotacoes, String[] horarios, String[] dias, int id, String meta,
			String minimo) {
		super(nome, anotacoes, horarios, dias, id);
		this.meta = meta;
		this.minimo = minimo;
	}

	public String getMeta() {
		return meta;
	}
	
	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getMinimo() {
		return minimo;
	}

	public void setMinimo(String minimo) {
		this.minimo = minimo;
	}
	
	
}
