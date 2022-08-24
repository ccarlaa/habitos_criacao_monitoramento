package modelo;

public class Dados {
	private Usuario[] usuarios = new Usuario[50];
	private int qtdUsuario;
	private Habito_sim_nao[] habitoSimNao = new Habito_sim_nao[50];
	private int qtdHabitosSimNao;
	private Habito_mensuravel[] habitoMensuravel = new Habito_mensuravel[50];
	private int qtdHabitoMensuravel;
	

	public Usuario[] getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
		setQtdUsuario(getQtdUsuario() + 1);
	}
	
	public int getQtdUsuario() {
		return qtdUsuario;
	}
	
	public void setQtdUsuario(int qtdUsuario) {
		this.qtdUsuario = qtdUsuario;
	}
	
	public Habito_sim_nao[] getHabitoSimNao() {
		return habitoSimNao;
	}
	
	public void setHabitoSimNao(Habito_sim_nao[] habitoSimNao) {
		this.habitoSimNao = habitoSimNao;
		setQtdHabitosSimNao(getQtdHabitosSimNao() + 1);
	}
	
	public int getQtdHabitosSimNao() {
		return qtdHabitosSimNao;
	}
	
	public void setQtdHabitosSimNao(int qtdHabitosSimNao) {
		this.qtdHabitosSimNao = qtdHabitosSimNao;
	}
	
	public Habito_mensuravel[] getHabitoMensuravel() {
		return habitoMensuravel;
	}
	
	public void setHabitoMensuravel(Habito_mensuravel[] habitoMensuravel) {
		this.habitoMensuravel = habitoMensuravel;
		setQtdHabitoMensuravel(getQtdHabitoMensuravel() + 1);
	}
	
	public int getQtdHabitoMensuravel() {
		return qtdHabitoMensuravel;
	}
	
	public void setQtdHabitoMensuravel(int qtdHabitoMensuravel) {
		this.qtdHabitoMensuravel = qtdHabitoMensuravel;
	}
	
	
}
