package view;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class CriarConta implements ActionListener {
	private static JFrame container;
	private static JButton botao;
	private static JTextField inputEmail;
	private static JTextField inputSenha;
	private static JTextField inputConfirmaSenha;
	private static JLabel inserirSenha;
	private static JLabel inserirEmail;
	private static JLabel inserirSenhaNovamente;
	
	public CriarConta() {
		container = new JFrame("Cadastro");
		botao = new JButton("Cadastrar");
		inputEmail = new JTextField(10);
		inputSenha = new JTextField(10);
		inputConfirmaSenha = new JTextField(10);
		inserirEmail = new JLabel("Insira seu email:");
		inserirSenha = new JLabel("Insira sua senha:");
		inserirSenhaNovamente = new JLabel("Repita sua senha:");
		
		container.setTitle("Cadastro");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setLayout(null);
		
		inserirEmail.setFont(new Font("Arial", Font.BOLD, 16));
		inserirEmail.setBounds(100, 10, 300, 30);
		
		inserirSenha.setFont(new Font("Arial", Font.BOLD, 16));
		inserirSenha.setBounds(100, 90, 300, 30);
		
		inserirSenhaNovamente.setFont(new Font("Arial", Font.BOLD, 16));
		inserirSenhaNovamente.setBounds(100, 170, 300, 30);
		
		inputEmail.setBounds(100, 50, 300, 30);
		inputSenha.setBounds(100, 130, 300, 30);
		inputConfirmaSenha.setBounds(100, 210, 300, 30);
		botao.setBounds(190,300,120,30);
		
		
		
		container.add(inserirEmail);
		container.add(inputEmail);
		container.add(inserirSenha);
		container.add(inputSenha);
		container.add(inserirSenhaNovamente);
		container.add(inputConfirmaSenha);
		container.add(botao);
		
		container.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String email = inputEmail.getText();
		String senha = inputSenha.getText();
		String confirmaSenha = inputConfirmaSenha.getText();
		
		JOptionPane.showMessageDialog(null,"Email: " + email + "\n" +
				"Senha: " + senha + "\n" + "confirmar senha: " + confirmaSenha);
	}
	
	public static void main(String[] args) {
		CriarConta criarConta = new CriarConta();
		botao.addActionListener(criarConta);
	}
}
