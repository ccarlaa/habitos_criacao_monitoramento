package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.*;

public class TesteUsuario {
	ControleUsuario controleUsuario = new ControleUsuario();

	@Test
	public void getIdUsuario() {
		assertTrue(controleUsuario.equals(controleUsuario));
	}
}
