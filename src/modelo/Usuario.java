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
	 * @param nome nome do usuário
	 * @param email email do usuário
	 * @param senha senha do usuário
	 * @param id identificador do usuário
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
	 * @return nome nome do usuário
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
	 * @param email email do usuário
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
	 * @param senha senha do usuário
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
	 * @param id identificador do usuário
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
}
