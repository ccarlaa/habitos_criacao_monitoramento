package modelo;

public class HabitoSimNao extends Habito {
	private String frequenciaPrevista;

	public HabitoSimNao(String nome, String anotacoes, String[] horarios, String[] dias, int id,
			String frequenciaPrevista) {
		super(nome, anotacoes, horarios, dias, id);
		this.frequenciaPrevista = frequenciaPrevista;
	}

	public String getFrequenciaPrevista() {
		return frequenciaPrevista;
	}
	
	public void setFrequenciaPrevista(String frequenciaPrevista) {
		this.frequenciaPrevista = frequenciaPrevista;
	}

}
