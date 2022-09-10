package controle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import modelo.HabitoMensuravel;
import modelo.HabitoSimNao;

/**
 * A classe ControleHabitos é responsável pelas funcionalidades relacionados ao usuário
 * 
 * @author carla
 */

public class ControleHabitos {
	
	/**
	 * Responsável por filtrar os hábitos do tipo "mensurável" por meio do identificador do usuário.
	 * Retorna os nomes dos hábitos com um emoji se o hábito foi feito e sem caso contrário.
	 * 
	 * @param dados todas as informações salvas
	 * @param usuarioId identificador do usuário
	 * 
	 * @return habitos mensuraveis
	 * 
	 * @see ControleDados
	 */
	
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
	
	/**
	 * Retorna a posição que se encontra as informações de um hábito do tipo "mensurável" no array 
	 * "habitoMensuravel" da classe Dados.
	 * 
	 * @param dados todas as informações salvas
	 * @param usuarioId identificado do usuário
	 * @param nome nome do hábito selecionado
	 * 
	 * @return index - posição do hábito no array
	 * 
	 * @see ControleDados
	 */
	
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
	
	/**
	 * Retorna os lembretes do hábito do tipo "mensurável" presente na posição (index) especificada do 
	 * array habitoMensuravel da classe Dados.
	 * 
	 * @param dados todas as informações salvas
	 * @param index posição do hábito selecionado no array
	 * 
	 * @return lembretes 
	 * 
	 * @see ControleDados
	 */
	
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
	
	/**
	 * Responsável por definir um hábito do tipo "mensurável", na posição especificada (index)
	 * do array habitoMensuravel da classe Dados, como feito.
	 * 
	 * Valida se as informações do hábito estão corretas e se o hábito já não está marcado
	 * como feito. Se a validação não for bem sucedida, retorna uma mensagem contendo o
	 * problema.
	 * 
	 * Se a validação é bem sucedida, por meio da posição do hábito no array "habitoMensuravel"
	 * da classe Dados, é realizada uma atualização dos dados. 
	 * 
	 * É validado:
	 * 
	 * <ol>
	 * 	<li>se todos os campos foram preenchidos, salvo o campo "anotações"</li>
	 * 	<li>se o hábito já foi feito</li>
	 * </ol>
	 * 
	 * @param dados todas as informações salvas
	 * @param index posição do hábito no array
	 * @param id identificador do usuário
	 * @param nome nome do hábito
	 * @param meta meta do hábito
	 * @param minimo mínimo a ser realizado do hábito
	 * @param anotacoes anotações do hábito
	 * @param horarios horários que o hábito deve ser cumprido
	 * @param dias dias que o hábito deve ser cumprido
	 * 
	 * @return mensagem
	 * 
	 * @see ControleDados
	 * @see HabitoMensuravel
	 */
	
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
	
	/**
	 * Responsável pela atualização de um hábito do tipo "mensurável", identificado por sua posição 
	 * (index) no array "habitoMensuravel" da classe Dados.
	 *  
	 * Valida se as informações foram preenchidas e, em caso de erro, retorna uma mensagem
	 * contendo o problema, caso contrário, atualiza as informções do hábito em questão.
	 * 
	 * É validado:
	 * <ol>
	 * 	<li>se todos os campos foram preenchidos, salvo o campo "anotações"</li>
	 * </ol>
	 * 
	 * 
	 * @param dados todas as informações salvas
	 * @param index posição do hábito no array
	 * @param id identificador do usuário
	 * @param nome nome do hábito
	 * @param meta meta do hábito
	 * @param minimo mínimo a ser realizado do hábito
	 * @param anotacoes anotações do hábito
	 * @param horarios horários que o hábito deve ser cumprido
	 * @param dias dias que o hábito deve ser cumprido
	 * 
	 * @return mensagem
	 * 
	 * @see ControleDados
	 * @see HabitoMensuravel
	 */
	
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
	
	/**
	 * Apaga as informações de um hábito do tipo "mensurável" a partir da sua posição (index)
	 * no array "habitoMensuravel" da classe Dados.
	 * 
	 * @param dados todas as informações salvas
	 * @param index posição do hábito no array
	 * 
	 * @see ControleDados
	 * 
	 */
	
	public void deleteHabitoMensuravel(ControleDados dados, int index) {
		dados.setHabitosMensuraveis(null, index);
	}
	
	/**
	 * Salva os dados de um novo hábito do tipo "mensurável" no array habitoMensuravel da classe Dados.
	 * 
	 * Para futura identificação é salvo junto as informações o identificador do usuário criador do
	 * hábito.
	 * 
	 * Faz a validação dos dados e retorna uma mensagem em caso de erro explicando o problema.
	 * 
	 * É validado: 
	 * 	- se todos os campos foram preenchidos, salvo "anotações"
	 * 	- se já existe um hábito com o mesmo nome
	 * 
	 * @param dados todas as informações salvas
	 * @param id identificador do usuário
	 * @param nome nome do hábito
	 * @param meta meta do hábito
	 * @param minimo mínimo a ser realizado do hábito
	 * @param anotacoes anotações do hábito
	 * @param horarios horários que o hábito deve ser cumprido
	 * @param dias dias que o hábito deve ser cumprido
	 * 
	 * @return mensagem
	 * 
	 * @see HabitoMensuravel
	 * @see HabitoMensuravel
	 */
	
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
	
