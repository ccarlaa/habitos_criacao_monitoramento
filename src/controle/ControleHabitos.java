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
						if(dados.getHabitosMensuraveis()[i].isFeito() == false) {
							habitos[tamanhoLista] = dados.getHabitosMensuraveis()[i].getNome();
							tamanhoLista++;
						} else {
							habitos[tamanhoLista] = dados.getHabitosMensuraveis()[i].getNome() + "  😄";
							tamanhoLista++;
						}
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
	
	public String habitoMensuravelFeito(
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
		int qtdHabitosMensuraveis = dados.qtdHabitosMensuraveis();
		
		if(nome.equals("") || meta.equals("") || minimo.equals("") || horarios[0] == null) {
			return mensagem = "Preencha todos os campos";
		}
		
		if(dados.getHabitosSimNao()[index].isFeito() == true) {
			mensagem = "O hábito já está marcado como feito";
			return mensagem;
		}
		
		HabitoMensuravel infos = new HabitoMensuravel(nome, anotacoes, horarios, dias, id, true, meta, minimo);
		dados.setHabitosMensuraveis(infos, index);
		return mensagem;
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

		HabitoMensuravel infos = new HabitoMensuravel(nome, anotacoes, horarios, dias, id, false, meta, minimo);
		dados.setHabitosMensuraveis(infos, index);
		
		return mensagem;
	}
	
	public void deleteHabitoMensuravel(ControleDados dados, int index) {
		dados.setHabitosMensuraveis(null, index);
	}
	
	public String salvarHabitoMensuravel(
			ControleDados dados,
			int id,
			String nome,
			String meta,
			String minimo,
			String anotacoes,
			String[] horarios,
			String[] dias
		) {
			String mensagem = "";
			int qtdHabitosMensuraveis = dados.qtdHabitosMensuraveis();
			
			if(nome.equals("") || meta.equals("") || minimo.equals("") || horarios[0] == null) {
				return mensagem = "Preencha todos os campos";
			}
			
			for(int i = 0; i < qtdHabitosMensuraveis; i++) {
				if(dados.getHabitosMensuraveis()[i].getNome().equals(nome)) {
					return mensagem = "Já existe um hábito mensurável com esse nome";
				}
			}
			
			HabitoMensuravel habito = new HabitoMensuravel(nome, anotacoes, horarios, dias, id, false, meta, minimo);
			dados.setHabitosMensuraveis(habito, qtdHabitosMensuraveis);
			dados.setQtdHabitosMensuraveis(qtdHabitosMensuraveis + 1);
			
			System.out.println(dados.toString());
			return mensagem;
		}
		
		public String salvarHabitoSimNao(
				ControleDados dados,
				int id,
				String nome,
				String frequencia,
				String anotacoes,
				String[] horarios,
				String[] dias
			) {
				String mensagem = "";
				int qtdHabitosSimNao = dados.qtdHabitosSimNao();
				
				if(nome.equals("") || anotacoes.equals("") || frequencia.equals("") || horarios[0] == null) {
					return mensagem = "Preencha todos os campos";
				}
				
				for(int i = 0; i < qtdHabitosSimNao; i++) {
					if(dados.getHabitosSimNao()[i].getNome().equals(nome)) {
						return mensagem = "Já existe um hábito sim não com esse nome";
					}
				}
				
				HabitoSimNao habito = new HabitoSimNao(nome, anotacoes, horarios, dias, id, false, frequencia);
				dados.setHabitosSimNao(habito, qtdHabitosSimNao);
				dados.setQtdHabitosSimNao(qtdHabitosSimNao + 1);
					return mensagem;
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
						if(dados.getHabitosSimNao()[i].isFeito() == false) {
							habitos[tamanhoLista] = dados.getHabitosSimNao()[i].getNome();
							tamanhoLista++;
						} else {
							habitos[tamanhoLista] = dados.getHabitosSimNao()[i].getNome() + "  😄";
							tamanhoLista++;
						}
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
	
	public String habitoSimNaoFeito(
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
		int qtdHabitosSimNao = dados.qtdHabitosSimNao();
		
		if(nome.equals("") || anotacoes.equals("") || frequencia.equals("") || horarios[0] == null) {
			return mensagem = "Preencha todos os campos";
		}
		
		if(dados.getHabitosSimNao()[index].isFeito() == true) {
			mensagem = "O hábito já está marcado como feito";
			return mensagem;
		}
		
		HabitoSimNao infos = new HabitoSimNao(nome, anotacoes, horarios, dias, id, true, frequencia);
		dados.setHabitosSimNao(infos, index);
		return mensagem;
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

		HabitoSimNao infos = new HabitoSimNao(nome, anotacoes, horarios, dias, id, false, frequencia);
		dados.setHabitosSimNao(infos, index);
		
		return mensagem;
	}
	
	public void deletarHabitoSimNao(ControleDados dados, int index) {
		dados.setHabitosSimNao(null, index);
	}
}
