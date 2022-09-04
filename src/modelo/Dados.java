package modelo;

import java.util.Arrays;

public class Dados {
	private Usuario[] usuarios = new Usuario[50];
	private int qtdUsuario = 1;
	private HabitoSimNao[] habitoSimNao = new HabitoSimNao[50];
	private int qtdHabitosSimNao;
	private HabitoMensuravel[] habitoMensuravel = new HabitoMensuravel[50];
	private int qtdHabitoMensuravel = 4;
	
	public void popularBanco() {
		String[] dias = {"segunda-feira", "terça-feira", "quarta-feira","quinta-feira", "sexta-feira"};
		String[] horarios = {"12:30", "06:45", "21:45", "09:00", "16:05"};
		usuarios[0] = new Usuario("teste", "teste@gmail.com", "1234", 0);
		for(int i = 0; i < 5; i++) {
			habitoMensuravel[i] = new HabitoMensuravel("correr" + i, "levar água", horarios, dias, 0, "10km", "8km" );
		}
	}
	
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(Usuario usuarios) {
		this.usuarios[getQtdUsuario()] = usuarios;
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
	
	public void setHabitoMensuravel(HabitoMensuravel habitoMensuravel) {
		this.habitoMensuravel[getQtdHabitoMensuravel()] = habitoMensuravel;
	}
	
	public int getQtdHabitoMensuravel() {
		return qtdHabitoMensuravel;
	}
	
	public void setQtdHabitoMensuravel(int qtdHabitoMensuravel) {
		this.qtdHabitoMensuravel = qtdHabitoMensuravel;
	}

	@Override
	public String toString() {
		return "Dados [usuarios=" + Arrays.toString(usuarios) + ", qtdUsuario=" + qtdUsuario + ", habitoSimNao="
				+ Arrays.toString(habitoSimNao) + ", qtdHabitosSimNao=" + qtdHabitosSimNao + ", habitoMensuravel="
				+ Arrays.toString(habitoMensuravel) + ", qtdHabitoMensuravel=" + qtdHabitoMensuravel + "]";
	}
	
	
}
