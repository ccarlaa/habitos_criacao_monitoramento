package habitos__criacao_monitoramento;

public class Habito_mensuravel {
	private String unidade;
	private float meta;
	private float metaCumprida;
	private int usuarioId;
	
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
		if(getMeta() >= (getMeta() + metaCumprida)) {
			this.metaCumprida = metaCumprida;
		} else {
			System.out.println("Você excedeu a meta");
		}
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	
}
