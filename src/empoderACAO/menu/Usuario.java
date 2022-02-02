package empoderACAO.menu;

public class Usuario {
	private String nome;
	private char sexo;
	private String estado;
	private int idade;

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
}
