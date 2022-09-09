package controle;
import modelo.*;

/**
 * A classe Controle dados realiza a validação e gerênciamento dos objetos criados
 * 
 * @author carla
 */

public class ControleDados {
	private Dados dados = new Dados();
	
	public ControleDados() {
		dados.dados();
	}
	
	public Usuario[] getUsuarios() {
		return dados.getUsuarios();
	}
	
	public int getQtdUsuarios() {
		return dados.getQtdUsuario();
	}
	
	public void setQtdUsuarios(int valor) {
		dados.setQtdUsuario(valor);
	}
	
	public void setUsuario(Usuario usuario) {
		dados.setUsuarios(usuario);
	}
	
	public int qtdHabitosMensuraveis() {
		return dados.getQtdHabitoMensuravel();
	}
	
	public void setHabitosMensuraveis(HabitoMensuravel infos, int index) {
		 dados.setHabitoMensuravel(infos, index);
	}
	
	public HabitoMensuravel[] getHabitosMensuraveis() {
		return dados.getHabitoMensuravel();
	}
	
	public void setQtdHabitosMensuraveis(int valor) {
		dados.setQtdHabitoMensuravel(valor);
	}
	
	public int qtdHabitosSimNao() {
		return dados.getQtdHabitosSimNao();
	}
	
	public HabitoSimNao[] getHabitosSimNao() {
		return dados.getHabitoSimNao();
	}
	
	public void setHabitosSimNao(HabitoSimNao infos, int index) {
		 dados.setHabitoSimNao(infos, index);
	}
	
	public void sethabitoSimNaofeito(HabitoSimNao infos, int index) {
		 dados.setHabitoSimNao(infos, index);
	}
	
	public void setQtdHabitosSimNao(int valor) {
		dados.setQtdHabitoMensuravel(valor);
	}
}
