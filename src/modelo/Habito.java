package modelo;

public abstract class Habito {
	public String nome;
	public String anotacoes;
	public String[] horarios = new String[5] ;
	public String[] dias = new String[7];
	public int id;

	public Habito(String nome, String anotacoes, String[] horarios, String[] dias, int id) {
		super();
		this.nome = nome;
		this.anotacoes = anotacoes;
		this.horarios = horarios;
		this.dias = dias;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getAnotacoes() {
		return anotacoes;
	}
	
	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public String[] getHorarios() {
		return horarios;
	}

	public void setHorarios(String[] horarios) {
		this.horarios = horarios;
	}

	public String[] getDias() {
		return dias;
	}

	public void setDias(String[] dias) {
		this.dias = dias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
