package view;
import controle.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class TelaCriacaoConta implements ActionListener {
	private static JFrame container;
	private static JButton botao;
	private static JTextField inputEmail;
	private static JPasswordField inputSenha;
	private static JPasswordField inputSenhaRepetida;
	private static JTextField inputNome;
	private static JLabel inserirNome;
	private static JLabel inserirSenha;
	private static JLabel inserirEmail;
	private static JLabel inserirSenhaNovamente;
	private static JLabel login;
	private static ControleDados dados = new ControleDados();
	
	public TelaCriacaoConta() {
		
		container = new JFrame("Cadastro");
		botao = new JButton("Cadastrar");
		inputNome = new JTextField(10);
		inputEmail = new JTextField(10);
		inputSenha = new JPasswordField(10);
		inputSenhaRepetida = new JPasswordField(10);
		inserirNome = new JLabel("Insira seu nome:");
		inserirEmail = new JLabel("Insira seu email:");
		inserirSenha = new JLabel("Insira sua senha:");
		inserirSenhaNovamente = new JLabel("Repita sua senha:");
		login = new JLabel("Já tem conta? Faça login!");
		
		container.getContentPane().setBackground(Color.getHSBColor(217, 228, 241));
		container.setTitle("Cadastro");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setLayout(null);
		
		inputNome.setBounds(100, 50, 300, 30);
		
		inserirNome.setFont(new Font("Arial", Font.BOLD, 16));
		inserirNome.setBounds(100, 10, 300, 30);
		
		inputEmail.setBounds(100, 130, 300, 30);
		
		inserirEmail.setFont(new Font("Arial", Font.BOLD, 16));
		inserirEmail.setBounds(100, 90, 300, 30);
		
		inputSenha.setBounds(100, 210, 300, 30);
		
		inserirSenha.setFont(new Font("Arial", Font.BOLD, 16));
		inserirSenha.setBounds(100, 170, 300, 30);
		
		inputSenhaRepetida.setBounds(100, 290, 300, 30);
		
		inserirSenhaNovamente.setFont(new Font("Arial", Font.BOLD, 16));
		inserirSenhaNovamente.setBounds(100, 250, 300, 30);
		
		botao.setBounds(190,370,120,30);
		
		login.setFont(new Font("Arial", Font.BOLD, 14));
		login.setForeground(Color.getHSBColor(226, 40, 27));
		login.setBounds(150, 400, 300, 30);
		
		container.add(inserirNome);
		container.add(inputNome);
		container.add(inserirEmail);
		container.add(inputEmail);
		container.add(inserirSenha);
		container.add(inputSenha);
		container.add(inserirSenhaNovamente);
		container.add(inputSenhaRepetida);
		container.add(botao);
		container.add(login);
		
		botao.addActionListener(this);
		login.addMouseListener(new MouseAdapter() {
		      @Override
		      public void mouseClicked(MouseEvent e) {
		    	  new TelaLogin(dados); 
		      }
		    }
		);
		
		container.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String nome = inputNome.getText();
		String email = inputEmail.getText();
		char[] senha = inputSenha.getPassword();
		char[] senhaRepetida = inputSenhaRepetida.getPassword();
		
		String stringSenha = String.valueOf(senha);
		String stringSenhaRepetida = String.valueOf(senhaRepetida);
		
		Object src = e.getSource();
		String res = "";
		
		if(src == botao) {
			res = dados.criarUsuario(nome, email, stringSenha, stringSenhaRepetida);	
		}
		if(!res.equals("")) {
			JOptionPane.showMessageDialog(null, res, null, 
					JOptionPane.ERROR_MESSAGE);
		} else {
			new TelaLogin(dados);
		}
	}
	
	public static void main(String[] args) {
		 new TelaCriacaoConta();
	}
}
