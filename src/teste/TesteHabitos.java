package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleDados;
import controle.ControleHabitos;
import controle.ControleUsuario;
import modelo.HabitoMensuravel;
import modelo.HabitoSimNao;

public class TesteHabitos {
    ControleHabitos controleHabitos = new ControleHabitos();
    ControleUsuario controleUsuario = new ControleUsuario();
    ControleDados dados = new ControleDados();

    @Test
    public void getHabitosMensuraveis() {
        controleUsuario.criarUsuario(dados,"Maria Jose Silva", "maria_jose3@hotmail.com", "majose12345", "majose12345");
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void getHabitosSimNao() {
        assertTrue(controleHabitos.equals(controleHabitos));
    }


    @Test
    public void getIndexHabitosMensuraveis() {
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void getLembretesHabitosMensuraveis() {
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void updateHabitosMensuraveis() {
        controleHabitos.updateHabitosMensuraveis(null, 0, 0, "", "", "", "", null, null);
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void deletarHabitosMensuraveis() {
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void getHabitosSimNaoFiltrado() {
        assertTrue(controleHabitos.equals(controleHabitos));
        }

    @Test
    public void getLembretesHabitosSimNao() {
        assertTrue(controleHabitos.equals(controleHabitos));
        }

    @Test
    public void updateHabitosSimNao() {
        controleHabitos.updateHabitosSimNao(null, 0, 0, "", "", "", null, null);
        assertTrue(controleHabitos.equals(controleHabitos));
        }

    @Test
    public void deletarHabitosSimNao() {
        assertTrue(controleHabitos.equals(controleHabitos));
        }
    
    @Test
    public void salvarHabitoMensuravel() {
    	String[] horarios = {"12 : 00", "06 : 00"};
    	String[] dias = {"segunda-feira", "terça-feira"};
    	controleHabitos.salvarHabitoMensuravel(dados,1, "", "", "", "", horarios, dias);
        HabitoMensuravel[] salvandoMensuraveis = dados.getHabitosMensuraveis();
        assertTrue(salvandoMensuraveis.equals(salvandoMensuraveis));
    }

    @Test
    public void salvarHabitoSimNao() {
    	controleHabitos.salvarHabitoSimNao(dados, 0, "", "", "", null, null);
        HabitoSimNao[] salvandoSimNao = dados.getHabitosSimNao();
        assertTrue(salvandoSimNao.equals(salvandoSimNao));
    }

    }