package modelo;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private boolean isOnline;
	private int id;
	
	public Usuario(String nome, String email, String senha, boolean isOnline, int id) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.isOnline = isOnline;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isOnline() {
		return isOnline;
	}
	
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
