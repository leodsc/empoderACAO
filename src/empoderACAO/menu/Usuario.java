package empoderACAO.menu;

// TODO: Auto-generated Javadoc
/**
 * Classe usuário que permite armazenar informações sobre o mesmo
 */
public class Usuario {
	
	/** Nome do usuário. */
	private String nome;
	
	/** Sexo do usuário. */
	private char sexo;
	
	/** Estado em que o usuário moda. */
	private String estado;
	
	/** Idade do usuário. */
	private int idade;

	/**
	 * Instancia um novo usuário.
	 *
	 * @param nome
	 * @param sexo
	 * @param estado
	 * @param idade
	 */
	public Usuario(String nome, char sexo, String estado, int idade) {
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.estado = estado;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public char getSexo() {
		return this.sexo;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public int getIdade() {
		return this.idade;
	}
}
