package controle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ControleHabitos {
	public String[] getHabitosMensuraveis(ControleDados dados, int usuarioId) {
		int qtdHabitos = 0;
		for(int i = 0; i < dados.qtdHabitosMensuraveis(); i++) {
			if(dados.getHabitosMensuraveis()[i].getId() == usuarioId) {
				qtdHabitos++;
			}
		}
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEEE");
		String dia = df.format(date);
		String[] habitos = new String[qtdHabitos];
		int tamanhoLista = 0;
		for(int i = 0; i < dados.qtdHabitosMensuraveis(); i++) {
			if(dados.getHabitosMensuraveis()[i].getId() == usuarioId ) {
				List<String> lista = Arrays.asList(dados.getHabitosMensuraveis()[i].getDias());
				if(lista.contains(dia)) {
					habitos[tamanhoLista] = dados.getHabitosMensuraveis()[i].getNome();
					tamanhoLista++;
				}
			}
		}
		
		return habitos;
	}
	
	public String[] getHabitosSimNao(ControleDados dados, int usuarioId) {
		int qtdHabitos = 0;
		for(int i = 0; i < dados.qtdHabitosSimNao(); i++) {
			if(dados.getHabitosSimNao()[i].getId() == usuarioId) {
				qtdHabitos++;
			}
		}
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEEE");
		String dia = df.format(date);
		String[] habitos = new String[qtdHabitos];
		int tamanhoLista = 0;
		for(int i = 0; i < dados.qtdHabitosSimNao(); i++) {
			if(dados.getHabitosSimNao()[i].getId() == usuarioId ) {
				List<String> lista = Arrays.asList(dados.getHabitosSimNao()[i].getDias());
				if(lista.contains(dia)) {
					habitos[tamanhoLista] = dados.getHabitosSimNao()[i].getNome();
					tamanhoLista++;
				}
			}
		}
		
		return habitos;
	}
	
	public int getIndexHabitoMensuravel(ControleDados dados, int usuarioId, String nome) {
		int index = -1;
		for(int i = 0; i < dados.qtdHabitosMensuraveis(); i ++) {
			if(dados.getHabitosMensuraveis()[i].getNome().equals(nome) && 
					dados.getHabitosMensuraveis()[i].getId() == usuarioId) {
				index = i;
			}
		}
		return index;
	}
	
	public String[] getLembretes(ControleDados dados, int index) {
		String[] dias = dados.getHabitosMensuraveis()[index].getDias();
		String[] horarios = dados.getHabitosMensuraveis()[index].getHorarios();
		String[] lembretes = new String[dias.length];
		for(int i = 0; i < dias.length; i++) {
			lembretes[i] = dias[i] + " - " + horarios[i];
		}
		return lembretes;
	}
}
