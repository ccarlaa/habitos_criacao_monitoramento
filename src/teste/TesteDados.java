package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleDados;

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
    public void qtHabitosMensuraveis() {
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

}