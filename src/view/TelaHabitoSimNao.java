package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import controle.ControleDados;
import controle.ControleHabitos;
import controle.ControleUsuario;

public class TelaHabitoSimNao implements ActionListener {
	private static JFrame container;
	private static JButton botaoAddLembrete;
	private static JButton botaoFeito;
	private static JButton adicionarHabito;
	private static JButton updateHabito;
	private static JTextField inputFrequencia;
	private static JTextField inputAnotacao;
	private static JTextField inputNome;
	private static JLabel inserirNome;
	private static JLabel inserirAnotacao;
	private static JLabel inserirFrequencia;
	private static JLabel inserirLembrete;
	private static ControleDados dados;
	private JFormattedTextField inputHora;
	private static ControleUsuario dadosUsuario;
	private static ControleHabitos dadosHabitos;
	private static JButton deletarLembrete;
	private static JButton deletarHabito;
	private JList<String> lembretes;
	private JComboBox<String> selecaoDias;
	
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
	String diaEscolhido;
	int qtdLembretes = 0;
	String[] diasEscolhidos = new String[10];
	String[] horariosEscolhidos = new String[10];
	String emailUsuario;
	int index;
	int indexLembrete = -1;
	
	public TelaHabitoSimNao(String email, ControleDados d, int idx, boolean editar) {
		dados = d;
		emailUsuario = email;
		index = idx;
		
		dadosUsuario = new ControleUsuario();
		dadosHabitos = new ControleHabitos();
		container = new JFrame("Cadastro");
		botaoAddLembrete = new JButton("+ Lembrete");
		deletarLembrete = new JButton("- Lembrete");
		adicionarHabito = new JButton("Adicionar hábito");
		botaoFeito = new JButton("Hábito feito");
		inserirLembrete = new JLabel("Adicionar lembrete:");
		inserirNome = new JLabel("Nome:");
		inserirAnotacao = new JLabel("Anotações:");
		inserirFrequencia = new JLabel("Frequência:");
		lembretes = new JList<String>(listaLembretes);
		selecaoDias = new JComboBox<>(dias);
		
		if(editar) {
			inputNome = new JTextField(dados.getHabitosSimNao()[index].getNome());
			inputAnotacao = new JTextField(dados.getHabitosSimNao()[index].getAnotacoes());
			inputFrequencia = new JTextField(dados.getHabitosSimNao()[index].getFrequenciaPrevista());
			updateHabito = new JButton("Editar hábito");
			deletarHabito = new JButton("Deletar hábito");
			String[] listaLembretesCriados = dadosHabitos.getLembretesHabitosSimNao(dados, index);
			
			for(int i = 0; i < listaLembretesCriados.length; i++) {
				listaLembretes[i] = listaLembretesCriados[i];
			}
			
			qtdLembretes = listaLembretesCriados.length;
			
			updateHabito.setBounds(100, 590, 300, 30);
			deletarHabito.setBounds(100, 630, 300, 30);
			botaoFeito.setBounds(100, 670, 300, 30);
			
			container.add(deletarHabito);
			container.add(updateHabito);
			container.add(botaoFeito);
			
			deletarHabito.addActionListener(this);
			updateHabito.addActionListener(this);
			botaoFeito.addActionListener(this);
		} else {
			inputNome = new JTextField(10);
			inputAnotacao = new JTextField(10);
			inputFrequencia = new JTextField(10);
			lembretes = new JList<String>(listaLembretes);
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
		container.setSize(500, 750);
		container.setLocation(500, 300);
		container.setLayout(null);
		
		inserirNome.setFont(new Font("Arial", Font.BOLD, 16));
		inserirNome.setBounds(100, 10, 300, 30);
		
		inputNome.setBounds(100, 50, 300, 30);
		
		inserirFrequencia.setFont(new Font("Arial", Font.BOLD, 16));
		inserirFrequencia.setBounds(100, 90, 300, 30);
		
		inputFrequencia.setBounds(100, 130, 300, 30);
		
		inserirAnotacao.setFont(new Font("Arial", Font.BOLD, 16));
		inserirAnotacao.setBounds(100, 170, 300, 30);
		
		inputAnotacao.setBounds(100, 210, 300, 30);
		
		inserirLembrete.setFont(new Font("Arial", Font.BOLD, 16));
		inserirLembrete.setBounds(100, 250, 300, 30);
		
		botaoAddLembrete.setBounds(280,290,120,30);
		
		deletarLembrete.setBounds(280,330,120,30);

		inputHora.setBounds(100, 290, 50, 30);
		
		selecaoDias.setBounds(100, 330, 140, 30);
		
		lembretes.setBounds(100, 380, 300, 170);
		
		adicionarHabito.setBounds(100, 600, 300, 30);
		
		container.add(botaoAddLembrete);
		container.add(inputNome);
		container.add(inputAnotacao);
		container.add(inputFrequencia);
		container.add(inserirLembrete);
		container.add(inserirNome);
		container.add(inserirAnotacao);
		container.add(inserirFrequencia);
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

	public void actionPerformed(ActionEvent e) {
		String nome = inputNome.getText();
		String anotacao = inputAnotacao.getText();
		String frequencia = inputFrequencia.getText();
		String horario = inputHora.getText();
		String[] horarioSemMascara = horario.split(" : ");
		boolean lembreteExiste = false;
		String mensagem = "";
		int usuarioId = dadosUsuario.getIdUsuario(emailUsuario, dados);
		
		Object src = e.getSource();
		
		if(src == botaoAddLembrete) {
			diaEscolhido = selecaoDias.getItemAt(selecaoDias.getSelectedIndex());
			if(diaEscolhido != null && 
				horarioSemMascara[0].matches("[0-9]{2}") 
				&& horarioSemMascara[1].matches("[0-9]{2}"
			)) {
				int horas = Integer.parseInt(horarioSemMascara[0]);
				int minutos = Integer.parseInt(horarioSemMascara[1]);
				String lembrete = diaEscolhido + " - " + horario;
				
				if(qtdLembretes == 10) {
					JOptionPane.showMessageDialog(null, "Não é possível adicionar mais lembretes.", null, 
							JOptionPane.ERROR_MESSAGE);
				};
				
				for(int i = 0; i < qtdLembretes; i++) {
					if(listaLembretes[i].equals(lembrete)) {
						JOptionPane.showMessageDialog(null, "Esse lembrete já existe.", null, 
								JOptionPane.ERROR_MESSAGE);
						lembreteExiste = true;
						break;
					}
				};
				
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
				};
			} else {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos de lembrete", null, 
						JOptionPane.ERROR_MESSAGE);
			}
		};
		
		if(src == adicionarHabito) {
			mensagem = dadosHabitos.salvarHabitoSimNao(
				dados,
				usuarioId,
				nome, 
				frequencia, 
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
			
			mensagem = dadosHabitos.updateHabitosSimNao(
				dados,
				index,
				usuarioId,
				nome, 
				frequencia, 
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
			dadosHabitos.deletarHabitoSimNao(dados, index);
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
			
			String habitoFeito = dadosHabitos.habitoSimNaoFeito(
					dados, 
					index, 
					usuarioId, 
					nome, 
					frequencia, 
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
