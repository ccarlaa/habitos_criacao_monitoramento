package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import controle.ControleDados;
import controle.ControleHabitos;
import controle.ControleUsuario;

/**
 * Responsável por realizar a criação de um hábito do tipo "mensurável" e fazer a edição do mesmo,
 * além de definir o layout da página.
 * 
 * @author carla
 */

public class TelaHabitoMensuravel implements ActionListener {
	private static JFrame container;
	private static JButton botaoAddLembrete;
	private static JButton adicionarHabito;
	private static JButton updateHabito;
	private static JButton botaoFeito;
	private static JTextField inputMeta;
	private static JTextField inputAnotacao;
	private static JTextField inputMinimo;
	private static JTextField inputNome;
	private static JLabel inserirNome;
	private static JLabel inserirAnotacao;
	private static JLabel inserirMinimo;
	private static JLabel inserirMeta;
	private static JLabel inserirLembrete;
	private static ControleDados dados;
	private JFormattedTextField inputHora;
	private static JButton deletarHabito;
	private static ControleUsuario dadosUsuario;
	private static ControleHabitos dadosHabitos;
	private static JButton deletarLembrete;
	private JComboBox<String> selecaoDias;
	private JList<String> lembretes;
	String[] dias = {
		"segunda-feira",
		"terça-feira",
		"quarta-feira",
		"quinta-feira",
		"sexta-feira",
		"sábado",
		"domingo"
	};
	String[] listaLembretes = new String[10];
	int qtdLembretes = 0;
	String[] diasEscolhidos = new String[10];
	String[] horariosEscolhidos = new String[10];
	String emailUsuario;
	int index;
	int indexLembrete = -1;
	
	/**
	 * Define os elementos presentes na tela de hábitos do tipo "mensurável"
	 * Recebe os dados necessários para realizar as operações, a posição (idx) do hábito
	 * no array habitoSimNao da classe Dados, o email do usuário e se a operação é de 
	 * edição do hábito.
	 * 
	 * <ol>
	 * 	<li>inputNome: recebe o nome do hábito;</li>
	 *  <li>inserirMinimo: recebe a quantidade mínimo que esse hábito deve ser realizado; </li>
	 *  <li>inserirMeta: recebe a meta do hábito;</li>
	 *  <li>inputAnotacao: recebe as anotações;</li>
	 *  <li>lembretes: lista de lembretes criados. Possui um método assiado para detectar a 
	 * posição do lembrete no array de lembretes;</li>
	 *  <li>botaoAddLembrete: possui um evento associado que adiciona o lembrete selecionado 
	 * da lista de lembretes;</li>
	 *  <li>deletarLembrete: possui um evento associado que deleta o lembrete selecionado 
	 * da lista de lembretes;</li>
	 *  <li>updateHabito: possui um evento associado que atualiza as informações do hábito
	 * selecionado;</li>
	 *  <li>deletarHabito: possui um evento associado que deleta o hábito selecionado;</li>
	 *  <li>botaoFeito: possui um evento associado que atualiza o hábito selecionado para "feito".</li>
	 * </ol>
	 * 
	 * @param email email do usuário
	 * @param d todos os dados salvos
	 * @param idx posição do hábito no array habitoSimNao da classe Dados
	 * @param editar define o tipo de operação
	 * 
	 * @see ControleHabitos
	 */
	
