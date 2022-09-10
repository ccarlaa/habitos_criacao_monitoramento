package view;

import controle.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 * TelaLogin é responsável por realizar o login do usuário
 * por meio da insercão do email e da senha pré cadastrados
 */

public class TelaLogin implements ActionListener{
	
	private static JFrame container;
	private static JButton botao;
	private static JTextField inputEmail;
	private static JPasswordField inputSenha;
	private static JLabel inserirSenha;
	private static JLabel inserirEmail;
	private static JLabel criarConta;
	private static ControleDados dados;
	private static ControleUsuario dadosUsuario = new ControleUsuario();
	
	/**
	 * Define os componentes presentes na página de login.
	 * Recebe os dados necessários para realizar o login do usuário.
	 * 
	 * <ol>
	 * 	<li>inputEmail: recebe o email do usuário;</li>
	 *  <li>inputSenha: recebe a senha do usuário</li>
	 *  <li>botao: possui um evento associado que quando disparado efetua o login do usuário</li>
	 *  <li>criarConta: redireciona o usuário para página de cadastro</li>
	 * </ol>
	 * 
	 * @param d todos os dados salvos
	 */
	
	public TelaLogin(ControleDados d) {
		dados = d;
		
		container = new JFrame("Cadastro");
		botao = new JButton("Logar");
		inputEmail = new JTextField(10);
		inputSenha = new JPasswordField(10);
		inserirEmail = new JLabel("Insira seu email:");
		inserirSenha = new JLabel("Insira sua senha:");
		criarConta = new JLabel("Não tem conta? Cadastre-se!");
		
		container.getContentPane().setBackground(Color.getHSBColor(217, 228, 241));
		container.setTitle("Cadastro");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setLayout(null);
		
		inputEmail.setBounds(100, 130, 300, 30);
		
		inserirEmail.setFont(new Font("Arial", Font.BOLD, 16));
		inserirEmail.setBounds(100, 90, 300, 30);
		
		inputSenha.setBounds(100, 210, 300, 30);
		
		inserirSenha.setFont(new Font("Arial", Font.BOLD, 16));
		inserirSenha.setBounds(100, 170, 300, 30);
		
		botao.setBounds(190,320,120,30);
		
		criarConta.setFont(new Font("Arial", Font.BOLD, 14));
		criarConta.setForeground(Color.getHSBColor(226, 40, 27));
		criarConta.setBounds(130, 350, 300, 30);
		
		container.add(inserirEmail);
		container.add(inputEmail);
		container.add(inserirSenha);
		container.add(inputSenha);
		container.add(botao);
		container.add(criarConta);
		
		container.setVisible(true);
		
		botao.addActionListener(this);
		criarConta.addMouseListener(new MouseAdapter() {
		      @Override
		      public void mouseClicked(MouseEvent e) {
		    	  new TelaCriacaoConta(); 
		      }
		    }
		);
	}
	
	/**
	 * Quando um evento é disparado no componente "botao" realiza o login do usuário.
	 * Se o login não foi realizadado, é mostrado um aviso na tela, caso contrário o usuário
	 * é direcionado para a página de hábitos.
	 * 
	 * @see ControleUsuario
	 * @see TelaListaHabitos
	 * @see TelaCriacaoConta
	 */
	
	public void actionPerformed(ActionEvent e) {
		String email = inputEmail.getText();
		char[] senha = inputSenha.getPassword();
		
		String stringSenha = String.valueOf(senha);
		
		Object src = e.getSource();
		String res = "";
		
		if(src == botao) {
			res = dadosUsuario.logar(dados, email, stringSenha);
		}
		if(!res.equals("")) {
			JOptionPane.showMessageDialog(null, res, null, 
					JOptionPane.ERROR_MESSAGE);
		} else {
			new TelaListaHabitos(email, dados);
		}
	}
	
}