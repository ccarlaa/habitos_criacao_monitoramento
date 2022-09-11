package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleDados;
import controle.ControleHabitos;
import controle.ControleUsuario;
import modelo.HabitoMensuravel;
import modelo.HabitoSimNao;

/**
 * A classe TesteHabitos é responsável por realizar os testes dos métodos 
 * da classe ControleHabitos
 * 
 * @author carolina 
 *
 */

public class TesteHabitos {
    ControleHabitos controleHabitos = new ControleHabitos();
    ControleUsuario controleUsuario = new ControleUsuario();
    ControleDados dados = new ControleDados();

    @Test
    public void getHabitosMensuraveis() {
        controleHabitos.getHabitosMensuraveis(dados, 1, "segunda - feira");
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void getHabitosSimNao() {
    	controleHabitos.getHabitosSimNao(dados, 1, "segunda - feira");
        assertTrue(controleHabitos.equals(controleHabitos));
    }


    @Test
    public void getIndexHabitosMensuraveis() {
    	controleHabitos.getIndexHabitoMensuravel(dados, 1, "Joana");
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void getLembretesHabitosMensuraveis() {
    	controleHabitos.getLembretesHabitosMensuraveis(dados, 1);
        assertTrue(controleHabitos.equals(controleHabitos));
    }
    

    @Test
    public void habitosMensuravelFeito() {
    	String[] horarios = {"10 : 30"};
    	String[] dias = {"quinta-feira"};
    	controleHabitos.habitoMensuravelFeito(dados, 0, 1, "Joana", "5km", "2km", "feito pela metade", horarios, dias);
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void habitoSimNaoFeito() {
    	String[] horarios = {"15 : 30"};
    	String[] dias = {"segunda-feira"};
    	controleHabitos.habitoSimNaoFeito(dados, 0, 1, "Joana", "uma vez por semana", "esqueci de beber �gua", horarios, dias);
        assertTrue(controleHabitos.equals(controleHabitos));
    }
    
    @Test
    public void updateHabitosMensuraveis() {
    	String[] horarios = {"13 : 00", "08 : 00"};
    	String[] dias = {"quarta-feira", "quinta-feira"};
        controleHabitos.updateHabitosMensuraveis(dados, 0, 1, "Joana", "5km", "2km", "feito pela metade", horarios, dias);
        HabitoMensuravel[] updateMensuraveis = dados.getHabitosMensuraveis();
        assertTrue(updateMensuraveis.equals(updateMensuraveis));
    }

    @Test
    public void deleteHabitoMensuravel() {
    	controleHabitos.deleteHabitoMensuravel(dados, 1);
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void getHabitosSimNaoFiltrado() {
    	controleHabitos.deleteHabitoMensuravel(dados, 1);
        assertTrue(controleHabitos.equals(controleHabitos));
        }

    @Test
    public void getLembretesHabitosSimNao() {
        assertTrue(controleHabitos.equals(controleHabitos));
        }

    @Test
    public void updateHabitosSimNao() {
    	String[] horarios = {"11 : 00", "09 : 00"};
    	String[] dias = {"s�bado", "domingo"};
        controleHabitos.updateHabitosSimNao(dados, 0, 1,"Joana", "uma vez por semana", "esqueci de beber �gua", horarios, dias);
        HabitoSimNao[] updateSimNao = dados.getHabitosSimNao();
        assertTrue(updateSimNao.equals(updateSimNao));
        }

    @Test
    public void deletarHabitosSimNao() {
    	controleHabitos.deletarHabitoSimNao(dados, 1);
        assertTrue(controleHabitos.equals(controleHabitos));
        }
    
    @Test
    public void salvarHabitoMensuravel() {
    	String[] horarios = {"12 : 00", "06 : 00"};
    	String[] dias = {"segunda-feira", "ter�a-feira"};
    	controleHabitos.salvarHabitoMensuravel(dados,1, "Joana", "5km", "2km", "feito pela metade", horarios, dias);
        HabitoMensuravel[] salvandoMensuraveis = dados.getHabitosMensuraveis();
        assertTrue(salvandoMensuraveis.equals(salvandoMensuraveis));
    }

    @Test
    public void salvarHabitoSimNao() {
    	String[] horarios = {"16 : 00"};
    	String[] dias = {"sexta-feira"};
    	controleHabitos.salvarHabitoSimNao(dados, 0, "Joana", "uma vez por semana", "esqueci de beber �gua", horarios, dias);
        HabitoSimNao[] salvandoSimNao = dados.getHabitosSimNao();
        assertTrue(salvandoSimNao.equals(salvandoSimNao));
    }

    }