	/**
	 * Responsável por filtrar os hábitos do tipo "sim não" por meio do identificador do usuário.
	 * 
	 * Retorna os nomes dos hábitos com um emoji se o hábito foi feito e sem caso contrário.
	 * 
	 * 
	 * @param dados todas as informações salvas
	 * @param usuarioId posição do hábito no array
	 * 
	 * @return mensagem
	 * 
	 * @see ControleDados
	 */
	
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
	
	/**
	 * Salva os dados de um novo hábito do tipo "sim não" no array habitoSimNao da classe Dados.
	 * 
	 * Para futura identificação é salvo junto as informações o identificador do usuário criador do
	 * hábito.
	 * 
	 * Faz a validação dos dados e retorna uma mensagem em caso de erro explicando o problema.
	 * 
	 * É validado: 
	 * 
	 * <ol>
	 * 	<li>se todos os campos foram preenchidos, salvo "anotações"</li>
	 *  <li>se já existe um hábito com o mesmo nome</li>
	 * </ol>
	 * 
	 * @param dados todas as informações salvas
	 * @param id identificador do usuário
	 * @param nome nome do hábito
	 * @param frequencia quantidade de vezes que o hábito deve ser realizado
	 * @param anotacoes anotações do hábito
	 * @param horarios horários que o hábito deve ser cumprido
	 * @param dias dias que o hábito deve ser cumprido
	 * 
	 * @return mensagem
	 * 
	 * @see ControleDados
	 */
		
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
	
	/**
	 * Retorna os lembretes do hábito do tipo "sim não" presente na posição (index) especificada do array habitoMensuravel
	 * da classe Dados.
	 * 
	 * @param dados todas as informações salvas
	 * @param index posição do hábito no array
	 * 
	 * @return lembretes
	 * 
	 * @see ControleDados
	 */
	
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
	
	/**
	 * Responsável por definir um hábito do tipo "sim não" como feito.
	 * 
	 * Valida se as informações do hábito estão corretas e se o hábito já não está marcado
	 * como feito. Se a validação não for bem sucedida, retorna uma mensagem contendo o
	 * problema.
	 * 
	 * Se a validação é bem sucedida, por meio da posição do hábito no array "habitoSimNao"
	 * da classe Dados, é realizada uma atualização dos dados. 
	 * 
	 * É validado:
	 * <ol>
	 * 	<li>se todos os campos foram preenchidos, salvo "anotações"</li>
	 *  <li>se já existe um hábito com o mesmo nome</li>
	 * </ol>
	 * 
	 * 
	 * @param dados todas as informações salvas
	 * @param index posição do hábito no array
	 * @param id identificador do usuário
	 * @param nome nome do hábito
	 * @param frequencia quantidade de vezes que o hábito deve ser realizado
	 * @param anotacoes anotações do hábito
	 * @param horarios horários que o hábito deve ser cumprido
	 * @param dias dias que o hábito deve ser cumprido
	 * 
	 * @return mensagem
	 * 
	 * @see ControleDados
	 * @see HabitoSimNao
	 */
	
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
	
	/**
	 * Responsável pela atualização de um hábito do tipo "sim não", identificado por sua posição 
	 * (index) no array "habitoSimNao" da classe Dados.
	 *  
	 * Valida se as informações foram preenchidas e, em caso de erro, retorna uma mensagem
	 * contendo o problema, caso contrário, atualiza as informções do hábito em questão.
	 * 
	 * É validado:
	 * 	- se todos os campos foram preenchidos, salvo o campo "anotações"
	 * 
	 * @param dados todas as informações salvas
	 * @param index posição do hábito no array
	 * @param id identificador do usuário
	 * @param nome nome do hábito
	 * @param frequencia quantidade de vezes que o hábito deve ser realizado
	 * @param anotacoes anotações do hábito
	 * @param horarios horários que o hábito deve ser cumprido
	 * @param dias dias que o hábito deve ser cumprido
	 * 
	 * @return mensagem
	 * 
	 * @see ControleDados
	 * @see HabitoSimNao
	 */
	
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
	
	/**
	 * Apaga as informações de um hábito do tipo "sim não" a partir da sua posição (index)
	 * no array "habitoSimNao" da classe Dados
	 * 
	 * @param dados todas as informações salvas
	 * @param index posição do hábito no array
	 * 
	 * @see ControleDados
	 */
	
	public void deletarHabitoSimNao(ControleDados dados, int index) {
		dados.setHabitosSimNao(null, index);
	}
}
