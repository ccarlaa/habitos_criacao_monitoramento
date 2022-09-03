package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.ControleHabitos;

class TesteHabitos {
	ControleHabitos controleHabitos = new ControleHabitos();

	@Test
	void getHabitosMensuravei() {
		assertTrue(controleHabitos.equals(controleHabitos));
	}

}
