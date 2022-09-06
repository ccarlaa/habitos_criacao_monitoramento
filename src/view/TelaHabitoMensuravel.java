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

public class TelaHabitoMensuravel implements ActionListener {
	private static JFrame container;
	private static JButton botaoAddLembrete;
	private static JButton adicionarHabito;
	private static JTextField inputMeta;
	private static JTextField inputAnotacao;
	private static JTextField inputMinimo;
	private static JTextField inputNome;
	private static JLabel inserirNome;
	private static JLabel inserirAnotacao;
	private static JLabel inserirUnidade;
	private static JLabel inserirMeta;
	private static JLabel inserirLembrete;
	private static ControleDados dados;
	private JFormattedTextField inputHora;
	private static ControleUsuario dadosUsuario;
	private static ControleHabitos dadosHabitos;
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
	
	public TelaHabitoMensuravel(String email, ControleDados d, int index, boolean editar) {
		dados = d;
		emailUsuario = email;
		
		dadosHabitos = new ControleHabitos();
		dadosUsuario = new ControleUsuario();
		container = new JFrame("Hábito Mensurável");
		botaoAddLembrete = new JButton("+ Lembrete");
		inserirLembrete = new JLabel("Adicionar lembrete:");
		inserirNome = new JLabel("Nome:");
		inserirAnotacao = new JLabel("Anotações:");
		inserirUnidade = new JLabel("Mínimo:");
		inserirMeta = new JLabel("Meta:");
		selecaoDias = new JComboBox<>(dias);
		
		if(editar) {
			inputNome = new JTextField(dados.getHabitosMensuraveis()[index].getNome());
			inputAnotacao = new JTextField(dados.getHabitosMensuraveis()[index].getAnotacoes());
			inputMinimo = new JTextField(dados.getHabitosMensuraveis()[index].getMinimo());
			inputMeta = new JTextField(dados.getHabitosMensuraveis()[index].getMeta());
			adicionarHabito = new JButton("Editar hábito");
			String[] listaLembretesCriados = dadosHabitos.getLembretes(dados, index);
			for(int i = 0; i < listaLembretesCriados.length; i++) {
				listaLembretes[i] = listaLembretesCriados[i];
			}
			qtdLembretes = listaLembretesCriados.length;
		} else {
			inputNome = new JTextField(10);
			inputAnotacao = new JTextField(10);
			inputMinimo = new JTextField(10);
			inputMeta = new JTextField(10);
			lembretes = new JList<String>(listaLembretes);
			adicionarHabito = new JButton("Adicionar hábito");
		}
		
		lembretes = new JList<String>(listaLembretes);
		
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
		
		inputNome.setBounds(100, 50, 300, 30);
		
		inserirNome.setFont(new Font("Arial", Font.BOLD, 16));
		inserirNome.setBounds(100, 10, 300, 30);
		
		inputAnotacao.setBounds(100, 290, 300, 30);
		
		inserirAnotacao.setFont(new Font("Arial", Font.BOLD, 16));
		inserirAnotacao.setBounds(100, 250, 300, 30);
		
		inputMinimo.setBounds(100, 210, 300, 30);
		
		inserirUnidade.setFont(new Font("Arial", Font.BOLD, 16));
		inserirUnidade.setBounds(100, 170, 300, 30);
		
		inputMeta.setBounds(100, 130, 300, 30);
		
		inserirMeta.setFont(new Font("Arial", Font.BOLD, 16));
		inserirMeta.setBounds(100, 90, 300, 30);
		
		inserirLembrete.setFont(new Font("Arial", Font.BOLD, 16));
		inserirLembrete.setBounds(100, 330, 300, 30);
		
		botaoAddLembrete.setBounds(280,370,120,30);

		inputHora.setBounds(100, 370, 50, 30);
		
		selecaoDias.setBounds(100, 410, 140, 30);
		
		lembretes.setBounds(100, 450, 300, 170);
		
		adicionarHabito.setBounds(100, 660, 300, 30);
		
		container.add(botaoAddLembrete);
		container.add(inputNome);
		container.add(inputAnotacao);
		container.add(inputMinimo);
		container.add(inputMeta);
		container.add(inserirLembrete);
		container.add(inserirNome);
		container.add(inserirAnotacao);
		container.add(inserirUnidade);
		container.add(inserirMeta);
		container.add(selecaoDias);
		container.add(inputHora);
		container.add(lembretes);
		container.add(adicionarHabito);
		
		botaoAddLembrete.addActionListener(this);
		adicionarHabito.addActionListener(this);
		selecaoDias.addActionListener(this);
		lembretes.addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
				Object src = e.getSource();

				if(e.getValueIsAdjusting() && src == lembretes) {
					int index = lembretes.getSelectedIndex();
				}
		    }
		});
		
		container.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String nome = inputNome.getText();
		String anotacao = inputAnotacao.getText();
		String minimo = inputMinimo.getText();
		String meta = inputMeta.getText();
		String horario = inputHora.getText();
		String[] horarioSemMascara = horario.split(" : ");
		boolean lembreteExiste = false;
		String mensagem = "";
		String diaEscolhido = null;
		
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
			int usuarioId = dadosUsuario.getIdUsuario(emailUsuario, dados);
			mensagem = dados.salvarHabitoMensuravel(
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
	}
}