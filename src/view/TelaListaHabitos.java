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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleDados;
import controle.ControleHabitos;
import controle.ControleUsuario;

/**
 * Responsável por definir o layout da tela de hábitos, além de possibilitar que o usuário
 * possa escolher criar novos hábitos, ver os hábitos previstos para o dia atual e editá-los
 * 
 * @author carla
 */

public class TelaListaHabitos implements ActionListener, ListSelectionListener {
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
	private String[] listaHabitosMensuraveisInfos;
	private String[] listaHabitosSimNaoInfos;
	String diaEscolhido;
	String emailUsuario;
	String[] arrayDeDias = new String[7];
	String[] dias = {
			"segunda-feira",
			"terça-feira",
			"quarta-feira",
			"quinta-feira",
			"sexta-feira",
			"sábado",
			"domingo"
		};
	
	/**
	 * Define os elementos presentes na tela de hábitos.
	 * 
	 * - listaHabitosMensuraveis: mostra os hábitos do tipo "mensurável" previstos para serem realizados 
	 * no dia atual. Possui um evento associado, que quando disparado (ao clicar em um dos hábitos) redireciona
	 * o usuário para página de edição do hábito.
	 * - listaHabitosSimNao: mostra os hábitos do tipo "sim não" previstos para serem realizados 
	 * no dia atual. Possui um evento associado, que quando disparado (ao clicar em um dos hábitos) redireciona
	 * o usuário para página de edição do hábito.
	 * - botao1: Possui um evento associado que quando disparado direciona o usuário para página de criação de 
	 * hábito do tipo "mensurável"
	 * - botao2: Possui um evento associado que quando disparado direciona o usuário para página de criação de 
	 * hábito do tipo "sim não"
	 * 
	 * @param email
	 * @param d
	 */
	
	public TelaListaHabitos(String email,ControleDados d) {
		dadosHabitos = new ControleHabitos();
		dadosUsuario = new ControleUsuario();
		dados = d;
		emailUsuario = email;

		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEEE");

		int usuarioId = dadosUsuario.getIdUsuario(email, dados);
		listaHabitosMensuraveisInfos = dadosHabitos.getHabitosMensuraveis(dados, usuarioId);
		listaHabitosSimNaoInfos = dadosHabitos.getHabitosSimNao(dados, usuarioId);
		
		container = new JFrame("Hábitos");
		dia = new JLabel("Hoje é " + df.format(date));
		habitosMensuraveis = new JLabel("Hábitos Mensuráveis:");
		habitosSimNao = new JLabel("Hábitos Sim Não:");
		botao1 = new JButton("Mensurável");
		botao2 = new JButton("Sim ou Não");
		listaHabitosMensuraveis = new JList<String>(listaHabitosMensuraveisInfos);
		listaHabitosSimNao = new JList<String>(listaHabitosSimNaoInfos);
		
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
		listaHabitosMensuraveis.addListSelectionListener(this);
		listaHabitosSimNao.addListSelectionListener(this);
	}
	
	/**
	 * Quando um evento é disparado no componente "botao1" redireciona o usuário para a página
	 * de criação de hábito do tipo "mensurável".
	 * Quando um evento é disparado no componente "botao2" redireciona o usuário para a página
	 * de criação de hábito do tipo "sim não".
	 * 
	 * @see TelaHabitoMensuravel
	 * @see TelaHabitoSimNao
	 */
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botao1) {
			new TelaHabitoMensuravel(emailUsuario, dados, -1, false);
		}
		
		if(src == botao2) {
			new TelaHabitoSimNao(emailUsuario, dados, -1, false);
		}
	}
	/**
	 * Quando um evento é disparado na lista de hábitos do tipo "mensurável" redireciona o usuário para a página
	 * de edição de hábito do tipo "mensurável".
	 * Quando um evento é disparado na lista de hábitos do tipo "sim não" redireciona o usuário para a página
	 * de edição de hábito do tipo "sim não".
	 * 
	 * @see TelaHabitoMensuravel
	 * @see TelaHabitoSimNao
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaHabitosMensuraveis) {
			int index = listaHabitosMensuraveis.getSelectedIndex();
			new TelaHabitoMensuravel(emailUsuario, dados, index, true);
		}
		if(e.getValueIsAdjusting() && src == listaHabitosSimNao) {
			int index = listaHabitosSimNao.getSelectedIndex();
			System.out.println("oe");
			new TelaHabitoSimNao(emailUsuario, dados, index, true);
		}
	}
}