	public TelaHabitoMensuravel(String email, ControleDados d, int idx, boolean editar) {
		dados = d;
		emailUsuario = email;
		index = idx;
		
		dadosHabitos = new ControleHabitos();
		dadosUsuario = new ControleUsuario();
		container = new JFrame("Hábito Mensurável");
		botaoAddLembrete = new JButton("+ Lembrete");
		deletarLembrete = new JButton("- Lembrete");
		inserirLembrete = new JLabel("Adicionar lembrete:");
		inserirNome = new JLabel("Nome:");
		inserirAnotacao = new JLabel("Anotações:");
		inserirMinimo = new JLabel("Mínimo:");
		inserirMeta = new JLabel("Meta:");
		selecaoDias = new JComboBox<>(dias);
		botaoFeito = new JButton("Hábito feito");
		lembretes = new JList<String>(listaLembretes);

		if(editar) {
			inputNome = new JTextField(dados.getHabitosMensuraveis()[index].getNome());
			inputAnotacao = new JTextField(dados.getHabitosMensuraveis()[index].getAnotacoes());
			inputMinimo = new JTextField(dados.getHabitosMensuraveis()[index].getMinimo());
			inputMeta = new JTextField(dados.getHabitosMensuraveis()[index].getMeta());
			updateHabito = new JButton("Editar hábito");
			deletarHabito = new JButton("Deletar hábito");
			String[] listaLembretesCriados = dadosHabitos.getLembretesHabitosMensuraveis(dados, index);
			
			for(int i = 0; i < listaLembretesCriados.length; i++) {
				listaLembretes[i] = listaLembretesCriados[i];
			}
			
			qtdLembretes = listaLembretesCriados.length;
			
			updateHabito.setBounds(100, 630, 300, 30);
			deletarHabito.setBounds(100, 670, 300, 30);
			botaoFeito.setBounds(100, 710, 300, 30);
			
			container.add(deletarHabito);
			container.add(updateHabito);
			container.add(botaoFeito);
			
			deletarHabito.addActionListener(this);
			updateHabito.addActionListener(this);
			botaoFeito.addActionListener(this);
		} else {
			inputNome = new JTextField(10);
			inputAnotacao = new JTextField(10);
			inputMinimo = new JTextField(10);
			inputMeta = new JTextField(10);
			adicionarHabito = new JButton("Adicionar hábito");
			
			adicionarHabito.setBounds(100, 660, 300, 30);
			
			container.add(adicionarHabito);
			
			adicionarHabito.addActionListener(this);
		}
		
		
		try {
			inputHora = new JFormattedTextField(new MaskFormatter("## : ##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		container.getContentPane().setBackground(Color.getHSBColor(217, 228, 241));
		container.setTitle("Cadastro");
		container.setSize(500, 850);
		container.setLocation(500, 300);
		container.setLayout(null);
		
		inputNome.setBounds(100, 50, 300, 30);
		
		inserirNome.setFont(new Font("Arial", Font.BOLD, 16));
		inserirNome.setBounds(100, 10, 300, 30);
		
		inputAnotacao.setBounds(100, 290, 300, 30);
		
		inserirAnotacao.setFont(new Font("Arial", Font.BOLD, 16));
		inserirAnotacao.setBounds(100, 250, 300, 30);
		
		inputMinimo.setBounds(100, 210, 300, 30);
		
		inserirMinimo.setFont(new Font("Arial", Font.BOLD, 16));
		inserirMinimo.setBounds(100, 170, 300, 30);
		
		inputMeta.setBounds(100, 130, 300, 30);
		
		inserirMeta.setFont(new Font("Arial", Font.BOLD, 16));
		inserirMeta.setBounds(100, 90, 300, 30);
		
		inserirLembrete.setFont(new Font("Arial", Font.BOLD, 16));
		inserirLembrete.setBounds(100, 330, 300, 30);
		
		deletarLembrete.setBounds(280,410,120,30);
		
		botaoAddLembrete.setBounds(280,370,120,30);

		inputHora.setBounds(100, 370, 50, 30);
		
		selecaoDias.setBounds(100, 410, 140, 30);
		
		lembretes.setBounds(100, 450, 300, 170);
		
		container.add(botaoAddLembrete);
		container.add(inputNome);
		container.add(inputAnotacao);
		container.add(inputMinimo);
		container.add(inputMeta);
		container.add(inserirLembrete);
		container.add(inserirNome);
		container.add(inserirAnotacao);
		container.add(inserirMinimo);
		container.add(inserirMeta);
		container.add(selecaoDias);
		container.add(inputHora);
		container.add(lembretes);
		container.add(deletarLembrete);

		botaoAddLembrete.addActionListener(this);
		selecaoDias.addActionListener(this);
		deletarLembrete.addActionListener(this);
		lembretes.addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
				Object src = e.getSource();

				if(e.getValueIsAdjusting() && src == lembretes) {
					indexLembrete = lembretes.getSelectedIndex();
				}
		    }
		});
		
		container.setVisible(true);
	}
	
	/**
	 * Adiciona um lembrete a lista de lembretes quando um evento é disparado no componente "botaoAddLembrete", 
	 * caso a validação seja bem sucedida.
	 * É validado se: 
	 * <ol>
	 * 	<li>todos os campos devem ser preenchidos;</li>
	 *  <li>o horário escolhido deve ser um horário existente</li>
	 * </ol>
	 *  
	 * Deleta um lembrete da lista de lembretes quando um evento é disparado no componente "deletarLembrete"
	 * Adiciona um hábito quando um evento é disparado no componente "adicionarHabito"
	 * Deleta um hábito quando um evento é disparado no componente "deletarHabito"
	 * Atualiza um hábito para feito quando um evento é disparado no componente "botaoFeito"
	 * Atualiza as infortmações de um hábito quando um evento é disparado no componente "updateHabito"
	 * 
	 * Em todos os casos, se a operação não for bem sucedida, é gerado um aviso na tela contendo o problema.
	 * 
	 * @see ControleHabitos
	 */

