package modelo;

public class HabitoMensuravel extends Habito {
	private String unidade;
	private float meta;
	private float metaCumprida;
	
	public HabitoMensuravel(String nome, String questao, String anotacoes, Lembrete[] lembretes, String unidade,
			float meta, float metaCumprida) {
		super(nome, questao, anotacoes, lembretes);
		this.unidade = unidade;
		this.meta = meta;
		this.metaCumprida = metaCumprida;
	}

	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public float getMeta() {
		return meta;
	}
	
	public void setMeta(float meta) {
		this.meta = meta;
	}
	
	public float getMetaCumprida() {
		return metaCumprida;
	}
	
	public void setMetaCumprida(float metaCumprida) {
		this.metaCumprida = metaCumprida;
	}
	
}
