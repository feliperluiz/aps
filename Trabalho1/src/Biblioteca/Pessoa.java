package Biblioteca;

public abstract class Pessoa {

	private String nome;
	private int idade;
	private String endereco;
	private String filiacao;
	private int codPessoa;

	public Pessoa(int codPessoa, String nome, int idade, String endereco, String filiacao) {
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.filiacao = filiacao;
		this.codPessoa = codPessoa;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getFiliacao() {
		return filiacao;
	}
	public void setFiliacao(String filiacao) {
		this.filiacao = filiacao;
	}

	public int getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	

}
