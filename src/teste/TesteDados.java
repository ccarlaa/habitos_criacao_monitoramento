package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleDados;
import modelo.Usuario;


class TesteDados {
	
	ControleDados controleDados = new ControleDados();

	@Test
	void getUsuarios() {
		assertTrue(controleDados.equals(controleDados));
	}
	
	@Test
	void getQtdUsuarios() {
		int qtdatual = controleDados.getQtdUsuarios();
		assertEquals(00, qtdatual);
	}
	
	@Test
	void criarUsuario() {
		controleDados.criarUsuario("Maria Jose Silva", "maria_jose3@hotmail.com", "majose12345", "majose12345");
		Usuario[] novoUsuario = controleDados.getUsuarios();
		assertTrue(novoUsuario.equals(novoUsuario));
	}
	
	@Test
	void logar() {
		controleDados.logar("maria_jose3@hotmail.com", "majose12345");
		Usuario[] loginUsuario = controleDados.getUsuarios();
		assertTrue(loginUsuario.equals(loginUsuario));
	}

	@Test
	void salvarHabitoMensuravel() {
		controleDados.salvarHabitoMensuravel(0, null, null, null, null, null, null);
		Usuario[] habitoMensuravel = controleDados.getUsuarios();
		assertTrue(habitoMensuravel.equals(habitoMensuravel));
	}
}

