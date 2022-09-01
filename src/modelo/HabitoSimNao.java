package modelo;

public class HabitoSimNao extends Habito {
	private int frequenciaPrevista;

	public HabitoSimNao(String nome, String anotacoes, String[] horarios, String[] dias, int id,
			int frequenciaPrevista) {
		super(nome, anotacoes, horarios, dias, id);
		this.frequenciaPrevista = frequenciaPrevista;
	}

	public int getFrequenciaPrevista() {
		return frequenciaPrevista;
	}
	
	public void setFrequenciaPrevista(int frequenciaPrevista) {
		this.frequenciaPrevista = frequenciaPrevista;
	}

}
