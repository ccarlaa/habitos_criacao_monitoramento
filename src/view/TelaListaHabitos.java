package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;


import controle.ControleDados;

public class TelaListaHabitos {
	private JList<String> listaHabitos;
	private static JFrame container;
	private static JButton novoHabitoMensuravel;
	private static JButton novoHabitoSimNao;
	private Date data;
	private JLabel dia;
	
	
	public TelaListaHabitos() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEEE");

		container = new JFrame("Hábitos");
		dia = new JLabel(df.format(date));
		novoHabitoMensuravel = new JButton("+ Mensurável");
		novoHabitoSimNao = new JButton("+ Sim ou Não");
		listaHabitos = new JList<String>();

		container.getContentPane().setBackground(Color.getHSBColor(217, 228, 241));
		container.setTitle("Hábitos");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setLayout(null);
		
		dia.setFont(new Font("Arial", Font.BOLD, 20));
		dia.setBounds(10, 10, 300, 30);
		
		listaHabitos.setBounds(10, 50, 300, 400);
		
		novoHabitoMensuravel.setBounds(330, 50,150, 40);
		novoHabitoSimNao.setBounds(330, 100, 150, 40);
		
		container.add(dia);
		container.add(listaHabitos);
		container.add(novoHabitoMensuravel);
		container.add(novoHabitoSimNao);
		
		container.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		 new TelaListaHabitos();

	}
}
