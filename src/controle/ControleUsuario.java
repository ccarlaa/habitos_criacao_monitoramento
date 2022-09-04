package controle;

public class ControleUsuario {
	public int getIdUsuario(String email, ControleDados dados) {
		int qtdUsuarios = dados.getQtdUsuarios();
		int usuarioId = 0;
		for(int i = 0; i < qtdUsuarios; i++) {
			if(dados.getUsuarios()[i].getEmail().equals(email)) {
				usuarioId = dados.getUsuarios()[i].getId();
			}
		}
		return usuarioId;
	}
}
