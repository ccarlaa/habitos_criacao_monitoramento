package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleHabitos;

class TesteHabitos {
	ControleHabitos controleHabitos = new ControleHabitos();

	@Test
	void getHabitosMensuravei() {
		assertTrue(controleHabitos.equals(controleHabitos));
	}

}
