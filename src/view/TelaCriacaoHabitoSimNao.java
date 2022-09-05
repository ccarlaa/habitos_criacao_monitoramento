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
import javax.swing.text.MaskFormatter;
import controle.ControleDados;
import controle.ControleUsuario;

public class TelaCriacaoHabitoSimNao implements ActionListener {
	private static JFrame container;
	private static JButton botaoAddLembrete;
	private static JButton adicionarHabito;
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
	
	public TelaCriacaoHabitoSimNao(String email, ControleDados d) {
		dados = d;
		emailUsuario = email;
		
		dadosUsuario = new ControleUsuario();
		container = new JFrame("Cadastro");
		botaoAddLembrete = new JButton("+ Lembrete");
		adicionarHabito = new JButton("Adicionar hábito");
		inputNome = new JTextField(10);
		inputAnotacao = new JTextField(10);
		inputFrequencia = new JTextField(10);
		inserirLembrete = new JLabel("Adicionar lembrete:");
		inserirNome = new JLabel("Nome:");
		inserirAnotacao = new JLabel("Anotações:");
		inserirFrequencia = new JLabel("Frequência:");
		lembretes = new JList<String>(listaLembretes);
		selecaoDias = new JComboBox<>(dias);
		
		try {
			inputHora = new JFormattedTextField(new MaskFormatter("## : ##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		container.getContentPane().setBackground(Color.getHSBColor(217, 228, 241));
		container.setTitle("Cadastro");
		container.setSize(500, 700);
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

		inputHora.setBounds(100, 290, 110, 30);
		
		selecaoDias.setBounds(100, 330, 110, 30);
		
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
		container.add(adicionarHabito);
		
		botaoAddLembrete.addActionListener(this);
		adicionarHabito.addActionListener(this);
		selecaoDias.addActionListener(this);
		
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
			mensagem = dados.salvarHabitoSimNao(
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
	}
}
