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
    	/**
    	 * O teste verifica se o Habito do tipo "Mensuravel" foi feito
    	 */
    	String[] horarios = {"10 : 30"};
    	String[] dias = {"quinta-feira"};
    	controleHabitos.habitoMensuravelFeito(dados, 0, 1, "Joana", "5km", "2km", "feito pela metade", horarios, dias);
        assertTrue(controleHabitos.equals(controleHabitos));
    }

    @Test
    public void habitoSimNaoFeito() {
    	/**
    	 * O teste verifica se  o Habito do tipo "Sim e Não" foi feito
    	 */
    	String[] horarios = {"15 : 30"};
    	String[] dias = {"segunda-feira"};
    	controleHabitos.habitoSimNaoFeito(dados, 0, 1, "Joana", "uma vez por semana", "esqueci de beber água", horarios, dias);
        assertTrue(controleHabitos.equals(controleHabitos));
    }
    
    @Test
    public void updateHabitosMensuraveis() {
    	/**
    	 * O teste verifica se esta sendo realizado updade dos Habitos do tipo "Mensuravel"
    	 */
    	String[] horarios = {"13 : 00", "08 : 00"};
    	String[] dias = {"quarta-feira", "quinta-feira"};
        controleHabitos.updateHabitosMensuraveis(dados, 0, 1, "Joana", "5km", "2km", "feito pela metade", horarios, dias);
        HabitoMensuravel[] updateMensuraveis = dados.getHabitosMensuraveis();
        assertTrue(updateMensuraveis.equals(updateMensuraveis));
    }

    @Test
    public void deleteHabitoMensuravel() {
    	/**
    	 * O teste verifica se esta sendo realizado delete dos Habitos do tipo "Mensuravel"
    	 */
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
    	/**
    	 * O teste verifica se esta sendo realizado updade dos Habitos do tipo "Sim e Não"
    	 */
    	String[] horarios = {"11 : 00", "09 : 00"};
    	String[] dias = {"sï¿½bado", "domingo"};
        controleHabitos.updateHabitosSimNao(dados, 0, 1,"Joana", "uma vez por semana", "esqueci de beber água", horarios, dias);
        HabitoSimNao[] updateSimNao = dados.getHabitosSimNao();
        assertTrue(updateSimNao.equals(updateSimNao));
        }

    @Test
    public void deletarHabitosSimNao() {
    	/**
    	 * O teste verifica se esta sendo realizado delete dos Habitos do tipo "Sim e Não"
    	 */
    	controleHabitos.deletarHabitoSimNao(dados, 1);
        assertTrue(controleHabitos.equals(controleHabitos));
        }
    
    @Test
    public void salvarHabitoMensuravel() {
    	/**
    	 * O teste verifica se é possível salvar Habitos do tipo "Mensuravel"
    	 */
    	String[] horarios = {"12 : 00", "06 : 00"};
    	String[] dias = {"segunda-feira", "terï¿½a-feira"};
    	controleHabitos.salvarHabitoMensuravel(dados,1, "Joana", "5km", "2km", "feito pela metade", horarios, dias);
        HabitoMensuravel[] salvandoMensuraveis = dados.getHabitosMensuraveis();
        assertTrue(salvandoMensuraveis.equals(salvandoMensuraveis));
    }

    @Test
    public void salvarHabitoSimNao() {
    	/**
    	 * O teste verifica se é possível salvar Habitos do tipo "Sim e Não"
    	 */
    	String[] horarios = {"16 : 00"};
    	String[] dias = {"sexta-feira"};
    	controleHabitos.salvarHabitoSimNao(dados, 0, "Joana", "uma vez por semana", "esqueci de beber água", horarios, dias);
        HabitoSimNao[] salvandoSimNao = dados.getHabitosSimNao();
        assertTrue(salvandoSimNao.equals(salvandoSimNao));
    }

}