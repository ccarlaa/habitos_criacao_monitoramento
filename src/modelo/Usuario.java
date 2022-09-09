package modelo;

/**
 * @author carla
 * 
 *Define os métodos e atributos da classe usuário
 */

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private int id;
	
	/**
	 * Método construtor da classe usuário
	 * 
	 * @param nome
	 * @param email
	 * @param senha
	 * @param id
	 */
	
	public Usuario(String nome, String email, String senha, int id) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	/**
	 * Retorna o nome do usuário
	 * 
	 * @return nome
	 */

	public String getNome() {
		return nome;
	}
	
	/**
	 * Define o nome do usuário
	 * 
	 * @param nome
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o email do usuário
	 * 
	 * @return email
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * Define o email do usuário
	 * 
	 * @param email
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Retorna a senha do usuário
	 * 
	 * @return senha
	 */
	
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Define o nome do usuário
	 * 
	 * @param senha
	 */
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Retorna o identificador do usuário
	 * 
	 * @return id
	 */

	public int getId() {
		return id;
	}

	/**
	 * Define o identificador do usuário
	 * 
	 * @param id
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
}
