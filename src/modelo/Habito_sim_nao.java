package modelo;

public class Habito_sim_nao extends Habito {
	private int frequenciaPrevista;
	private int frequenciaCumprida;
	
	public Habito_sim_nao(String nome, String questao, String anotacoes, Lembrete[] lembretes, int frequenciaPrevista,
			int frequenciaCumprida) {
		super(nome, questao, anotacoes, lembretes);
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
