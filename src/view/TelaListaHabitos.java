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

public class TelaListaHabitos implements ActionListener{
	private JList<String> listaHabitos;
	private static JFrame container;
	private static JButton botao1;
	private static JButton botao2;
	private JLabel dia;
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
		botao1 = new JButton("Mensurável");
		botao2 = new JButton("Sim ou Não");
		listaHabitos = new JList<String>(listaHabitosMensuraveisInfos);

		container.getContentPane().setBackground(Color.getHSBColor(217, 228, 241));
		container.setTitle("Hábitos");
		container.setSize(500, 600);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setLayout(null);
		
		dia.setFont(new Font("Arial", Font.BOLD, 20));
		dia.setBounds(10, 10, 300, 30);
		
		listaHabitos.setBounds(10, 50, 300, 400);
		
		botao1.setBounds(330, 50, 150, 40);
		botao2.setBounds(330, 100, 150, 40);
		
		container.add(dia);
		container.add(listaHabitos);
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
	}
}
