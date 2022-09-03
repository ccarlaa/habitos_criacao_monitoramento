package teste;

import static org.junit.jupiter.api.Assertions.*;

import controle.ControleUsuario;

import org.junit.jupiter.api.Test;

class TesteUsuario {
	ControleUsuario controleUsuario = new ControleUsuario();

	@Test
	void getIdUsuario() {
		assertTrue(controleUsuario.equals(controleUsuario));
	}
}
