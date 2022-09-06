package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleHabitos;

public class TesteHabitos {
	ControleHabitos controleHabitos = new ControleHabitos();

	@Test
	public void getHabitosMensuravei() {
		assertTrue(controleHabitos.equals(controleHabitos));
	}

}
