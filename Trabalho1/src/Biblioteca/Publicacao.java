package Biblioteca;

public abstract class Publicacao {
	private int codigo; 
	private String titulo;
	private String genero;
	private String faixaEtaria;
	
	public Publicacao(String titulo, String genero, String faixaEtaria, Boolean isBook, int codigo) {
		this.titulo = titulo;
		this.genero = genero;
		this.faixaEtaria = faixaEtaria;
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	
}
