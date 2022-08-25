package modelo;

public class HabitoSimNao extends Habito {
	private int frequenciaPrevista;
	private int frequenciaCumprida;
	
	public HabitoSimNao(String nome, String questao, String anotacoes, Lembrete[] lembretes, int frequenciaPrevista,
			int frequenciaCumprida, int id) {
		super(nome, questao, anotacoes, lembretes, id);
		this.frequenciaPrevista = frequenciaPrevista;
		this.frequenciaCumprida = frequenciaCumprida;
	}

	public int getFrequenciaPrevista() {
		return frequenciaPrevista;
	}
	
	public void setFrequenciaPrevista(int frequenciaPrevista) {
		this.frequenciaPrevista = frequenciaPrevista;
	}
	
	public int getFrequenciaCumprida() {
		return frequenciaCumprida;
	}
	
	public void setFrequenciaCumprida(int frequenciaCumprida) {
		this.frequenciaCumprida = frequenciaCumprida;
	}
	
	
}
