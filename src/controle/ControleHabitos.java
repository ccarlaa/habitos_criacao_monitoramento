package controle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import modelo.HabitoMensuravel;
import modelo.HabitoSimNao;

public class ControleHabitos {
	public String[] getHabitosMensuraveis(ControleDados dados, int usuarioId) {
		int qtdHabitos = 0;
		for(int i = 0; i < dados.qtdHabitosMensuraveis(); i++) {
			if(dados.getHabitosMensuraveis()[i] != null) {
				if(dados.getHabitosMensuraveis()[i].getId() == usuarioId) {
					qtdHabitos++;
				}
			}
		}
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEEE");
		String dia = df.format(date);
		String[] habitos = new String[qtdHabitos];
		int tamanhoLista = 0;
		
		for(int i = 0; i < dados.qtdHabitosMensuraveis(); i++) {
			if(dados.getHabitosMensuraveis()[i] != null) {
				if(dados.getHabitosMensuraveis()[i].getId() == usuarioId ) {
					List<String> lista = Arrays.asList(dados.getHabitosMensuraveis()[i].getDias());
					if(lista.contains(dia)) {
						habitos[tamanhoLista] = dados.getHabitosMensuraveis()[i].getNome();
						tamanhoLista++;
					}
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
			if(dados.getHabitosSimNao()[i] != null) {
				if(dados.getHabitosSimNao()[i].getId() == usuarioId ) {
					List<String> lista = Arrays.asList(dados.getHabitosSimNao()[i].getDias());
					if(lista.contains(dia)) {
						habitos[tamanhoLista] = dados.getHabitosSimNao()[i].getNome();
						tamanhoLista++;
					}
				}
			}
		}
		
		return habitos;
	}
	
	public int getIndexHabitoMensuravel(ControleDados dados, int usuarioId, String nome) {
		int index = -1;
		for(int i = 0; i < dados.qtdHabitosMensuraveis(); i ++) {
			if(dados.getHabitosMensuraveis()[i] != null) {
				if(dados.getHabitosMensuraveis()[i].getNome().equals(nome) && 
						dados.getHabitosMensuraveis()[i].getId() == usuarioId) {
					index = i;
				}
			}
		}
		return index;
	}
	
	public String[] getLembretesHabitosMensuraveis(ControleDados dados, int index) {
		String[] dias = dados.getHabitosMensuraveis()[index].getDias();
		String[] horarios = dados.getHabitosMensuraveis()[index].getHorarios();
		String[] lembretes = new String[dias.length];
		for(int i = 0; i < dias.length; i++) {
			if(dias[i] != null) {
				lembretes[i] = dias[i] + " - " + horarios[i];
			}
		}
		return lembretes;
	}
	
	public String updateHabitosMensuraveis(
			ControleDados dados, 
			int index, 
			int id,
			String nome,
			String meta,
			String minimo,
			String anotacoes,
			String[] horarios,
			String[] dias
		) {
		String mensagem = "";
		if(nome.equals("") || meta.equals("") || minimo.equals("") || horarios[0] == null) {
			return mensagem = "Preencha todos os campos";
		}

		HabitoMensuravel infos = new HabitoMensuravel(nome, anotacoes, horarios, dias, id, meta, minimo);
		dados.setHabitosMensuraveis(infos, index);
		
		return mensagem;
	}
	
	public void deleteHabitoMensurável(ControleDados dados, int index) {
		dados.setHabitosMensuraveis(null, index);
	}
	
	public String[] getHabitosSimNaoFiltrado(ControleDados dados, int usuarioId) {
		int qtdHabitos = 0;
		for(int i = 0; i < dados.qtdHabitosSimNao(); i++) {
			if(dados.getHabitosSimNao()[i] != null) {
				if(dados.getHabitosSimNao()[i].getId() == usuarioId) {
					qtdHabitos++;
				}
			}
		}
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEEE");
		String dia = df.format(date);
		String[] habitos = new String[qtdHabitos];
		int tamanhoLista = 0;
		
		for(int i = 0; i < dados.qtdHabitosSimNao(); i++) {
			if(dados.getHabitosSimNao()[i] != null) {
				if(dados.getHabitosSimNao()[i].getId() == usuarioId ) {
					List<String> lista = Arrays.asList(dados.getHabitosSimNao()[i].getDias());
					if(lista.contains(dia)) {
						habitos[tamanhoLista] = dados.getHabitosSimNao()[i].getNome();
						tamanhoLista++;
					}
				}
			}
		}
		
		return habitos;
	}
	
	public String[] getLembretesHabitosSimNao(ControleDados dados, int index) {
		String[] dias = dados.getHabitosSimNao()[index].getDias();
		String[] horarios = dados.getHabitosSimNao()[index].getHorarios();
		String[] lembretes = new String[dias.length];
		for(int i = 0; i < dias.length; i++) {
			if(dias[i] != null) {
				lembretes[i] = dias[i] + " - " + horarios[i];
			}
		}
		return lembretes;
	}
	
	public String updateHabitosSimNao(
			ControleDados dados, 
			int index, 
			int id,
			String nome,
			String frequencia,
			String anotacoes,
			String[] horarios,
			String[] dias
		) {
		String mensagem = "";
		if(nome.equals("") || frequencia.equals("") || horarios[0] == null) {
			return mensagem = "Preencha todos os campos";
		}

		HabitoSimNao infos = new HabitoSimNao(nome, anotacoes, horarios, dias, id, frequencia);
		dados.setHabitosSimNao(infos, index);
		
		return mensagem;
	}
	
	public void deletarHabitoSimNao(ControleDados dados, int index) {
		dados.setHabitosSimNao(null, index);
	}
}