	public void actionPerformed(ActionEvent e) {
		String nome = inputNome.getText().trim();
		String anotacao = inputAnotacao.getText().trim();
		String minimo = inputMinimo.getText().trim();
		String meta = inputMeta.getText().trim();
		String horario = inputHora.getText().trim();
		String[] horarioSemMascara = horario.split(" : ");
		boolean lembreteExiste = false;
		String mensagem = "";
		String diaEscolhido = null;
		int usuarioId = dadosUsuario.getIdUsuario(emailUsuario, dados);

		Object src = e.getSource();
		
		if(src == botaoAddLembrete) {
			diaEscolhido = selecaoDias.getItemAt(selecaoDias.getSelectedIndex());
			if(diaEscolhido != null && horarioSemMascara[0].matches("[0-9]{2}") && horarioSemMascara[1].matches("[0-9]{2}")) {
				int horas = Integer.parseInt(horarioSemMascara[0]);
				int minutos = Integer.parseInt(horarioSemMascara[1]);
				String lembrete = diaEscolhido + " - " + horario;
				if(qtdLembretes == 10) {
					JOptionPane.showMessageDialog(null, "Não é possível adicionar mais lembretes.", null, 
							JOptionPane.ERROR_MESSAGE);
					return;
				};
				for(int i = 0; i < qtdLembretes; i++) {
					if(listaLembretes[i].equals(lembrete)) {
						JOptionPane.showMessageDialog(null, "Esse lembrete já existe.", null, 
								JOptionPane.ERROR_MESSAGE);
						lembreteExiste = true;
						break;
					}
				}
				for(int i = 0; i < 10; i++) {
					if(lembreteExiste == true) {
						break;
					}
					if(horas < 1 || horas > 24) {
						JOptionPane.showMessageDialog(null, "Insira um horário válido.", null, 
								JOptionPane.ERROR_MESSAGE);
						break;
					}
					if(minutos < 0 || minutos > 59) {
						JOptionPane.showMessageDialog(null, "Insira um horário válido.", null, 
								JOptionPane.ERROR_MESSAGE);
						break;
					}
					if(diaEscolhido == null) {
						JOptionPane.showMessageDialog(null, "Escolha um dia da semana.", null, 
								JOptionPane.ERROR_MESSAGE);
						break;
					}
					if(listaLembretes[i] == null) {
						listaLembretes[i] = lembrete;
						diasEscolhidos[i] = diaEscolhido;
						horariosEscolhidos[i] = horario;
						qtdLembretes += 1;
						lembretes.updateUI();
						break;
					}
				} 
			} else {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos de lembrete", null, 
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(src == adicionarHabito) {
			
			mensagem = dadosHabitos.salvarHabitoMensuravel(
				dados,
				usuarioId,
				nome, 
				meta, 
				minimo, 
				anotacao, 
				horariosEscolhidos, 
				diasEscolhidos
			);
			if(!mensagem.equals("")) {
				JOptionPane.showMessageDialog(null, mensagem);
			} else {
				new TelaListaHabitos(emailUsuario, dados);
			}
		}
		
		if(src == updateHabito) {
			String[] horariosEscolhidos = new String[10];
			String[] diasEscolhidos = new String[10];
			
			for(int i = 0; i < qtdLembretes; i++) {
				if(listaLembretes[i] != null) {
					String[] lembreteFiltrado = listaLembretes[i].split(" - ");
					horariosEscolhidos[i] = lembreteFiltrado[1];
					diasEscolhidos[i] = lembreteFiltrado[0];
				}
			}
			
			mensagem = dadosHabitos.updateHabitosMensuraveis(
				dados,
				index,
				usuarioId,
				nome, 
				meta, 
				minimo, 
				anotacao, 
				horariosEscolhidos, 
				diasEscolhidos
			);
			if(!mensagem.equals("")) {
				JOptionPane.showMessageDialog(null, mensagem);
			} else {
				new TelaListaHabitos(emailUsuario, dados);
			}
		}
		
		if(src == deletarHabito) {
			dadosHabitos.deleteHabitoMensuravel(dados, index);
			JOptionPane.showMessageDialog(null, "Hábito deletado");
			new TelaListaHabitos(emailUsuario, dados);
		}
		
		if(src == deletarLembrete) {
			if(indexLembrete == -1) {
				JOptionPane.showMessageDialog(null, "Escolha um lembrete para deletar.", null, 
						JOptionPane.ERROR_MESSAGE);
			} else {
				qtdLembretes = qtdLembretes - 1;
				listaLembretes[indexLembrete] = null;
				lembretes.updateUI();
			}
		}
		
		if(src == botaoFeito) {
			String[] horariosEscolhidos = new String[10];
			String[] diasEscolhidos = new String[10];
			
			for(int i = 0; i < qtdLembretes; i++) {
				if(listaLembretes[i] != null) {
					String[] lembreteFiltrado = listaLembretes[i].split(" - ");
					horariosEscolhidos[i] = lembreteFiltrado[1];
					diasEscolhidos[i] = lembreteFiltrado[0];
				}
			}
			
			String habitoFeito = dadosHabitos.habitoMensuravelFeito(
					dados,
					index,
					usuarioId,
					nome, 
					meta, 
					minimo, 
					anotacao, 
					horariosEscolhidos, 
					diasEscolhidos
			);
			if(habitoFeito != "") {
				JOptionPane.showMessageDialog(null, habitoFeito, null, 
						JOptionPane.ERROR_MESSAGE);
			} else {
				new TelaListaHabitos(emailUsuario, dados);
			}
		}
	}
}
