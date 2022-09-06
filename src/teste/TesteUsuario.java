package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleUsuario;

class TesteUsuario {
	ControleUsuario controleUsuario = new ControleUsuario();

	@Test
	void getIdUsuario() {
		assertTrue(controleUsuario.equals(controleUsuario));
	}
}
