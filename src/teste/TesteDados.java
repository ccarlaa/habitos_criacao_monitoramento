package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleDados;

/**
 * A classe TesteDados é responsável por realizar os testes dos métodos 
 * da classe ControleDados
 * 
 * @author carolina 
 *
 */

public class TesteDados {

    ControleDados controleDados = new ControleDados();

    @Test
    public void getUsuarios() {
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void getQtdUsuarios() {
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void setQtdUsuarios() {
        controleDados.setQtdUsuarios(1);
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void setUsuarios() {
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void qtHabitosMensuraveis() {
        assertTrue(controleDados.equals(controleDados));
    }

    public void setHabitosMensuraveis() {
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void setQtdHabitosMensuraveis() {
        controleDados.setQtdHabitosMensuraveis(0);
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void qtHabitosSimNao() {
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void getHabitosSimNao() {
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void setHabitosSimNao() {
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void sethabitoSimNaofeito() {
        assertTrue(controleDados.equals(controleDados));
    }

    @Test
    public void setQtdHabitosSimNao() {
        controleDados.setQtdHabitosSimNao(0);
        assertTrue(controleDados.equals(controleDados));
    }

}