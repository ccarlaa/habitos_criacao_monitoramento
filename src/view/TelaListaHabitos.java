package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import controle.ControleDados;
import controle.ControleHabitos;
import controle.ControleUsuario;
import modelo.HabitoMensuravel;

public class TelaListaHabitos implements ActionListener {
	private JList<String> listaHabitosMensuraveis;
	private JList<String> listaHabitosSimNao;
	private static JFrame container;
	private static JButton botao1;
	private static JButton botao2;
	private JLabel dia;
	private JLabel habitosMensuraveis;
	private JLabel habitosSimNao;
	private  ControleDados dados;
	private  ControleHabitos dadosHabitos;
	private  ControleUsuario dadosUsuario;
	String emailUsuario;
	
	public TelaListaHabitos(String email,ControleDados d) {
		dadosHabitos = new ControleHabitos();
		dadosUsuario = new ControleUsuario();
		dados = d;
		emailUsuario = email;
		
		int usuarioId = dadosUsuario.getIdUsuario(email, dados);
		String[] listaHabitosMensuraveisInfos = dadosHabitos.getHabitosMensuraveis(dados, usuarioId);

		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEEE");

		container = new JFrame("Hábitos");
		dia = new JLabel(df.format(date));
		habitosMensuraveis = new JLabel("Hábitos Mensuráveis:");
		habitosSimNao = new JLabel("Hábitos Sim Não:");
		botao1 = new JButton("Mensurável");
		botao2 = new JButton("Sim ou Não");
		listaHabitosMensuraveis = new JList<String>(listaHabitosMensuraveisInfos);
		listaHabitosSimNao = new JList<String>();

		container.getContentPane().setBackground(Color.getHSBColor(217, 228, 241));
		container.setTitle("Hábitos");
		container.setSize(500, 600);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setLayout(null);
		
		dia.setFont(new Font("Arial", Font.BOLD, 20));
		dia.setBounds(10, 10, 300, 30);
		
		habitosMensuraveis.setBounds(10,60,200,30);
		habitosMensuraveis.setFont(new Font("Arial", Font.BOLD, 16));
		
		habitosSimNao.setBounds(10,315,200,30);
		habitosSimNao.setFont(new Font("Arial", Font.BOLD, 16));
		
		listaHabitosMensuraveis.setBounds(10, 100, 300, 200);
		listaHabitosSimNao.setBounds(10, 350, 300, 200);
		
		botao1.setBounds(330, 100, 150, 40);
		botao2.setBounds(330, 350, 150, 40);
		
		container.add(dia);
		container.add(habitosMensuraveis);
		container.add(habitosSimNao);
		container.add(listaHabitosMensuraveis);
		container.add(listaHabitosSimNao);
		container.add(botao1);
		container.add(botao2);
		
		container.setVisible(true);
		
		botao1.addActionListener(this);
		botao2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botao1) {
			new TelaCriacaoHabitoMensuravel(emailUsuario, dados);
		}
		
		if(src == botao2) {
			new TelaCriacaoHabitoSimNao(emailUsuario, dados);
		}
	}
}
