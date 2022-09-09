package teste;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controle.*;
import modelo.Usuario;

public class TesteUsuario {
    ControleUsuario controleUsuario = new ControleUsuario();
    ControleDados dados = new ControleDados();

    @Test
    public void getIdUsuario() {
        assertTrue(controleUsuario.equals(controleUsuario));
    }
    
    @Test
    public void criarUsuario() {
    	controleUsuario.criarUsuario(dados,"Maria Jose Silva", "maria_jose3@hotmail.com", "majose12345", "majose12345");
        Usuario[] novoUsuario = dados.getUsuarios();
        assertTrue(novoUsuario.equals(novoUsuario));
    }

    @Test
    public void logar() {
    	controleUsuario.logar(dados,"maria_jose3@hotmail.com", "majose12345");
        Usuario[] loginUsuario = dados.getUsuarios();
        assertTrue(loginUsuario.equals(loginUsuario));
    }
}