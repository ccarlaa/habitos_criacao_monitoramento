package modelo;

public class Dados {
	private Usuario[] usuarios = new Usuario[50];
	private int qtdUsuario;
	private HabitoSimNao[] habitoSimNao = new HabitoSimNao[50];
	private int qtdHabitosSimNao;
	private HabitoMensuravel[] habitoMensuravel = new HabitoMensuravel[50];
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
	
	public HabitoSimNao[] getHabitoSimNao() {
		return habitoSimNao;
	}
	
	public void setHabitoSimNao(HabitoSimNao[] habitoSimNao) {
		this.habitoSimNao = habitoSimNao;
		setQtdHabitosSimNao(getQtdHabitosSimNao() + 1);
	}
	
	public int getQtdHabitosSimNao() {
		return qtdHabitosSimNao;
	}
	
	public void setQtdHabitosSimNao(int qtdHabitosSimNao) {
		this.qtdHabitosSimNao = qtdHabitosSimNao;
	}
	
	public HabitoMensuravel[] getHabitoMensuravel() {
		return habitoMensuravel;
	}
	
	public void setHabitoMensuravel(HabitoMensuravel[] habitoMensuravel) {
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
