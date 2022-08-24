package modelo;

public abstract class Habito {
	public String nome;
	public String questao;
	public String anotacoes;
	public Lembrete[] lembretes = new Lembrete[10] ;
	
	public Habito(String nome, String questao, String anotacoes, Lembrete[] lembretes) {
		super();
		this.nome = nome;
		this.questao = questao;
		this.anotacoes = anotacoes;
		this.lembretes = lembretes;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getQuestao() {
		return questao;
	}
	
	public void setQuestao(String questao) {
		this.questao = questao;
	}
	
	public String getAnotacoes() {
		return anotacoes;
	}
	
	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}
	
	public Lembrete[] getLembretes() {
		return lembretes;
	}
	
	public void setLembretes(Lembrete[] lembretes) {
		this.lembretes = lembretes;
	}
	
}
