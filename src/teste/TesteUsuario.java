package teste;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controle.*;
import modelo.Usuario;

/**
 * A classe TesteUsuario é responsável por realizar os testes dos métodos 
 * da classe ControleUsuario
 * 
 * @author carolina 
 *
 */

public class TesteUsuario {
    ControleUsuario controleUsuario = new ControleUsuario();
    ControleDados dados = new ControleDados();

    @Test
    public void getIdUsuario() {
        assertTrue(controleUsuario.equals(controleUsuario));
    }
    
    /**
     * O teste é realizado para criar um usuário
     */

    @Test
    public void criarUsuario() {
        controleUsuario.criarUsuario(dados,"Maria Jose Silva", "maria_jose3@hotmail.com", "majose12345", "majose12345");
        Usuario[] novoUsuario = dados.getUsuarios();
        assertTrue(novoUsuario.equals(novoUsuario));
    }
    
    /**
     * O teste é realizado para logar um usuário já cadastrado
     */

    @Test
    public void logar() {
        controleUsuario.logar(dados,"maria_jose3@hotmail.com", "majose12345");
        Usuario[] loginUsuario = dados.getUsuarios();
        assertTrue(loginUsuario.equals(loginUsuario));
    }
}